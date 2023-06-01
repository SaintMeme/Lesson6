package ru.mirea.pak.securesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.widget.TextView;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        SharedPreferences secureSharedPreferences;
        KeyGenParameterSpec keyGenParameterSpec	=	MasterKeys.AES256_GCM_SPEC;
        try	{
            String	mainKeyAlias	=	MasterKeys.getOrCreate(keyGenParameterSpec);
            secureSharedPreferences	=	EncryptedSharedPreferences.create(
                    "secret_shared_prefs",
                    mainKeyAlias,
                    getBaseContext(),
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );

            secureSharedPreferences.edit().putString("поэт/музыкант",	"Maynard James Keenan").apply();

        }	catch	(GeneralSecurityException | IOException e)	{
            throw	new	RuntimeException(e);
        }
        textView.setText(secureSharedPreferences.getString("поэт/музыкант",	"Maynard James Keenan"));
    }
}