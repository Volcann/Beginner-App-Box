package com.example.placementanalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ImageView introImage = findViewById(R.id.intro_image);
        fadeOutAndLaunchMainActivity(introImage);
    }

    private void fadeOutAndLaunchMainActivity(ImageView imageView) {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setDuration(3000); // duration in milliseconds
        fadeOut.setFillAfter(true);

        imageView.startAnimation(fadeOut);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // same duration as fade-out
    }
}


