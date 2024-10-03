package ru.mirea.fedulovama.movieproject.domain.repository;

import ru.mirea.fedulovama.movieproject.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}