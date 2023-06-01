package ru.mirea.pak.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref= getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
        SharedPreferences.Editor	editor	=	sharedPref.edit();
        editor.putString("GROUP", "BSBO-07-21");
        editor.putInt("NUMBER", 18);
        editor.putBoolean("Большой Куш", true);
        editor.apply();

        String name = sharedPref.getString("GROUP ", "unknown");
        int age = sharedPref.getInt("NUMBER ", 0);
        boolean isSingle = sharedPref.getBoolean("IS_EXCELLENT ", false);

    }
}