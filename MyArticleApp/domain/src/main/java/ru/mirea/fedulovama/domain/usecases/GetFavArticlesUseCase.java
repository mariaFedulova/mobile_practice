package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.domain.repository.ArticleRepository;

public class GetFavArticlesUseCase {
    private ArticleRepository articleRepository;
    public GetFavArticlesUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public Article execute(){
        return articleRepository.getFavoriteArticles();
    }
}
