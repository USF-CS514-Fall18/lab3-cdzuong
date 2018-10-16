package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RatingsCollection {
    private Map<String, Map<String, Double>> ratingsMap;

    public RatingsCollection() {
        ratingsMap = new TreeMap<>();
    }

    private void addRating(Ratings newRating) {

    }

    public void addRatings(String dir) {
        try {
            File file = new File("input/newSet/ratings.csv");
            Scanner input = new Scanner(file);
            String splitLine[] = input.nextLine().split(",");
            String userId = "";
            String movieId = "";
            double rating = 0;
            for (int i = 0; i < splitLine.length; i++) {
                if (i % 4 == 0) {
                    userId = splitLine[i];
                }
                if (i % 4 == 1) {
                    movieId = splitLine[i];
                }
                if (i % 4 == 2) {
                    rating = Double.parseDouble(splitLine[i]);
                }
                if (!ratingsMap.containsKey(userId)) {
                    ratingsMap.put(userId, new TreeMap<>());
                }
                Map<String, Double> ratingsSub;
                ratingsSub = ratingsMap.get(userId);
                ratingsSub.put(movieId, rating);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void printMap() {
        for (Map.Entry<String, Map<String, Double>> printer : ratingsMap.entrySet()) {
            for (Map.Entry<String, Double> ratingEntry : printer.getValue().entrySet()) {
                System.out.println(ratingEntry.toString());
            }
        }
    }


}
