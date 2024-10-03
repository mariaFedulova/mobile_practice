package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import java.util.List;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.repository.ArticleRepository;

public class RemoveArticleByIdUseCase {
    private ArticleRepository articleRepository;
    public RemoveArticleByIdUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public Article execute(int index){
        return articleRepository.removeArticleById(index);
    }
}
