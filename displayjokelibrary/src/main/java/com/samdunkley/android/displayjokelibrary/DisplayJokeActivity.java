package com.samdunkley.android.displayjokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public static String EXTRA_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra(EXTRA_JOKE)) {
            TextView jokesTextView = findViewById(R.id.joke_text_view);
            jokesTextView.setText(intent.getStringExtra(EXTRA_JOKE));
        }

    }
}
