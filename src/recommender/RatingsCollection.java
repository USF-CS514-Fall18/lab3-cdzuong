package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Math.sqrt;

public class RatingsCollection {
    private Map<Integer, Map<Integer, Double>> ratingsMap;
    private int userMax;
    private ArrayList<Integer> movieList;
    private Map<Double, Map<Integer, Movie>> rankMovies;

    public RatingsCollection() {
        ratingsMap = new TreeMap<>();
        userMax = 1;
        movieList = new ArrayList<>();
        rankMovies = new TreeMap<>();
    }

    public int getUserMax() {
        return userMax;
    }

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

        for (Map.Entry<Integer, Map<Integer, Double>> printer : ratingsMap.entrySet()) {
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
        System.out.println("Max User: " + userMax + " // max R: " + rMax);


//        for (Map.Entry<Integer, Double> ratingEntry : printer2.entrySet()) {
//            System.out.println(ratingEntry.toString());
        return userMax;
    }

//    public void topRecs(int userMax) {
//        Map<Integer, Double> movies = ratingsMap.get(userMax);
//        int count = 0;
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 5.0) {
//                movieArray.add(e);
//            }
//        }
//
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 4.5) {
//                movieArray.add(e);
//            }
//        }
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 4.0) {
//                movieArray.add(e);
//            }
//        }
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 3.5) {
//                movieArray.add(e);
//            }
//        }
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 3.0) {
//                movieArray.add(e);
//            }
//        }
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 2.5) {
//                movieArray.add(e);
//            }
//        }
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 2.0) {
//                movieArray.add(e);
//            }
//        }
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 1.5) {
//                movieArray.add(e);
//            }
//        }
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 1.0) {
//                movieArray.add(e);
//            }
//        }
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 0.5) {
//                movieArray.add(e);
//            }
//        }
//        for (Integer e : movies.keySet()) {
//            if (movies.get(e) == 0.0) {
//                movieArray.add(e);
//            }
//        }
//
//        for (Integer e : movieArray) {
//            System.out.println(e);
//        }
//    }

    public void rankList() {

        System.out.println("rankList started");
       int innerMovieId;
       double rating;
        MovieCollection movieColl = new MovieCollection();
        Movie movieObject = movieColl.getMap().get(1);
        System.out.println("this is movieObject Year: " + movieObject.getYear());
        Map<Integer, Double> printer = ratingsMap.get(userMax);
        for (Map.Entry<Integer, Double> userRatingMap : printer.entrySet()) {
            innerMovieId = userRatingMap.getKey();

            rating = userRatingMap.getValue();
            if (!rankMovies.containsKey(userRatingMap.getValue())) {
                rankMovies.put(rating, new TreeMap<>());
                System.out.println("userRatingMapValue is " + userRatingMap.getValue());
            }
            Map<Integer, Movie> movieInner;
            movieInner = rankMovies.get(rating);
            movieInner.put(innerMovieId, movieObject);

        }


    }

    public void listTransfer() {
        System.out.println("List Transfer Starting");

        int movieId;
        for (Map.Entry<Double, Map<Integer, Movie>> ratingEntry : rankMovies.entrySet()) {
            for (Map.Entry<Integer, Movie> ratingEntry2 : ratingEntry.getValue().entrySet()) {
                movieId = ratingEntry2.getKey();
                System.out.println(ratingEntry2.getValue().getYear());


                // this is the 5 star rankings
                // call out the Movie objects for each item
                // take out the year
                // comparator the year
                // add to arraylist
                // continue for 4 star rankings, etc

            }
        }

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
















