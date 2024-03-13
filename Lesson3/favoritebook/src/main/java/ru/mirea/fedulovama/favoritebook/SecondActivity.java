package ru.mirea.fedulovama.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class SecondActivity extends AppCompatActivity {

    private TextInputEditText _textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        _textInput = findViewById(R.id.textInputEditText);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView ageView = findViewById(R.id.textView2);
            String university = extras.getString(MainActivity.KEY);
            ageView.setText(String.format("Любимая книга разработчика - %s", university));
        }
    }

    public void postTitle(View view){
        Intent data = new Intent();
        String _text;
        if (_textInput.getText() != null) _text = _textInput.getText().toString();
        else _text = "";
        data.putExtra(MainActivity.USER_MESSAGE, _text);
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}