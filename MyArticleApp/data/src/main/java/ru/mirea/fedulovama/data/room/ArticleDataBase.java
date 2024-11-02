package ru.mirea.fedulovama.data.room;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.mirea.fedulovama.data.room.models.Article;

public class ArticleDataBase {
    private AppDatabase appDatabase;
    private Context context;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public ArticleDataBase(Context context) {
        this.context = context;

        appDatabase = Room.databaseBuilder(this.context, AppDatabase.class, "AppDatabase").build();
    }

    public void getRecipe() {
        executorService.execute(() -> appDatabase.getArticleDAO().getAllArticles());
    }

    public void addRecipe(Article article) {
        executorService.execute(() -> appDatabase.getArticleDAO().addArticle(article));
    }

    public void deleteRecipe(int id) {
        executorService.execute(() -> appDatabase.getArticleDAO().deleteArticle(id));
    }
}
