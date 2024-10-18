package ru.mirea.fedulovama.data.storage.models;

public class Article {
    int id;
    String name;
    String description;
    public Article(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public String getName(){ return this.name; }
    public Integer getId(){return this.id;}
    public String getDescription(){ return this.description; }
}
