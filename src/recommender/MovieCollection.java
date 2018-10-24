package recommender;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MovieCollection {
    private TreeMap<Integer, Movie> movieMap;

    public MovieCollection() {
        movieMap = new TreeMap<>();
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
                    year = Integer.parseInt(miniSplit[miniSplit.length - 2]);
                    System.out.println("year: " + year);
                    splitTitle = lineRead.split("\"|\\(");
                    title = splitTitle[1];
                    System.out.println(title);


                } else if (lineRead.contains(") ,")) {
                    splitLine = lineRead.split(",");
                    ;
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1].substring(0, splitLine[1].length() - 6);
                    year = Integer.parseInt(splitLine[splitLine.length - 2].substring(splitLine[1].length() - 6, splitLine[1].length() - 2));

                    System.out.println("movieId: " + movieId + " / title: " + title);
                    System.out.println("year: " + year);
                } else {
                    splitLine = lineRead.split(",");
                    ;
                    movieId = Integer.parseInt(splitLine[0]);
                    title = splitLine[1].substring(0, splitLine[1].length() - 6);
                    year = Integer.parseInt(splitLine[splitLine.length - 2].substring(splitLine[1].length() - 5, splitLine[1].length() - 1));

                    System.out.println("movieId: " + movieId + " / title: " + title);
                    System.out.println("year: " + year);
                }

//                    movieId = Integer.parseInt(splitLine[0]);
//                    title = splitLine[1];
//
//                    year = Integer.parseInt(splitLine[splitLine.length - 2]);
//                    System.out.println(title + " / year: " + year);

            }
//
//                for (int i = 0; i < splitLine.length; i++) {
//                    System.out.println(i + "/" + splitLine[i]);
//                }
//
//                if (splitLine.length == 5) {
//                    movieId = Integer.parseInt(splitLine[0]);
//                    title = splitLine[1];
//                    System.out.println(splitLine.length);
//                    System.out.println("length: " + splitLine.length + title);
//                    year = Integer.parseInt(splitLine[2]);
//                    System.out.println(year);
//                } else if (splitLine.length == 6) {
//                    System.out.println(splitLine.length);
//
//
//                    if (splitLine[2].contains("Dome")) {
//                        System.out.println("PROBLEM SOLVED!");
//                        System.out.println("length" + splitLine.length);
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + splitLine[2];
//                        System.out.println(title);
//                        year = Integer.parseInt(splitLine[3]);
//                        System.out.println(year);
//                    } else if (splitLine[2].contains(" The ")) {
//                        System.out.println("PROBLEM SOLVED!");
//                        System.out.println("length" + splitLine.length);
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[2] + splitLine[1];
//                        System.out.println(title);
//                        year = Integer.parseInt(splitLine[3]);
//                        System.out.println(year);
//                    } else if (splitLine[2].contains("Beloved")) {
//                        System.out.println("PROBLEM SOLVED!");
//                        System.out.println("length" + splitLine.length);
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + splitLine[2];
//                        System.out.println(title);
//                        year = Integer.parseInt(splitLine[3]);
//                        System.out.println(year);
//                    } else if (splitLine[2].contains("Glenn")) {
//                        System.out.println("PROBLEM SOLVED!");
//                        System.out.println("length" + splitLine.length);
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + splitLine[2];
//                        System.out.println(title);
//                        year = Integer.parseInt(splitLine[3]);
//                        System.out.println(year);
//                    }
//                    // else (splitLine[0].contains("24") || splitLine[0].contains("66") || splitLine[0].contains("76")) {
//                    else {
//                        System.out.println("PROBLEM SOLVED!");
//                        System.out.println("length" + splitLine.length);
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1];
//                        System.out.println(title);
//                        year = Integer.parseInt(splitLine[2]);
//                        System.out.println(year);
//                    }
////                        else {
////                        System.out.println("PROBLEM SOLVED!");
////                        System.out.println("length" + splitLine.length);
////                        movieId = Integer.parseInt(splitLine[0]);
////                        title = splitLine[1];
////                        year = Integer.parseInt(splitLine[3]);
////                       }
//
//                } else if (splitLine.length == 7) {
//
//                    if (splitLine[1].contains("Shanghai") || splitLine[1].contains("Seven") || splitLine[1].contains("Rent") || splitLine[3].equals(" ")) {
//                        System.out.println(splitLine.length);
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + "+" + splitLine[2] + splitLine[3];
//                        System.out.println("length: " + splitLine.length + title);
//                        year = Integer.parseInt(splitLine[4]);
//                        System.out.println(year);
//
//                    } else {
//                        System.out.println(splitLine.length);
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + "+" + splitLine[2];
//                        System.out.println("length: " + splitLine.length + title);
//                        year = Integer.parseInt(splitLine[3]);
//                        System.out.println(year);
//                    }
//                } else if (splitLine.length == 8) {
//                    movieId = Integer.parseInt(splitLine[0]);
//                    title = splitLine[1] + "+" + splitLine[2] + splitLine[3];
//                    System.out.println("length: " + splitLine.length + title);
//                    year = Integer.parseInt(splitLine[4]);
//                    System.out.println(year);
//                } else if (splitLine.length == 9) {
//                    if (splitLine[5].contains(" ")) {
//                        System.out.println(splitLine.length);
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + "+" + splitLine[2];
//                        System.out.println("length: " + splitLine.length + title);
//                        year = Integer.parseInt(splitLine[6]);
//                        System.out.println(year);
//
//                    } else if (splitLine[2].contains("Baby") || splitLine[2].contains("Adventures")) {
//                        System.out.println(splitLine.length);
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + "+" + splitLine[2] + splitLine[3] + splitLine[4];
//                        System.out.println("length: " + splitLine.length + title);
//                        year = Integer.parseInt(splitLine[5]);
//                        System.out.println(year);
//
//                    } else if (splitLine[2].contains("Puppet")) {
//                        System.out.println(splitLine.length);
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + "+" + splitLine[2] + splitLine[3];
//                        System.out.println("length: " + splitLine.length + title);
//                        year = Integer.parseInt(splitLine[4]);
//                        System.out.println(year);
//
//                    } else {
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4];
//                        System.out.println("length: " + splitLine.length + title);
//                        year = Integer.parseInt(splitLine[6]);
//                        System.out.println(year);
//                    }
//                } else if (splitLine.length == 10) {
//                    movieId = Integer.parseInt(splitLine[0]);
//                    title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4] + splitLine[5];
//                    System.out.println("length: " + splitLine.length + title);
//                    year = Integer.parseInt(splitLine[6]);
//                    System.out.println(year);
//                } else if (splitLine.length == 11) {
//                    if (splitLine[0].contains("680")) {
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4] + splitLine[5];
//                        System.out.println("length: " + splitLine.length + title);
//                        year = Integer.parseInt(splitLine[6]);
//                        System.out.println(year);
//                    } else {
//
//                        movieId = Integer.parseInt(splitLine[0]);
//                        title = splitLine[1] + "/" + splitLine[2] + splitLine[3] + splitLine[4] + splitLine[5] + splitLine[6];
//                        System.out.println("length: " + splitLine.length + title);
//                        year = Integer.parseInt(splitLine[7]);
//                        System.out.println(year);
//                    }
//
//                }


            movieMap.put(movieId, new Movie(movieId, title, year));

        } catch (
                FileNotFoundException e) {
            System.out.println("File not found.");
        }

    }

    public void printMap() {
        for (Map.Entry<Integer, Movie> printer : movieMap.entrySet()) {
            System.out.println(printer.toString());
        }
    }


    public Map getMap() {
        return movieMap;
    }


}





