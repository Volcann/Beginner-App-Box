package com.example.placementanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    ImageView congratsImageView, failedImageView;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        congratsImageView = findViewById(R.id.congratsImageView);
        failedImageView = findViewById(R.id.failedImageView);
        backButton = findViewById(R.id.backButton);

        // Get the result from the intent
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");

        if ("Congrats".equals(result)) {
            congratsImageView.setVisibility(View.VISIBLE);
            failedImageView.setVisibility(View.GONE);
        } else {
            congratsImageView.setVisibility(View.GONE);
            failedImageView.setVisibility(View.VISIBLE);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate back to MainActivity
                Intent backIntent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(backIntent);
            }
        });
    }
}
