package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.models.User;
import ru.mirea.fedulovama.myarticleapp.domain.repository.ArticleRepository;
import ru.mirea.fedulovama.myarticleapp.domain.repository.UserRepository;

public class AddArticleToFavsUseCase {
    private UserRepository userRepository;
    public AddArticleToFavsUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Boolean execute(Article article, User user){
        return this.userRepository.saveArticleToFavorite(article, user);
    }
}
