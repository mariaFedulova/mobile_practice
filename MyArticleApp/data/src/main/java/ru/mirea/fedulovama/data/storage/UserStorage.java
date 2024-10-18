package ru.mirea.fedulovama.data.storage;

import java.util.List;
import java.util.Set;

import ru.mirea.fedulovama.data.storage.models.Article;

public interface UserStorage {
    public Set<String> getFavArticles();
    public void saveArticleToFav(Article article);
}
