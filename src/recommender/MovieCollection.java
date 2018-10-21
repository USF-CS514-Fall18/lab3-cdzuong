package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MovieCollection {
    private Map<Integer, Movie> movieMap;

    public MovieCollection() {
        movieMap = new TreeMap<>();
    }

    public void addMovie(String dir) {
        try {
            File file = new File(dir);
            Scanner input = new Scanner(file);
            input.nextLine();
            int movieId;
            String title;
            String year;
            while (input.hasNextLine()) {
                String[] splitLine = input.nextLine().split(",|\\(|\\)");
                movieId = Integer.parseInt(splitLine[0]);
                System.out.println(movieId);
                title = splitLine[1];
                System.out.println(title);
                year = splitLine[2];
                System.out.println(year);
                movieMap.put(movieId, new Movie(movieId,title,year));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

    }

    public void printMap() {
        for (Map.Entry<Integer, Movie> printer : movieMap.entrySet()) {
            System.out.println(printer.toString());
        }
    }

    public Map getMap() {return movieMap;}
}



