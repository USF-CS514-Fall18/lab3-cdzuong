package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movie {
    private int movieId;
    private String title;
    private int year;
    private int movieIdMax;

    public Movie() {
    }

    public Movie(int movieId, String title, int year) {
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

                if (splitLine.length == 5) {
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1];
                    System.out.println(title);
                    year = Integer.parseInt(splitLine[2]);
                    System.out.println(year);
                }
                else if (splitLine.length == 6){
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "/" + splitLine[2] + splitLine[3];
                    System.out.println(title);
                    year = Integer.parseInt(splitLine[4]);
                    System.out.println(year);
                }
                else if (splitLine.length == 7){
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4];
                    System.out.println(title);
                    year = Integer.parseInt(splitLine[5]);
                    System.out.println(year);
                }
                else if (splitLine.length == 8){
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4];
                    System.out.println(title);
                    year = Integer.parseInt(splitLine[5]);
                    System.out.println(year);
                }
                else if (splitLine.length == 9){
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4] + splitLine[5];
                    System.out.println(title);
                    year = Integer.parseInt(splitLine[6]);
                    System.out.println(year);
                }
                else if (splitLine.length == 10){
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4] + splitLine[5] + splitLine[6];
                    System.out.println(title);
                    year = Integer.parseInt(splitLine[7]);
                    System.out.println(year);
                }
                else if (splitLine.length == 11){
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4] + splitLine[5] + splitLine[6] + splitLine[7];
                    System.out.println(title);
                    year = Integer.parseInt(splitLine[8]);
                    System.out.println(year);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }


    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getMovieIdMax() {
        return movieIdMax;
    }


}
