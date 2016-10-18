package com.pe1n.pokemon.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pe1n.pokemon.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new SplashTask()).start();

    }

    class SplashTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
                startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
