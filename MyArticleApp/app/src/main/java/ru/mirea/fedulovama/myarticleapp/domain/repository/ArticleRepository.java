package ru.mirea.fedulovama.myarticleapp.domain.repository;

import java.util.Date;
import java.util.List;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;

public interface ArticleRepository {
    public List<Article> getArticles();
    public Article getArticleById(int id);
    public Article getFavoriteArticles();
    public Boolean editArticleById(int index, String name, String description);
    public List<Article> filterArticlesByDate(Date start, Date end);
    public List<Article> filterArticlesByTag(String tag);
    public List<Article> getUserArticles(int userIndex);
    public Article removeArticleById(int index);
    public Boolean removeArticleFromFavsById(int index);
}
