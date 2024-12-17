package ru.mirea.fedulovama.domain.usecases;

import java.util.List;

import ru.mirea.fedulovama.domain.ApiCallback;
import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.domain.repository.ArticleRepository;

public class GetArticlesFromApiUseCase {
    private ArticleRepository articleRepository;
    public GetArticlesFromApiUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public Article execute(int index){
        return articleRepository.getArticleById(index);
    }
    public void execute(ApiCallback<List<Article>> apiCallback) {
        articleRepository.getArticlesFromApi(apiCallback);
    }
}
