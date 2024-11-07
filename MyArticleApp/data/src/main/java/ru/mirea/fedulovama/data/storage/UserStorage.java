package ru.mirea.fedulovama.data.storage;

import java.util.List;
import java.util.Set;

import ru.mirea.fedulovama.data.storage.models.Article;
import ru.mirea.fedulovama.data.storage.models.User;

public interface UserStorage {
    public Set<String> getFavArticles();
    public void saveArticleToFav(Article article);
    public void saveUser(User user);
    public String getUser();
}
