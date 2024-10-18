package ru.mirea.fedulovama.domain.usecases;

import java.util.List;

import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.domain.models.User;
import ru.mirea.fedulovama.domain.repository.UserRepository;

public class GetUserArticlesUseCase {
    private UserRepository userRepository;
    public GetUserArticlesUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<Integer> execute(User user){
        return this.userRepository.getUserArticles( user);
    }
}
