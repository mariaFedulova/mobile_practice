package ru.mirea.fedulova.retrofitapp.recycler;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mirea.fedulova.retrofitapp.R;

public class TodoViewHolder extends	RecyclerView.ViewHolder	{
    TextView textViewTitle;
    CheckBox checkBoxCompleted;
    ImageView imageView;
    public	TodoViewHolder(@NonNull View itemView)	{
        super(itemView);
        textViewTitle =	itemView.findViewById(R.id.textViewTitle);
        checkBoxCompleted =	itemView.findViewById(R.id.checkBoxCompleted);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
