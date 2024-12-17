package ru.mirea.fedulovama.domain;

public interface ApiCallback<T> {
    public void onSuccess(T result);
    public void onFailure(Exception e);
}
