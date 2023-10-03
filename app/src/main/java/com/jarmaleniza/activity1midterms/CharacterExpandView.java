package com.jarmaleniza.activity1midterms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class CharacterExpandView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_expand_view);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView charImage = findViewById(R.id.charImage);
        Intent intent = getIntent();
        Bundle intentBundle = intent.getExtras();

        int imageInt = intentBundle.getInt("CharacterImage");

        charImage.setImageResource(imageInt);
    }
}