package ru.mirea.fedulovama.myarticleapp.presentation.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mirea.fedulovama.myarticleapp.R;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    private TextView articleNameView;
    private TextView articleDescriptionView;
    private ImageView articleImageView;
    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        this.articleNameView = itemView.findViewById(R.id.textViewArticleName);
        this.articleDescriptionView = itemView.findViewById(R.id.textViewArticleDescription);
        this.articleImageView = itemView.findViewById(R.id.imageView);

    }

    public ImageView getImgView() {
        return articleImageView;
    }
    public TextView getArticleNameView() {
        return articleNameView;
    }
    public TextView getArticleDescriptionView() {
        return articleDescriptionView;
    }

    /* public void bind(Country item) {
       countryNameView.setText(item.getCountryName());
    }*/
}