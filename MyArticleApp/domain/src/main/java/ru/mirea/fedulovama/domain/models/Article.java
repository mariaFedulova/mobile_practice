package ru.mirea.fedulovama.domain.models;

public class Article {
    int id;
    String name;
    String description;
    String img;

    public Article(int id, String name, String description, String img){
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
    }
    public String getName(){ return this.name; }
    public String getDescription(){ return this.description; }
    public Integer getId(){return this.id;}
    public String getImg(){return this.img;}
}