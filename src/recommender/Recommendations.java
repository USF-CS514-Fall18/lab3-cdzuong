package recommender;

import java.util.Comparator;
import java.util.List;

public class Recommendations {
    private int userMatch;
    private List<Movie> movies;

    public Recommendations() {
        RatingsCollection match = new RatingsCollection();
        userMatch = match.getUserMax();
    }

}