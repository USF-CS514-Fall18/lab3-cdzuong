package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Math.sqrt;

public class RatingsCollection {
    private TreeMap<Integer, TreeMap<Integer, Double>> ratingsMap;
    private int userMax;
    private ArrayList<Movie> movieList;
    private TreeMap<Double, TreeMap<Integer, Movie>> rankMovies;

    /**
     * RatingsCollection constructor.
     */
    public RatingsCollection() {
        ratingsMap = new TreeMap<>();
        userMax = 1;
        movieList = new ArrayList<>();
        rankMovies = new TreeMap<>();
    }

    /**
     * Get userID for the user whose movie preference ratings match
     * the most with the user in question.
     *
     * @return
     */
    public int getUserMax() {
        return userMax;
    }

    /**
     * @return
     */
    public Map getRatingsMap() {
        return ratingsMap;
    }

    public void addRatings(String dir) {
        try {
            File file = new File(dir);
            Scanner input = new Scanner(file);
            input.nextLine();
            int userId;
            int movieId;
            double rating;
            while (input.hasNextLine()) {
                String[] splitLine = input.nextLine().split(",");
                userId = Integer.parseInt(splitLine[0]);
                movieId = Integer.parseInt(splitLine[1]);
                rating = Double.parseDouble(splitLine[2]);
                if (!ratingsMap.containsKey(userId)) {
                    ratingsMap.put(userId, new TreeMap<>());
                }
                Map<Integer, Double> ratingsSub;
                ratingsSub = ratingsMap.get(userId);
                ratingsSub.put(movieId, rating);


            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }


    public int rValue(int compare) {
        double ratingUser;
        double ratingOthers;
        double sumProducts = 0;
        double sumUser = 0;
        double sumOther = 0;
        double sumUserSq = 0;
        double sumOtherSq = 0;
        double numerator;
        double den1;
        double den2;
        double denominator;
        double rValue = 0;
        double rMax = 0;

        double keep = 0;
        int count = 1;

        Map<Integer, Double> printer2 = ratingsMap.get(compare);

        for (Map.Entry<Integer, TreeMap<Integer, Double>> printer : ratingsMap.entrySet()) {
            System.out.println("new user!");
            count = 0;
            if (compare != printer.getKey()) {
                for (Map.Entry<Integer, Double> ratingEntry : printer.getValue().entrySet()) {
                    for (Map.Entry<Integer, Double> ratingEntry2 : printer2.entrySet()) {
                        if (ratingEntry2.getKey() == ratingEntry.getKey()) {
                            ratingUser = ratingEntry2.getValue();
                            ratingOthers = ratingEntry.getValue();
                            sumProducts += (ratingUser * ratingOthers);
                            sumUser += ratingUser;
                            sumOther += ratingOthers;
                            sumUserSq += Math.pow(ratingUser, 2);
                            sumOtherSq += Math.pow(ratingOthers, 2);

                            count++;
                        }
                    }
                }
                numerator = (count * sumProducts) - (sumUser * sumOther);
                den1 = (count * sumUserSq) - Math.pow(sumUser, 2);
                den2 = (count * sumOtherSq) - Math.pow(sumOther, 2);
                denominator = sqrt(den1) * sqrt(den2);
                rValue = numerator / denominator;
                if (denominator != 0) {
                    System.out.println("count " + count);
                    System.out.println("NUMERATOR");
                    System.out.println("sumProd" + sumProducts);
                    System.out.println("sumUser" + sumUser);
                    System.out.println("sumOther" + sumOther);
                    System.out.println("DENOMINATOR");
                    System.out.println("sumUserSq " + sumUserSq);
                    System.out.println("sumOtherSq " + sumOtherSq);
                    System.out.println("den1 " + den1);
                    System.out.println("den2 " + den2);
                    System.out.println("numerator " + numerator);
                    System.out.println("denominator" + denominator);
                    System.out.println(numerator + "/" + denominator);
                    System.out.println("rValue" + rValue);
                    System.out.println();
                    System.out.println();
                }
                if (rValue > rMax) {
                    rMax = rValue;
                    this.userMax = printer.getKey();
                }
                sumUser = 0;
                sumProducts = 0;
                sumOther = 0;
                sumOtherSq = 0;
                sumUserSq = 0;
                rValue = 0;
            }
        }
        return userMax;
    }


    public void rankList(String dir) {

        System.out.println("rankList started");
        int innerMovieId;
        double rating;
        MovieCollection movieColl = new MovieCollection();
        TreeMap<Integer, Double> userRatingMap = ratingsMap.get(userMax);

        movieColl.addMovie(dir);
        movieColl.printMap();

        for (Integer key : userRatingMap.keySet()) {

            rating = userRatingMap.get(key);
            if (!rankMovies.containsKey(rating)) {
                rankMovies.put(rating, new TreeMap<>());
                System.out.println("added ratings");
            } else {
                for (Integer movieId : movieColl.getMap().keySet()) {

                    if (key == movieId) {
                        Map<Integer, Movie> movieInner;
                        movieInner = rankMovies.get(rating);
                        movieInner.put(key, movieColl.getMap().get(movieId));
                    }

                }

            }


        }
    }


    public void printRankList() {
        for (Double rating : rankMovies.keySet()) {
            for (Integer movieId : rankMovies.get(rating).keySet()) {
                System.out.println("rating:" + rating + " movieId:" + movieId);
            }
        }
    }


    public void listTransfer() {
        System.out.println("List Transfer Starting");

        int movieId;
//        for (Map.Entry<Double, Map<Integer, Movie>> ratingEntry : rankMovies.entrySet()) {
//            for (Map.Entry<Integer, Movie> ratingEntry2 : ratingEntry.getValue().entrySet()) {
//                movieId = ratingEntry2.getKey();
//                System.out.println(ratingEntry2.getValue().getYear());


        // this is the 5 star rankings
        // call out the Movie objects for each item
        // take out the year
        // comparator the year
        // add to arraylist
        // continue for 4 star rankings, etc

    }


//    public void sortList() {
//        System.out.println("reached sortList");
//        for (int i = 0; i < movieList.size(); i++) {
//            System.out.println("BEFORE SORT");
//            System.out.println(movieList.get(i).getTitle());
//        }
//        movieList.sort(new MovieYearComparator());
//
//        for (int i = 0; i < movieList.size(); i++) {
//            System.out.println("AFTER SORT");
//            System.out.println(movieList.get(i).getTitle());
//        }
//
//    }
}
















