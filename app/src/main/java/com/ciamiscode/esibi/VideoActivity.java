package com.ciamiscode.esibi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class VideoActivity extends AppCompatActivity {

    ImageView imgSapaan, imgKerja, imgSifat, imgImbuhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        imgSapaan = findViewById(R.id.img_sapaan);
        imgKerja = findViewById(R.id.img_kerja);
        imgSifat = findViewById(R.id.img_sifat);
        imgImbuhan = findViewById(R.id.img_imbuhan);

        imgSapaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VideoActivity.this,SapaanActivity.class);
                startActivity(i);
            }
        });

        imgKerja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VideoActivity.this,KerjaActivity.class);
                startActivity(i);
            }
        });

        imgSifat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VideoActivity.this,SifatActivity.class);
                startActivity(i);
            }
        });

        imgImbuhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VideoActivity.this,ImbuhanActivity.class);
                startActivity(i);
            }
        });

    }
}
