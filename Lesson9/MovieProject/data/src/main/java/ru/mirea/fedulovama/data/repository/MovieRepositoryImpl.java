package ru.mirea.fedulovama.data.repository;

import android.annotation.SuppressLint;

import java.time.LocalDate;

import ru.mirea.fedulovama.data.storage.MovieStorage;
import ru.mirea.fedulovama.data.storage.models.Movie;
import ru.mirea.fedulovama.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
    MovieStorage sharedPrefMovieStorage;
    public MovieRepositoryImpl(MovieStorage sharedPrefMovieStorage){
        this.sharedPrefMovieStorage = sharedPrefMovieStorage;
    }
    @SuppressLint("CommitPrefEdits")
    @Override
    public boolean saveMovie(ru.mirea.fedulovama.domain.models.Movie movie){
        sharedPrefMovieStorage.save(mapToStorage(movie));
        return true;
    }
    @Override
    public ru.mirea.fedulovama.domain.models.Movie getMovie(){
        Movie movie = sharedPrefMovieStorage.get();
        return mapToDomain(movie);
    }
    private Movie mapToStorage(ru.mirea.fedulovama.domain.models.Movie movie){
        String name = movie.getName();
        return new Movie(2, name, LocalDate.now().toString());
    }
    private ru.mirea.fedulovama.domain.models.Movie mapToDomain(Movie movie){
        return new ru.mirea.fedulovama.domain.models.Movie(movie.getId(),
                movie.getName());
    }
}