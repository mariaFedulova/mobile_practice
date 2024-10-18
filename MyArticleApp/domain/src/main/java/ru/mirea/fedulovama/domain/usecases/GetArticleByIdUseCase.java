package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.domain.repository.ArticleRepository;

public class GetArticleByIdUseCase {
    private ArticleRepository articleRepository;
    public GetArticleByIdUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public Article execute(int index){
        return articleRepository.getArticleById(index);
    }
}
