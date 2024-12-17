package ru.mirea.fedulovama.myarticleapp.presentation;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.domain.repository.ArticleRepository;
import ru.mirea.fedulovama.domain.repository.UserRepository;
import ru.mirea.fedulovama.domain.usecases.GetArticlesUseCase;
import ru.mirea.fedulovama.domain.usecases.GetUserDataUseCase;

public class MainViewModel extends ViewModel {

    public ArticleRepository articleRepository;
    public UserRepository userRepository;
    private MutableLiveData<String> userData = new MutableLiveData<>();

    private final MutableLiveData<List<Article>> items = new MutableLiveData<>();

    public MainViewModel(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        Log.d(MainViewModel.class.getSimpleName().toString(), "MainViewModel created");
        items.setValue(getArticles());
    }
    @Override
    protected void onCleared() {
        Log.d(MainViewModel.class.getSimpleName().toString(), " MainViewModel cleared");
        super.onCleared();
    }

    public List<Article> getArticles(){
        return new GetArticlesUseCase(articleRepository).execute();
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
