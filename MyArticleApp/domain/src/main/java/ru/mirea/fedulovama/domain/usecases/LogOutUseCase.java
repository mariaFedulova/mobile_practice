package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.repository.UserRepository;

public class LogOutUseCase {
    private UserRepository userRepository;
    public LogOutUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void execute(){
        this.userRepository.logOut();
    }
}
