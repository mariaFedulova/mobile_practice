package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.repository.UserRepository;

public class SingUpUseCase {
    private UserRepository userRepository;
    public SingUpUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Boolean execute(String login, String pass){
        return this.userRepository.singUp(login, pass);
    }
}
