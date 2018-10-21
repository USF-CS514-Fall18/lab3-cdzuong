package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movie {
    private int movieId;
    private String title;
    private String year;
    private int movieIdMax;

    public Movie(){
    }

    public Movie(int movieId, String title, String year) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
    }

    public Movie(String filename) {
        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);
            input.nextLine();

            while (input.hasNextLine()) {
                String[] splitLine = input.nextLine().split(",|\\(|\\)");
                movieId = Integer.parseInt(splitLine[0]);
                title = splitLine[1];
                year = splitLine[2];
movieIdMax = movieId;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }


    }

    public int getMovieId() {return movieId;}

    public String getTitle() {return title;}

    public String getYear() {return year;}

    public int getMovieIdMax() {return movieIdMax;}



}
