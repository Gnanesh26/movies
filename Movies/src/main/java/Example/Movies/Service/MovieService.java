package Example.Movies.Service;

import Example.Movies.Entity.Movie;
import Example.Movies.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Page<Movie> getAllMoviesPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return movieRepository.findAll(pageable);
    }

    public Page<Movie> searchByKeyword(String keyword, int page, int size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return movieRepository.searchWithSorting(keyword, pageable);
    }
}



