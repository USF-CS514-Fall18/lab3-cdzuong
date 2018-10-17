package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RatingsCollection {
    private Map<String, Map<String, String>> ratingsMap;

    public RatingsCollection() {
        ratingsMap = new TreeMap<>();
    }

    public void addRatings(String dir) {
        try {
            File file = new File(dir);
            Scanner input = new Scanner(file);
            input.nextLine();
            String userId = "";
            String movieId = "";
            String rating = "";
            int i = 0;
            while (input.hasNextLine()) {
                String[] splitLine = input.nextLine().split(",");
                userId = splitLine[0];
                System.out.println(userId);
                movieId = splitLine[1];
                System.out.println(movieId);
                rating = splitLine[2];
                System.out.println(rating);
                if (!ratingsMap.containsKey(userId)) {
                    ratingsMap.put(userId, new TreeMap<>());
                }
                Map<String, String> ratingsSub;
                ratingsSub = ratingsMap.get(userId);
                ratingsSub.put(movieId, rating);

                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void printMap() {
        for (Map.Entry<String, Map<String, String>> printer : ratingsMap.entrySet()) {
            for (Map.Entry<String, String> ratingEntry : printer.getValue().entrySet()) {
                System.out.println(ratingEntry.toString());
            }
        }
    }


}
