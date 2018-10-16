package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ratings {
    private int userId;
    private int movieId;
    private double rating;
    private double timestamp;

    public Ratings(String filename) {
       try {
           File file = new File("input/newSet/ratings.csv");
           Scanner input = new Scanner(file);



       } catch (FileNotFoundException e) {
           System.out.println("File not found.");
       }


    }


}
