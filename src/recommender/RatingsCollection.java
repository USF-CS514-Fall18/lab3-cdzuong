package recommender;

import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class RatingsCollection {
    private Map<String, Map<String, Double>> ratingsMap;

    public RatingsCollection() {
        ratingsMap = new TreeMap<>();
    }

    private void addRating(Ratings newRating) {
        if (!ratingsMap.containsKey(newRating.getUserId())) {
            ratingsMap.put(newRating.getUserId(), new TreeMap<>());
        }
        Map<String, Double> ratingsSub;
        ratingsSub = ratingsMap.get(newRating.getUserId());
        ratingsSub.put(newRating.getMovieId(), newRating.getRating());
    }
}
