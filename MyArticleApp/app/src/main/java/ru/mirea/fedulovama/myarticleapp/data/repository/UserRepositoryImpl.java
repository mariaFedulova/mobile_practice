package ru.mirea.fedulovama.myarticleapp.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.models.User;
import ru.mirea.fedulovama.myarticleapp.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    public Boolean addUserArticle(Article article, User user){
        return true;
    }
    public List<Article> getUserArticles(User user){
        return user.getArticles();
    }
    public String getUserData(User user){
        return user.getData();
    }
    public Boolean logOut(){
        return true;
    }
    public Boolean singIn(String login, String pass){
        return true;
    }
    public Boolean singUp(String login, String pass){
        return true;
    }
    public Boolean changeUserInfo(User user){
        return true;
    }
    public Boolean saveArticleToFavorite(Article article, User user){
        return true;
    }
}
