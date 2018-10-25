package recommender;

import java.util.*;

public class MovieYearComparator implements Comparator<Movie>{
    @Override
    public int compare(Movie year1, Movie year2) {
        if(year1.getYear() > year2.getYear()) {
            return 1;
        }
        else if(year1.getYear() == year2.getYear()) {
            return 0;
        }
        else {
            return -1;
        }
    }
    }



