package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.domain.models.User;
import ru.mirea.fedulovama.domain.repository.UserRepository;

public class AddArticleToFavsUseCase {
    private UserRepository userRepository;
    public AddArticleToFavsUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Boolean execute(Article article, User user){
        return this.userRepository.saveArticleToFavorite(article, user);
    }
}