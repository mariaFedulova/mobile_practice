package ru.mirea.fedulovama.domain.usecases;

import ru.mirea.fedulovama.domain.repository.ArticleRepository;

public class EditArticleByIdUseCase {
    private ArticleRepository articleRepository;
    public EditArticleByIdUseCase(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    public Boolean execute(int index, String name, String description){
        return articleRepository.editArticleById(index, name, description);
    }
}
