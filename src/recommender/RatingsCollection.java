package recommender;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class RatingsCollection {
    private Map<String, Map<String, Ratings>> ratingsMap;

    public RatingsCollection(){
        ratingsMap = new TreeMap<>();
    }

    private void addSong(int userId, int movieId) {

    }
}
