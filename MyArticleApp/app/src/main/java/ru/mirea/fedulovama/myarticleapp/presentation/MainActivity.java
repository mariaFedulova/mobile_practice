package ru.mirea.fedulovama.myarticleapp.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import ru.mirea.fedulovama.myarticleapp.R;
import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.presentation.recycler.ArticleRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {
    private MainViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView infoText = findViewById(R.id.infoText);
        TextView userDataTextView = findViewById(R.id.userDataTextView);

        RecyclerView recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArticleRecyclerViewAdapter itemAdapter = new ArticleRecyclerViewAdapter();
        recyclerView.setAdapter(itemAdapter);

        vm = new ViewModelProvider(this, new MainViewModelFactory(getApplicationContext())).get(MainViewModel.class);
        vm.getUserData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                userDataTextView.setText(s);
            }
        });
        vm.getItems().observe(this, items -> {
            itemAdapter.setItems(items); // Обновляем данные в адаптере
        });
        vm.getUserText();
        /*findViewById(R.id.getAllArticlesButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Article> articles = vm.getArticles();
                StringBuilder builder = new StringBuilder();
                for(Article article: articles){
                    builder.append("Название: ").append(article.getName()).append("\n");
                    builder.append("Описание: ").append(article.getDescription()).append("\n\n");
                }
                infoText.setText(builder.toString());
            }
        });*/

        findViewById(R.id.authButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AuthActivity.class);
                startActivity(intent);
            }
        });
    }
}