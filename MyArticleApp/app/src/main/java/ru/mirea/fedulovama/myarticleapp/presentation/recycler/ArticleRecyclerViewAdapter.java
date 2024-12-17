package ru.mirea.fedulovama.myarticleapp.presentation.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.mirea.fedulovama.domain.models.Article;
import ru.mirea.fedulovama.myarticleapp.R;

public class ArticleRecyclerViewAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private List<Article> articles;
    private Context context;
    public void setItems(List<Article> items) {
        this.articles = items;
        notifyDataSetChanged();
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(final ViewGroup parent, int
            viewType) {
        // Inflate view from recyclerview_item_layout.xml
        context = parent.getContext();
        View recyclerViewItem =
                LayoutInflater.from(context).inflate(R.layout.article_item_view, parent,
                        false);
        return new ArticleViewHolder(recyclerViewItem);
    }
    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Article article = this.articles.get(position);
        Log.d("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!", article.getDescription());
        Picasso.get()
                .load(article.getImg())
                .resize(100,100)
                .centerCrop()
                .error(R.drawable.error_image)
                .placeholder(R.drawable.placeholder)
                .into(holder.getImgView());
        holder.getArticleNameView().setText(article.getName());
        holder.getArticleDescriptionView().setText("ОПИСАНИЕ: " +
                article.getDescription());
    }
    @Override
    public int getItemCount() {
        return this.articles.size();
    }
}
