package Example.Movies.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import Example.Movies.Entity.Movie;
import Example.Movies.Service.MovieService;


@SpringBootTest
@DisplayName("Movie Service Test")
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @TestFactory
    @DisplayName("Test Search By Keyword")
    Stream<DynamicTest> testSearchByKeyword() {
        return Stream.of(
            DynamicTest.dynamicTest("Search by title", () -> {
                Page<Movie> movies = movieService.searchByKeyword("Shawshank", 0, 10);
                assertTrue(movies.getContent().size() > 0);
            }),
            DynamicTest.dynamicTest("Search by genre", () -> {
                Page<Movie> movies = movieService.searchByKeyword("Drama", 0, 10);
                assertTrue(movies.getContent().size() > 0);
            }),
            DynamicTest.dynamicTest("Search by director", () -> {
                Page<Movie> movies = movieService.searchByKeyword("Frank Darabont", 0, 10);
                assertTrue(movies.getContent().size() > 0);
            }),
            DynamicTest.dynamicTest("Search by language", () -> {
                Page<Movie> movies = movieService.searchByKeyword("English", 0, 10);
                assertTrue(movies.getContent().size() > 0);
            }),
            DynamicTest.dynamicTest("Search by rating", () -> {
                Page<Movie> movies = movieService.searchByKeyword("9.2", 0, 10);
                assertTrue(movies.getContent().size() > 0);
            }),
            DynamicTest.dynamicTest("Search by country", () -> {
                Page<Movie> movies = movieService.searchByKeyword("USA", 0, 10);
                assertTrue(movies.getContent().size() > 0);
            }),
            DynamicTest.dynamicTest("Search with pagination", () -> {
                Page<Movie> movies = movieService.searchByKeyword("Drama", 1, 5);
                assertTrue(movies.getContent().size() <= 5);
            }),
            DynamicTest.dynamicTest("Search with sorting", () -> {
                Page<Movie> movies = movieService.searchByKeyword("Drama", 0, 10, "title", "asc");
                assertNotNull(movies.getContent().get(0).getTitle());
            })
        );
    }

    @Test
    @DisplayName("Test Get All Movies")
    void testGetAllMovies() {
        Page<Movie> movies = movieService.getAllMoviesPaged(0, 10);
        assertTrue(movies.getContent().size() > 0);
    }

    @Test
    @DisplayName("Test Invalid Keyword")
    void testInvalidKeyword() {
        Page<Movie> movies = movieService.searchByKeyword("", 0, 10);
        assertTrue(movies.getContent().size() > 0);
    }
}


