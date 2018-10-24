package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.lang.Math.sqrt;

public class RatingsCollection {
    private Map<Integer, Map<Integer, Double>> ratingsMap;
    private int userMax;
    private ArrayList<Integer> movieList;
    private Map<Double, Map<Integer, Integer>> rankMovies;

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
        Movie movie = new Movie();
        Map<Integer, Double> printer = ratingsMap.get(userMax);
        for (Map.Entry<Integer, Double> ratingEntry2 : printer.entrySet()) {
            if (!rankMovies.containsKey(ratingEntry2.getValue())) {
                rankMovies.put(ratingEntry2.getValue(), new TreeMap<>());
                System.out.println(ratingEntry2.getValue());
            }
            Map<Integer, Integer> movieInner;
            movieInner = rankMovies.get(ratingEntry2.getValue());
            movieInner.put(ratingEntry2.getKey(), movie.getYear());
        }


        for (Map.Entry<Double, Map<Integer, Integer>> printer3 : rankMovies.entrySet()) {
            for (Map.Entry<Integer, Integer> ratingEntry : printer3.getValue().entrySet()) {
            }
            System.out.println(rankMovies.keySet());
        }
    }

    public void listTransfer() {

        for (Map.Entry<Double, Map<Integer, Integer>> ratingEntry : rankMovies.entrySet()) {
            for (Map.Entry<Integer, Integer> ratingEntry2 : ratingEntry.getValue().entrySet()) {
                if (ratingEntry.getKey() == 5.0) {
                    System.out.println(ratingEntry.getKey() + "/" + ratingEntry2.getKey());
                  //  movieList.add(ratingEntry);

                }
            }
        }
    }


}











