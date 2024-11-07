package ru.mirea.fedulovama.data.storage.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import ru.mirea.fedulovama.data.storage.UserStorage;
import ru.mirea.fedulovama.data.storage.models.Article;
import ru.mirea.fedulovama.data.storage.models.User;

public class SharedPrefUserStorage implements UserStorage {
    private static final String SHARED_PREFS_ARTICLES = "shared_prefs_favorite_articles";
    private static final String SHARED_PREFS_USER = "shared_prefs_user";
    private SharedPreferences sharedPreferences;
    private static String SHARED_PREFS_ARTICLE_ID = "article_id";
    private static final String NAME_KEY = "user_name";

    public SharedPrefUserStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_USER, Context.MODE_PRIVATE);
    }

    @Override
    public Set<String> getFavArticles() {
        return sharedPreferences.getStringSet(SHARED_PREFS_ARTICLE_ID, null);
    }

    @Override
    public void saveArticleToFav(Article article) {
        Set<String> ids = sharedPreferences.getStringSet(SHARED_PREFS_ARTICLE_ID, null);
        ids.add(article.getId().toString());
        sharedPreferences.edit().putStringSet(SHARED_PREFS_ARTICLE_ID, ids);
    }

    @Override
    public void saveUser(User user){
        sharedPreferences.edit()
                .putString(NAME_KEY, user.getData())
                .apply();
    }

    @Override
    public String getUser(){
        return sharedPreferences.getString(NAME_KEY, "э-эх");
    }
}
