package ru.mirea.fedulovama.myarticleapp.domain.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    List<Article> favoriteArticles;
    List<Article> ownArticles;
    public User(int id, String name){
        this.id = id;
        this.name = name;
        this.favoriteArticles = new ArrayList<>();
        this.ownArticles = new ArrayList<>();
    }

    public List<Article> getArticles(){
        return this.ownArticles;
    }

    public String getData(){
        return "Данные пользователя";
    }
}
