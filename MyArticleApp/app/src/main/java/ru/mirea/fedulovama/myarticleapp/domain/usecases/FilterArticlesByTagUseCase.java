package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import java.util.Date;
import java.util.List;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.repository.ArticleRepository;

public class FilterArticlesByTagUseCase {
    private ArticleRepository articleRepository;
    public FilterArticlesByTagUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public List<Article> execute(String tag){
        return articleRepository.filterArticlesByTag(tag);
    }
}
