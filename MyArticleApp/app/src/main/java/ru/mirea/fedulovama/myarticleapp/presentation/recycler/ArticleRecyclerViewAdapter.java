package ru.mirea.fedulovama.myarticleapp.presentation.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

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
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(article.getImg(),
                "drawable", pkgName);
        // Bind data to viewholder
        holder.getImgView().setImageResource(resID);
        holder.getArticleNameView().setText(article.getName());
        holder.getArticleDescriptionView().setText("ОПИСАНИЕ: " +
                article.getDescription());
    }
    @Override
    public int getItemCount() {
        return this.articles.size();
    }
}
