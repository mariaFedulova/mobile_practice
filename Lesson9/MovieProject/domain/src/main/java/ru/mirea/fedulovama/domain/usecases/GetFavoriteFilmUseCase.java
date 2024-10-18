package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.models.Movie;
import ru.mirea.fedulovama.domain.repository.MovieRepository;

public class GetFavoriteFilmUseCase {
    private MovieRepository movieRepository;
    public GetFavoriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Movie execute(){
        return movieRepository.getMovie();
    }
}
