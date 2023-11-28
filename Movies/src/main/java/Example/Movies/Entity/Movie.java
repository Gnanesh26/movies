package Example.Movies.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    private Date releaseDate;
    private String genre;
    private String director;
    private Integer durationMinutes;
    private BigDecimal rating;
    private String language;
    private String country;
    private BigDecimal budget;
    private BigDecimal boxOfficeRevenue;

    public Movie(Long movieId, String title, Date releaseDate, String genre, String director, Integer durationMinutes, BigDecimal rating, String language, String country, BigDecimal budget, BigDecimal boxOfficeRevenue) {
        this.movieId = movieId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.director = director;
        this.durationMinutes = durationMinutes;
        this.rating = rating;
        this.language = language;
        this.country = country;
        this.budget = budget;
        this.boxOfficeRevenue = boxOfficeRevenue;
    }

    public Movie() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getBoxOfficeRevenue() {
        return boxOfficeRevenue;
    }

    public void setBoxOfficeRevenue(BigDecimal boxOfficeRevenue) {
        this.boxOfficeRevenue = boxOfficeRevenue;
    }
}

