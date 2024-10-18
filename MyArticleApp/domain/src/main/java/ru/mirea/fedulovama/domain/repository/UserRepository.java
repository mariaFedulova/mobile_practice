package ru.mirea.fedulovama.domain.repository;

import java.util.List;

import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.domain.models.User;

public interface UserRepository {
    public Boolean addUserArticle(Article article, User user);
    public List<Integer> getUserArticles(User user);
    public String getUserData(User user);
    public void logOut();
    public Boolean singIn(String login, String pass);
    public Boolean singUp(String login, String pass);
    public Boolean changeUserInfo(User user);
    public Boolean saveArticleToFavorite(Article article, User user);
}
