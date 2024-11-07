package ru.mirea.fedulovama.movieproject;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.fedulovama.domain.models.Movie;
import ru.mirea.fedulovama.domain.repository.MovieRepository;
import ru.mirea.fedulovama.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.fedulovama.domain.usecases.SaveFilmToFavoriteUseCase;

public class MainViewModel extends ViewModel{
    public MovieRepository movieRepository;
    private MutableLiveData<String> favoriteMovie = new MutableLiveData<>();
    public MainViewModel(MovieRepository movieRepository) {
        Log.d(MainViewModel.class.getSimpleName().toString(), "MainViewModel created");
        this.movieRepository = movieRepository;
    }
    @Override
    protected void onCleared() {
        Log.d(MainViewModel.class.getSimpleName().toString(), " MainViewModel cleared");
        super.onCleared();
    }
    public void setText(Movie movie){
        boolean result = new SaveFilmToFavoriteUseCase(movieRepository).execute(movie);
        favoriteMovie.setValue(Boolean.toString(result));
    }
    public void getText(){
        Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
        favoriteMovie.setValue(String.format("My favorite movie is %s", movie.getName()));
    }
    public MutableLiveData<String> getFavoriteMovie() {
        return favoriteMovie;
    }
}
