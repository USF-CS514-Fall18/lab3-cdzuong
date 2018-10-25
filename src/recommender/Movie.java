package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public class Movie {
    private String title;
    private int year;

    public Movie(String title, int year) {
    this.title = title;
    this.year = year;
    }

    public Movie(String filename) {
        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);
            input.nextLine();
            int movieId = 0;
            String title = "";
            int year = 0;
            while (input.hasNextLine()) {
                String lineRead = input.nextLine();
                String[] splitLine;
                String[] miniSplit;
                String[] splitTitle;
                if (lineRead.contains("\"")) {
                    System.out.println("HAS QUOTES");
                    System.out.println(lineRead);
                    splitLine = lineRead.split(",");
                    miniSplit = splitLine[splitLine.length - 2].split("\\(|\\)");
                    movieId = Integer.parseInt(splitLine[0]);
                    System.out.println("movieId: " + movieId);
                    this.year = Integer.parseInt(miniSplit[miniSplit.length - 2]);
                    System.out.println("year: " + year);
                    splitTitle = lineRead.split("\"|\\(");
                    this.title = splitTitle[1];
                    System.out.println(title);


                } else if (lineRead.contains(") ,")) {
                    splitLine = lineRead.split(",");
                    ;
                    movieId = Integer.parseInt(splitLine[0]);
                   this.title = splitLine[1].substring(0, splitLine[1].length() - 6);
                    this.year = Integer.parseInt(splitLine[splitLine.length - 2].substring(splitLine[1].length() - 6, splitLine[1].length() - 2));

                    System.out.println("movieId: " + movieId + " / title: " + title);
                    System.out.println("year: " + year);
                } else {
                    splitLine = lineRead.split(",");
                    ;
                    movieId = Integer.parseInt(splitLine[0]);
                    this.title = splitLine[1].substring(0, splitLine[1].length() - 6);
                    this.year = Integer.parseInt(splitLine[splitLine.length - 2].substring(splitLine[1].length() - 5, splitLine[1].length() - 1));

                    System.out.println("movieId: " + movieId + " / title: " + title);
                    System.out.println("year: " + year);

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }


    }



    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }


}
