package ru.mirea.fedulovama.myarticleapp.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.repository.ArticleRepository;

public class ArticleRepositoryImpl implements ArticleRepository {
    private Context context;
    private List<Article> articles;
    public ArticleRepositoryImpl(Context context){
        this.context = context;
        this.articles = new ArrayList<>();
        this.articles.add(new Article(1, "25 фактов о Джейсоне Стэйтеме", "Мы собрали несколько фактов и цитат о жизни британского актера."));
        this.articles.add(new Article(2, "«Не говори никому»: хоррор в духе «Сплита», в котором Джеймс Макэвой снова играет мускулами", "В мировой прокат вышла новая лента компании Blumhouse — стабильного поставщика не очень дорогих, но качественных хорроров."));
    }
    public List<Article> getArticles() {
        return this.articles;
    }
    public Article getArticleById(int index){
        return this.articles.get(index);
    }

    public Article getFavoriteArticles(){
        SharedPreferences settings = context.getSharedPreferences("favorite_article", Context.MODE_PRIVATE);
        return new Article(1, settings.getString("favotite_article", ""), "");
    }
    public Boolean editArticleById(int index, String name, String description){
        return true;
    }

    public List<Article> filterArticlesByDate(Date start, Date end){
        return this.articles;
    }

    public List<Article> filterArticlesByTag(String tag){
        return this.articles;
    }
    public List<Article> getUserArticles(int userIndex){ return this.articles; }
    public Article removeArticleById(int index){ return this.articles.remove((index)); }
    public Boolean removeArticleFromFavsById(int index){
        SharedPreferences settings = context.getSharedPreferences("favorite_article", Context.MODE_PRIVATE);
        settings.edit().remove(String.valueOf(index)).apply();
        return true;
    }
}
