package ru.mirea.fedulovama.myarticleapp.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ru.mirea.fedulovama.myarticleapp.R;
import ru.mirea.fedulovama.myarticleapp.data.repository.ArticleRepositoryImpl;
import ru.mirea.fedulovama.myarticleapp.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.domain.repository.ArticleRepository;
import ru.mirea.fedulovama.myarticleapp.domain.usecases.GetArticlesUseCase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView infoText = findViewById(R.id.infoText);
        ArticleRepository articleRepository = new ArticleRepositoryImpl(getApplicationContext());
        findViewById(R.id.getAllArticlesButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Article> articles = new GetArticlesUseCase(articleRepository).execute();
                StringBuilder builder = new StringBuilder();
                for(Article article: articles){
                    builder.append("Название: ").append(article.getName()).append("\n");
                    builder.append("Описание: ").append(article.getDescription()).append("\n\n");
                }
                infoText.setText(builder.toString());
            }
        });
    }
}