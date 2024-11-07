package ru.mirea.fedulovama.myarticleapp.presentation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.auth.FirebaseAuth;

import ru.mirea.fedulovama.data.repository.UserRepositoryImpl;
import ru.mirea.fedulovama.data.storage.UserStorage;
import ru.mirea.fedulovama.data.storage.sharedprefs.SharedPrefUserStorage;
import ru.mirea.fedulovama.domain.repository.UserRepository;

public class AuthViewModelFactory implements ViewModelProvider.Factory{
    private Context context;
    private FirebaseAuth auth;

    public AuthViewModelFactory(Context context, FirebaseAuth auth){
        this.context = context;
        this.auth = auth;
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        UserStorage sharedPrefUserStorage = new SharedPrefUserStorage(context);
        UserRepository userRepository = new UserRepositoryImpl(auth);
        return (T) new AuthViewModel(userRepository);
    }
}
