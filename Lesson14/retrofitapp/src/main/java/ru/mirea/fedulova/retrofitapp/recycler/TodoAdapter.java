package ru.mirea.fedulova.retrofitapp.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.mirea.fedulova.retrofitapp.R;
import ru.mirea.fedulova.retrofitapp.api.Todo;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder>	{
    private LayoutInflater layoutInflater;
    private List<Todo> todos;
    public TodoAdapter(Context context, List<Todo>	todoList){
        this.layoutInflater	= LayoutInflater.from(context);
        this.todos = todoList;
    }
    @NonNull
    @Override
    public	TodoViewHolder	onCreateViewHolder(@NonNull ViewGroup parent, int viewType)	{
        View view =	layoutInflater.inflate(R.layout.item, parent, false);
        return new TodoViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position)	{
        Todo todo =	todos.get(position);
        holder.textViewTitle.setText(todo.getTitle());
        holder.checkBoxCompleted.setChecked(todo.getCompleted());
        Picasso.get()
                .load("https://cdn1.tenchat.ru/static/vbc-gostinder/2023-10-28/compressed/bd77a1b4-a39c-48ed-94d7-57e48aded88b.jpeg")
                .resize(100,100)
                .centerCrop()
                .error(R.drawable.error_image)
                .placeholder(R.drawable.placeholder)
                .into(holder.imageView);
    }
    @Override
    public int getItemCount()	{
        return todos.size();
    }
}