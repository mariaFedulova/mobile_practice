package ru.mirea.fedulovama.myarticleapp.presentation;

import android.util.Log;

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

    public MainViewModel(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        Log.d(MainViewModel.class.getSimpleName().toString(), "MainViewModel created");
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
}
