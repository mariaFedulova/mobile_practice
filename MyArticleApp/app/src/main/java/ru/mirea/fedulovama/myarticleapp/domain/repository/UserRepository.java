package ru.mirea.fedulovama.myarticleapp.domain.repository;

import java.util.List;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.models.User;

public interface UserRepository {
    public Boolean addUserArticle(Article article, User user);
    public List<Article> getUserArticles(User user);
    public String getUserData(User user);
    public Boolean logOut();
    public Boolean singIn(String login, String pass);
    public Boolean singUp(String login, String pass);
    public Boolean changeUserInfo(User user);
    public Boolean saveArticleToFavorite(Article article, User user);
}
