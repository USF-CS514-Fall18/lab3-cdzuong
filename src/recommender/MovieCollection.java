package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MovieCollection {
    private TreeMap<Integer, Movie> movieMap;

    public MovieCollection() {movieMap = new TreeMap<>();
    }

    public void addMovie(String dir) {
        try {
            File file = new File(dir);
            Scanner input = new Scanner(file);
            input.nextLine();
            int movieId = 0;
            String title = "";
            int year = 0;
            while (input.hasNextLine()) {
                String[] splitLine = input.nextLine().split(",|\\(|\\)|-");

                if (splitLine.length == 5) {
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1];
                    System.out.println(splitLine.length);
                    System.out.println("length: " + splitLine.length + title);
                    year = Integer.parseInt(splitLine[2]);
                    System.out.println(year);
                }
                else if (splitLine.length == 6){
                    System.out.println(splitLine.length);


                   if (splitLine[4].equals("\"")){
                        for(int i = 0; i < splitLine.length; i++) {
                            System.out.println(i + " / " + splitLine[i]);
                        }
                        System.out.println(splitLine.length);
                        movieId = Integer.parseInt(splitLine[0]);
                        title = splitLine[1] + "+" + splitLine[2];
                       System.out.println("length: " + splitLine.length + title);
                        year = Integer.parseInt(splitLine[3]);
                        System.out.println(year);
                    }
                    else if (){
                       System.out.println("PROBLEM SOLVED!");
                       System.out.println("length" + splitLine.length);
                       movieId = Integer.parseInt(splitLine[0]);
                       title = splitLine[1];
                       System.out.println(title);
                       year = Integer.parseInt(splitLine[2]);
                       System.out.println(year);
                   }

                        else {
                        System.out.println("PROBLEM SOLVED!");
                        System.out.println("length" + splitLine.length);
                        movieId = Integer.parseInt(splitLine[0]);
                        title = splitLine[1];

                       System.out.println("START PRINT movieId: " + movieId);
                       for(int i = 0; i < splitLine.length; i++) {
                           System.out.println(i + " / " + splitLine[i]);
                       }

                        System.out.println("length: " + splitLine.length + title);
                        year = Integer.parseInt(splitLine[2]);
                        System.out.println(year);
                    }
                }
                else if (splitLine.length == 7){
                    System.out.println(splitLine.length);
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "+" + splitLine[2] + splitLine[3];
                    System.out.println("length: " + splitLine.length + title);
                    year = Integer.parseInt(splitLine[4]);
                    System.out.println(year);
                }
                else if (splitLine.length == 8){
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "+" + splitLine[2] + splitLine[3];
                    System.out.println("length: " + splitLine.length + title);
                    year = Integer.parseInt(splitLine[4]);
                    System.out.println(year);
                }
                else if (splitLine.length == 9){
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4] + splitLine[5];
                    System.out.println("length: " + splitLine.length + title);
                    year = Integer.parseInt(splitLine[6]);
                    System.out.println(year);
                }
                else if (splitLine.length == 10){
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4] + splitLine[5];
                    System.out.println("length: " + splitLine.length + title);
                    year = Integer.parseInt(splitLine[6]);
                    System.out.println(year);
                }
                else if (splitLine.length == 11){
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4] + splitLine[5] + splitLine[6] + splitLine[7];
                    System.out.println("length: " + splitLine.length + title);
                    year = Integer.parseInt(splitLine[8]);
                    System.out.println(year);
                }


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





