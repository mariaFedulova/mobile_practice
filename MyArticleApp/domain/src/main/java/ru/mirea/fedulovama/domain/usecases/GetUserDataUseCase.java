package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.models.User;
import ru.mirea.fedulovama.domain.repository.UserRepository;

public class GetUserDataUseCase {
    private UserRepository userRepository;
    public GetUserDataUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public String execute(){
        return this.userRepository.getUserData();
    }
}
