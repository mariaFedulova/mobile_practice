package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import java.util.List;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.models.User;
import ru.mirea.fedulovama.myarticleapp.domain.repository.UserRepository;

public class GetUserDataUseCase {
    private UserRepository userRepository;
    public GetUserDataUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public String execute(User user){
        return this.userRepository.getUserData( user);
    }
}
