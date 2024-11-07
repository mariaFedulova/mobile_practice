package ru.mirea.fedulovama.data.network;

import androidx.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mirea.fedulovama.data.storage.models.Article;

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
    public void getArticles(final Callback<List<Article>> callback) {
        Call<List<Article>> call = getInstance().getArticles();
        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(@NonNull Call<List<Article>> call, @NonNull Response<List<Article>> response) {
                if (response.isSuccessful()) {
                    List<Article> articles = response.body();
                    // Обработка успешного ответа
                    callback.onResponse(call, response);
                } else {
                    // Обработка ошибки
                    callback.onFailure(call, new Throwable("Ошибка при получении статей"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Article>> call, @NonNull Throwable t) {
                // Обработка ошибки сети или других исключений
                callback.onFailure(call, t);
            }
        });
    }
}
