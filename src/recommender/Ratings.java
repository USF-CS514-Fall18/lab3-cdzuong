package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ratings {

    private String userId;
    private String movieId;
    private double rating;
    private double timestamp;

    public Ratings(String filename) {
        try {
            File file = new File("input/newSet/ratings.csv");
            Scanner input = new Scanner(file);
            String splitLine[] = input.nextLine().split(", ");
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
                if (i % 4 == 3) {
                    timestamp = Double.parseDouble(splitLine[i]);
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }


    }


}
