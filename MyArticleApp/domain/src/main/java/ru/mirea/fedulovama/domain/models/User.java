package ru.mirea.fedulovama.domain.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    List<Integer> favoriteArticles;
    List<Integer> ownArticles;
    public User(int id, String name){
        this.id = id;
        this.name = name;
        this.favoriteArticles = new ArrayList<>();
        this.ownArticles = new ArrayList<>();
    }

    public List<Integer> getArticles(){
        return this.ownArticles;
    }

    public String getData(){
        return "Данные пользователя";
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }
}
