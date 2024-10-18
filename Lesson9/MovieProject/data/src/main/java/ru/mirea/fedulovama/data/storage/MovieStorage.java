package ru.mirea.fedulovama.data.storage;

import ru.mirea.fedulovama.data.storage.models.Movie;

public interface MovieStorage {
    public Movie get();
    public boolean save(Movie movie);
}