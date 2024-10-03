package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import java.util.Date;
import java.util.List;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.repository.ArticleRepository;

public class FilterArticlesByDateUseCase {
    private ArticleRepository articleRepository;
    public FilterArticlesByDateUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public List<Article> execute(Date start, Date end){
        return articleRepository.filterArticlesByDate(start, end);
    }
}
