package ru.mirea.fedulovama.data.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import ru.mirea.fedulovama.data.storage.models.Article;

public interface ApiService {
    @GET("articles")
    Call<List<Article>> getArticles();
}
