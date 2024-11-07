package ru.mirea.fedulovama.myarticleapp.presentation;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import ru.mirea.fedulovama.domain.repository.UserRepository;
import ru.mirea.fedulovama.domain.usecases.SingInUseCase;
import ru.mirea.fedulovama.domain.usecases.SingUpUseCase;

public class AuthViewModel extends ViewModel {
    public UserRepository userRepository;
    public AuthViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
        Log.d(MainViewModel.class.getSimpleName().toString(), "AuthViewModel created");
    }
    @Override
    protected void onCleared() {
        Log.d(MainViewModel.class.getSimpleName().toString(), " AuthViewModel cleared");
        super.onCleared();
    }
    public Boolean singIn(String login, String pass){
        return new SingInUseCase(userRepository).execute(login, pass);
    }
    public Boolean singUp(String login, String pass){
        return new SingUpUseCase(userRepository).execute(login, pass);
    }
}
