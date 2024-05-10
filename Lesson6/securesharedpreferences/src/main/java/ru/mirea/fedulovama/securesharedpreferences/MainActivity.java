package ru.mirea.fedulovama.securesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import ru.mirea.fedulovama.securesharedpreferences.databinding.ActivityMainBinding;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String author;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	=	ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        author = binding.textView.getText().toString();
        try {
            KeyGenParameterSpec keyGenParameterSpec	=	MasterKeys.AES256_GCM_SPEC;
            String	mainKeyAlias	=	MasterKeys.getOrCreate(keyGenParameterSpec);
            SharedPreferences secureSharedPreferences	=	EncryptedSharedPreferences.create(
                    "secret_shared_prefs",
                    mainKeyAlias,
                    getBaseContext(),
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
            secureSharedPreferences.edit().putString("secure",	author).apply();
            String	result	=	secureSharedPreferences.getString("secure",	"ЛЮБИМЫЙ АКТЕР");
            Log.d("SECURE", "result: " + result);
        } catch (GeneralSecurityException	|	IOException	e) {
            e.printStackTrace();
        }
    }
}