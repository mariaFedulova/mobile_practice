package ru.mirea.fedulovama.data.network;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mirea.fedulovama.data.storage.models.Article;
import ru.mirea.fedulovama.domain.ApiCallback;

public class ArticleApi {

    private static Retrofit retrofit = null;
    private static ApiService apiService = null;

    public static ApiService getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://63go4.wiremockapi.cloud/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        if (apiService == null) {
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
    public void getArticles(ApiCallback<List<ru.mirea.fedulovama.domain.models.Article>> apiCallback){
        Call<List<Article>> call = getInstance().getArticles();
        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(@NonNull Call<List<Article>> call, @NonNull Response<List<Article>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ru.mirea.fedulovama.domain.models.Article> articles = mapToDomain(response.body());
                    apiCallback.onSuccess(articles);
                } else {
                    apiCallback.onFailure(new Exception("Error"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Article>> call, @NonNull Throwable t) {
                // Обработка ошибки сети или других исключений
                apiCallback.onFailure((Exception) t);
            }
        });
    }

    List<ru.mirea.fedulovama.domain.models.Article> mapToDomain(List<Article> articles){
        List<ru.mirea.fedulovama.domain.models.Article> articleList = new ArrayList<>();
        for (Article article : articles) {
            ru.mirea.fedulovama.domain.models.Article domainArticle = new ru.mirea.fedulovama.domain.models.Article(
                    article.getId(), article.getName(), article.getDescription(), article.getImg()
            );

            articleList.add(domainArticle);
        }
        return articleList;
    }
}
