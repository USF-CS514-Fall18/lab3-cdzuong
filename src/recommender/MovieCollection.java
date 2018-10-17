package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MovieCollection {
    private Map<String, String> movieMap;

    public MovieCollection() {
        movieMap = new TreeMap<>();
    }

    public void addMovie(String dir) {
        try {
            File file = new File(dir);
            Scanner input = new Scanner(file);
            input.nextLine();
            String movie = "";
            String year = "";
            while (input.hasNextLine()) {
                String[] splitLine = input.nextLine().split(",|\\(|\\)");
                movie = splitLine[1];
                System.out.println(movie);
                year = splitLine[2];
                System.out.println(year);
                movieMap.put(movie, year);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void printMap() {
        for (Map.Entry<String, String> printer : movieMap.entrySet()) {
            System.out.println(printer.toString());
        }
    }
}



