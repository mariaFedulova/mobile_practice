package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.repository.ArticleRepository;

public class RemoveArticleFromFavsUseCase {
    private ArticleRepository articleRepository;
    public RemoveArticleFromFavsUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public Boolean execute(int index){
        return articleRepository.removeArticleFromFavsById(index);
    }
}
