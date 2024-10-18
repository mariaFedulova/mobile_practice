package ru.mirea.fedulovama.data.repository;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.mirea.fedulovama.data.storage.UserStorage;
import ru.mirea.fedulovama.data.storage.models.Article;
import ru.mirea.fedulovama.domain.models.User;
import ru.mirea.fedulovama.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    UserStorage sharedPrefUserStorage;
    private final FirebaseAuth auth;
    public UserRepositoryImpl(FirebaseAuth auth){
        this.auth = auth;
    }
    public Boolean addUserArticle(ru.mirea.fedulovama.domain.models.Article article, User user) {
        return null;
    }
    public List<Integer> getUserArticles(User user){
        return user.getArticles();
    }
    public String getUserData(User user){
        return user.getData();
    }
    public void logOut(){
        auth.signOut();
    }
    public Boolean singIn(String login, String pass){
        AtomicBoolean isSuccess = new AtomicBoolean(true);
        auth.signInWithEmailAndPassword(login, pass)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "signInWithEmail:success");
                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        isSuccess.set(false);
                        //Log.d(TAG, "" + isSuccess.get());
                    }
                });
        return isSuccess.get();
    }
    public Boolean singUp(String login, String pass){
        AtomicBoolean isSuccess = new AtomicBoolean(true);
        auth.createUserWithEmailAndPassword(login, pass)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "createUserWithEmail:success");
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        isSuccess.set(false);
                    }
                });
        return isSuccess.get();
    }
    public Boolean changeUserInfo(User user){
        return true;
    }
    public Boolean saveArticleToFavorite(ru.mirea.fedulovama.domain.models.Article article, User user){
        sharedPrefUserStorage.saveArticleToFav(mapToStorage(article));
        return true;
    }

    private Article mapToStorage(ru.mirea.fedulovama.domain.models.Article article){
        return new Article(article.getId(), article.getName(),
                article.getDescription());
    }
    private ru.mirea.fedulovama.domain.models.Article mapToDomain( Article article){
        return new ru.mirea.fedulovama.domain.models.Article(article.getId(),
                article.getName(), article.getDescription());
    }
}