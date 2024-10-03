package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import ru.mirea.fedulovama.myarticleapp.domain.models.User;
import ru.mirea.fedulovama.myarticleapp.domain.repository.UserRepository;

public class SingInUseCase {
    private UserRepository userRepository;
    public SingInUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Boolean execute(String login, String pass){
        return this.userRepository.singIn(login, pass);
    }
}
