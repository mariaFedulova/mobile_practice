package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import java.util.List;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.models.User;
import ru.mirea.fedulovama.myarticleapp.domain.repository.UserRepository;

public class GetUserArticlesUseCase {
    private UserRepository userRepository;
    public GetUserArticlesUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<Article> execute(User user){
        return this.userRepository.getUserArticles( user);
    }
}
