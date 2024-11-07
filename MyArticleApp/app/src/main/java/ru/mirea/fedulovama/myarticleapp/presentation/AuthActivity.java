package ru.mirea.fedulovama.myarticleapp.presentation;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;


import ru.mirea.fedulovama.data.repository.UserRepositoryImpl;
import ru.mirea.fedulovama.domain.repository.UserRepository;
import ru.mirea.fedulovama.myarticleapp.R;

public class AuthActivity extends AppCompatActivity {
    private AuthViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        TextInputEditText loginInput = findViewById(R.id.loginTextInput);
        TextInputEditText passInput = findViewById(R.id.passwordTextInput);

        Button singInButton = findViewById(R.id.singInButton);

        vm = new ViewModelProvider(this, new AuthViewModelFactory(getApplicationContext(), FirebaseAuth.getInstance())).get(AuthViewModel.class);

        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = vm.singIn(loginInput.getText().toString(), passInput.getText().toString());
                checkAuth(result);
                String str = "Result is" + result;
                Log.d(TAG, str);
            }
        });

        findViewById(R.id.singUpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = vm.singUp(loginInput.getText().toString(), passInput.getText().toString());
                checkAuth(result);
            }
        });
    }
    protected void checkAuth(Boolean result){
        if(!result){
            Toast.makeText(AuthActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(AuthActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}