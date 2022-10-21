package com.example.asmaulnabi22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;


public class DetailActivity extends AppCompatActivity {
    private String KEY_JUDUL = "JUDUL";
    private String KEY_GAMBAR = "gambar";
    ImageView gbr;
    int gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        gbr = (ImageView) findViewById(R.id.imageView);
        gambar = getIntent().getIntExtra(KEY_GAMBAR, 0);
        gbr.setImageResource(gambar);
    }
}