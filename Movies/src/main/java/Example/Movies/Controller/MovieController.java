package Example.Movies.Controller;

import Example.Movies.Entity.Movie;
import Example.Movies.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/search")
    public ResponseEntity<Page<Movie>> searchByKeyword(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortDirection
    ) {
        Page<Movie> movies;

        if (keyword == null || keyword.isEmpty()) {
            movies = movieService.getAllMoviesPaged(page, size);
        } else {
            if (sortBy == null || sortDirection == null) {
                movies = movieService.searchByKeyword(keyword, page, size);
            } else {
                movies = movieService.searchByKeyword(keyword, page, size, sortBy, sortDirection);
            }
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
