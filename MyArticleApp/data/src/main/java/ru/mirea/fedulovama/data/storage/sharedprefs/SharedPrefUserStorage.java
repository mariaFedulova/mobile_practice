package ru.mirea.fedulovama.data.storage.sharedprefs;

import android.content.SharedPreferences;

import java.util.List;
import java.util.Set;

import ru.mirea.fedulovama.data.storage.UserStorage;
import ru.mirea.fedulovama.data.storage.models.Article;

public class SharedPrefUserStorage implements UserStorage {
    private SharedPreferences sharedPreferences;

    private static String SHARED_PREFS_ARTICLE_ID = "article_id";

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
}
