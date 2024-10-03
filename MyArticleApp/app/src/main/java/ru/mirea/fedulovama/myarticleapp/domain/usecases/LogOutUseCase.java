package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import ru.mirea.fedulovama.myarticleapp.domain.models.User;
import ru.mirea.fedulovama.myarticleapp.domain.repository.UserRepository;

public class LogOutUseCase {
    private UserRepository userRepository;
    public LogOutUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Boolean execute(){
        return this.userRepository.logOut();
    }
}
