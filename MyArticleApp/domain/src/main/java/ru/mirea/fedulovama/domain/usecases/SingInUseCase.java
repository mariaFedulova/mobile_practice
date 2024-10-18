package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.repository.UserRepository;

public class SingInUseCase {
    private UserRepository userRepository;
    public SingInUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Boolean execute(String login, String pass){
        return this.userRepository.singIn(login, pass);
    }
}
