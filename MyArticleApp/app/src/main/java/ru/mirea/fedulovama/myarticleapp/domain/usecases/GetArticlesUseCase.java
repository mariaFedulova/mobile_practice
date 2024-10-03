package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import java.util.List;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.repository.ArticleRepository;

public class GetArticlesUseCase {
    private ArticleRepository articleRepository;

    public GetArticlesUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public List<Article> execute(){
        return articleRepository.getArticles();
    }
}
