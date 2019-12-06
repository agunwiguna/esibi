package com.ciamiscode.esibi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.loopeer.shadow.ShadowView;

public class MainActivity extends AppCompatActivity {

    ShadowView shadowView,shadowView2,shadowView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shadowView = findViewById(R.id.tmp_foto);

        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        shadowView.startAnimation(startAnimation);

        shadowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GambarActivity.class));
            }
        });

        shadowView2 = findViewById(R.id.tmp_foto2);
        shadowView2.startAnimation(startAnimation);
        shadowView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VideoActivity.class));
            }
        });

        shadowView3 = findViewById(R.id.tmp_foto3);
        shadowView3.startAnimation(startAnimation);
        shadowView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BotActivity.class));
            }
        });
    }
}
