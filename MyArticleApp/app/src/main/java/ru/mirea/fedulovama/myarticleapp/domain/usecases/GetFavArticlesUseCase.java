package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import java.util.List;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.repository.ArticleRepository;

public class GetFavArticlesUseCase {
    private ArticleRepository articleRepository;
    public GetFavArticlesUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public Article execute(){
        return articleRepository.getFavoriteArticles();
    }
}
