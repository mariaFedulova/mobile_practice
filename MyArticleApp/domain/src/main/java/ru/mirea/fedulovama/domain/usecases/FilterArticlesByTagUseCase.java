package ru.mirea.fedulovama.domain.usecases;

import java.util.List;

import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.domain.repository.ArticleRepository;

public class FilterArticlesByTagUseCase {
    private ArticleRepository articleRepository;
    public FilterArticlesByTagUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public List<Article> execute(String tag){
        return articleRepository.filterArticlesByTag(tag);
    }
}
