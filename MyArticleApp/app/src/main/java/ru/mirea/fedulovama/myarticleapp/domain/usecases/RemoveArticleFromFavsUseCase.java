package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.repository.ArticleRepository;

public class RemoveArticleFromFavsUseCase {
    private ArticleRepository articleRepository;
    public RemoveArticleFromFavsUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public Boolean execute(int index){
        return articleRepository.removeArticleFromFavsById(index);
    }
}
