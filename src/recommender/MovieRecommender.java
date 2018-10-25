package recommender;

public class MovieRecommender {
    // FILL IN CODE
    // Add instance data, methods in this class
    // and create other classes as needed

    /**
     * Takes four command line arguments:
     * args[0] path to the folder that contains movies and ratings files
     * args[1] path to the folder where  to save recommendations and antiRecommendations
     * args[2] id of the user for whom to compute recommendations (and anti-recommendations)
     * args[3] number of recommendations (and anti-recommendations) to write to a file.
     *
     * @param args\argument to the program
     */
    public static void main(String[] args) {
        RatingsCollection collection = new RatingsCollection();
        collection.addRatings("input/newSet/ratings.csv");

        MovieCollection movCollection = new MovieCollection();
        movCollection.addMovie("input/newSet/movies.csv");

        collection.rValue(Integer.parseInt(args[2]));

        collection.rankList("input/newSet/movies.csv");

        collection.makeStarMovieList(Integer.parseInt(args[2]), Integer.parseInt(args[2]), "input/newSet/movies.csv");


    }
}
