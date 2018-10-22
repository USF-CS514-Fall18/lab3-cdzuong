package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RatingsCollection {
    private Map<Integer, Map<Integer, Double>> ratingsMap;

    public RatingsCollection() {
        ratingsMap = new TreeMap<>();
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

    public void swapR(int compare) {
        MovieCollection movieColl = new MovieCollection();

        for (Map.Entry<Integer, Map<Integer, Double>> printer : ratingsMap.entrySet()) {

            if (printer.getKey() != compare) {
                for (Map.Entry<Integer, Double> ratingEntry : printer.getValue().entrySet()) {


                }
            }
        }
    }


    public void rValue(int compare) {
        Movie movieIdSearcher = new Movie();
        double ratingUser;
        double ratingOthers;
        double sumProducts = 0;
        double sumUser = 0;
        double sumOther = 0;
        double sumUserSq = 0;
        double sumOtherSq = 0;
        double numerator;
        double denominator;
        double rValue;


        Map<Integer, Double> printer2 = ratingsMap.get(compare);

        for (Map.Entry<Integer, Map<Integer, Double>> printer : ratingsMap.entrySet()) {
            System.out.println("new user!");
            if (compare != printer.getKey()) {

                for (Map.Entry<Integer, Double> ratingEntry : printer.getValue().entrySet()) {

                    for (Map.Entry<Integer, Double> ratingEntry2 : printer2.entrySet()) {

                        if (ratingEntry2.getKey() == ratingEntry.getKey()) {
                            ratingUser = ratingEntry2.getValue();
                            ratingOthers = ratingEntry.getValue();

                            sumProducts += ratingUser * ratingOthers;
                            sumUser += ratingUser;
                            sumOther += ratingOthers;

                            numerator = sumProducts - (sumUser * sumOther);

                            sumUserSq += Math.pow(ratingUser, 2);
                            sumOtherSq += Math.pow(ratingOthers, 2);
                            System.out.println(ratingEntry.getKey() + " " + ratingEntry2.getKey());
                            System.out.println(ratingUser + " " + ratingOthers);
                        }

                    }
                }
            }

        }
    }

}





