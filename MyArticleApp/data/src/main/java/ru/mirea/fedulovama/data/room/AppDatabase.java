package ru.mirea.fedulovama.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.mirea.fedulovama.data.room.models.Article;

@Database(entities = {Article.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArticleDAO getArticleDAO();
}
