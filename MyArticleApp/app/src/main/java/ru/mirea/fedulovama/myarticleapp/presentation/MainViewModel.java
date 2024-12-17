package ru.mirea.fedulovama.myarticleapp.presentation;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.fedulovama.domain.ApiCallback;
import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.domain.repository.ArticleRepository;
import ru.mirea.fedulovama.domain.repository.UserRepository;
import ru.mirea.fedulovama.domain.usecases.GetArticlesFromApiUseCase;
import ru.mirea.fedulovama.domain.usecases.GetArticlesUseCase;
import ru.mirea.fedulovama.domain.usecases.GetUserDataUseCase;

public class MainViewModel extends ViewModel {
    private Context context;
    public ArticleRepository articleRepository;
    public UserRepository userRepository;
    private MutableLiveData<String> userData = new MutableLiveData<>();
    private final MutableLiveData<List<Article>> items = new MutableLiveData<>();
    private List<Article> defaultList = new ArrayList<>();

    public MainViewModel(ArticleRepository articleRepository, UserRepository userRepository, Context context) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.context = context;
        Log.d(MainViewModel.class.getSimpleName().toString(), "MainViewModel created");
        defaultList.add(new Article(87, "", "", "path"));
        items.setValue(defaultList);
        getArticlesFromApi();
    }
    @Override
    protected void onCleared() {
        Log.d(MainViewModel.class.getSimpleName().toString(), " MainViewModel cleared");
        super.onCleared();
    }

    public List<Article> getArticles(){
        return new GetArticlesUseCase(articleRepository).execute();
    }
    public void getArticlesFromApi(){
        new GetArticlesFromApiUseCase(articleRepository).execute(new ApiCallback<List<Article>>() {
            @Override
            public void onSuccess(List<Article> result) {
                items.setValue(result);
            }
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getUserText(){
        userData.setValue(new GetUserDataUseCase(userRepository).execute());
    }

    public MutableLiveData<String> getUserData(){
        return userData;
    }

    public LiveData<List<Article>> getItems() {
        return items;
    }

    // Метод для добавления нового элемента в список
    public void addItem(Article item) {
        List<Article> currentList = items.getValue();
        if (currentList != null) {
            currentList.add(item);
            items.setValue(currentList); // Обновляем LiveData
        }
    }
}
