package Example.Movies.Repository;

import Example.Movies.Entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE " +
            "LOWER(m.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.genre) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.director) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.language) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(m.country) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Movie> searchWithSorting(
            @Param("keyword") String keyword, Pageable pageable);
}


