package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.models.Movie;
import ru.mirea.fedulovama.domain.repository.MovieRepository;

public class SaveFilmToFavoriteUseCase {
    private MovieRepository movieRepository;
    public SaveFilmToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}
