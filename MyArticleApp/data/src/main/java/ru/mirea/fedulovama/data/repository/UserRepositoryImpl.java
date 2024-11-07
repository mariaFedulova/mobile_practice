package ru.mirea.fedulovama.data.repository;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.mirea.fedulovama.data.storage.UserStorage;
import ru.mirea.fedulovama.data.storage.models.Article;
import ru.mirea.fedulovama.data.storage.models.User;
import ru.mirea.fedulovama.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {
    UserStorage sharedPrefUserStorage;
    private final FirebaseAuth auth;
    public UserRepositoryImpl(FirebaseAuth auth){
        this.auth = auth;
    }
    public Boolean addUserArticle(ru.mirea.fedulovama.domain.models.Article article, ru.mirea.fedulovama.domain.models.User user) {
        return null;
    }
    public List<Integer> getUserArticles(ru.mirea.fedulovama.domain.models.User user){
        return user.getArticles();
    }
    public String getUserData(){
        return sharedPrefUserStorage.getUser();
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
                    }
                });
        sharedPrefUserStorage.saveUser(new User(1, login));
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
        sharedPrefUserStorage.saveUser(new User(1, login));
        return isSuccess.get();
    }
    public Boolean changeUserInfo(ru.mirea.fedulovama.domain.models.User user){
        return true;
    }
    public Boolean saveArticleToFavorite(ru.mirea.fedulovama.domain.models.Article article, ru.mirea.fedulovama.domain.models.User user){
        sharedPrefUserStorage.saveArticleToFav(mapToStorageArticle(article));
        return true;
    }

    private Article mapToStorageArticle(ru.mirea.fedulovama.domain.models.Article article){
        return new Article(article.getId(), article.getName(),
                article.getDescription());
    }
    private ru.mirea.fedulovama.domain.models.Article mapToDomainArticle(Article article){
        return new ru.mirea.fedulovama.domain.models.Article(article.getId(),
                article.getName(), article.getDescription());
    }

    private User mapToStorageUser(ru.mirea.fedulovama.domain.models.User user){
        return new User(user.getId(), user.getName());
    }

    private ru.mirea.fedulovama.domain.models.User mapToDomainUser(User user){
        return new ru.mirea.fedulovama.domain.models.User(user.getId(), user.getName());
    }
}