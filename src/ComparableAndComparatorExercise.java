import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparatorExercise {
    public static void main(String[] args){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(40,"UP"));
        movies.add(new Movie(10,"Scary movie"));
        movies.add(new Movie(50,"Croods"));
        System.out.println("Lista sin ordenar: " + movies);
        Collections.sort(movies);
        System.out.println("Lista ordenada con la implementacion Comparable de la misma clase Movie: " + movies);
        Collections.sort(movies, new SortMoviesByName());
        System.out.println("Lista ordenada con la clase SortMoviesByName que implementa Comparator: " + movies);
    }
}

class Movie implements Comparable<Movie> {
    private Integer id;
    private String name;

    public Movie(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        return this.id - o.id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class SortMoviesByName implements Comparator<Movie>{
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
