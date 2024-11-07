package ru.mirea.fedulovama.myarticleapp.presentation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;

import ru.mirea.fedulovama.data.repository.ArticleRepositoryImpl;
import ru.mirea.fedulovama.data.repository.UserRepositoryImpl;
import ru.mirea.fedulovama.domain.repository.ArticleRepository;
import ru.mirea.fedulovama.domain.repository.UserRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory{
    private Context context;


    public MainViewModelFactory(Context context){
        this.context = context;
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        ArticleRepository articleRepository = new ArticleRepositoryImpl(context);
        UserRepository userRepository = new UserRepositoryImpl(FirebaseAuth.getInstance());
        return (T) new MainViewModel(articleRepository, userRepository);
    }
}
