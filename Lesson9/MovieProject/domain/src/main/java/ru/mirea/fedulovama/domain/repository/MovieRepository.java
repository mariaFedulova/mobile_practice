package ru.mirea.fedulovama.domain.repository;

import ru.mirea.fedulovama.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}