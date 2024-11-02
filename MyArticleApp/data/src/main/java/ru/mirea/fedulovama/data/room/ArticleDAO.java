package ru.mirea.fedulovama.data.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.mirea.fedulovama.data.room.models.Article;

@Dao
public interface ArticleDAO {
    @Query("select * from articles")
    public List<Article> getAllArticles();

    @Query("select * from articles where id==:id")
    public List<Article> getById(int id);

    @Insert
    public void addArticle(Article recipe);

    @Update
    public void changeArticle(Article recipe);

    @Query("delete from articles where id==:id")
    public void deleteArticle(int id);

    @Query("delete from articles")
    public void clear();

}
