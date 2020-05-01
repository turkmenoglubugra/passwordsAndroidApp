package com.example.passwords;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button yeniHesap;
    private Button hesapListesi;
    private Button hesapSil;
    private Button hesapDuzenle;
    private Button hakkinda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        yeniHesap = findViewById(R.id.btnYeniHesap);
        yeniHesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapEkleAc();
            }
        });

        hesapListesi = findViewById(R.id.btnHesapListesi);
        hesapListesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapListesiAc();
            }
        });

        hesapSil = findViewById(R.id.btnHesapKaldir);
        hesapSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapSilAc();
            }
        });

        hesapDuzenle = findViewById(R.id.btnYemekDuzenle);
        hesapDuzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapDuzenleAc();
            }
        });


        hakkinda = findViewById(R.id.btnHakkinda);
        hakkinda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iletisim();
            }
        });
    }

    public void hesapEkleAc(){
        Intent intent = new Intent(this, yeniHesapActivity.class );
        startActivity(intent);
    }

    public void hesapListesiAc(){
        Intent intent = new Intent(this, hesapListePage.class );
        startActivity(intent);
    }
    public void hesapSilAc(){
        Intent intent = new Intent(this, hesapSilPage.class );
        startActivity(intent);
    }

    public void hesapDuzenleAc(){
        Intent intent = new Intent(this, hesapDuzenlePage.class );
        startActivity(intent);
    }

    public  void iletisim () {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "bugrakaanturkmenoglu@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "PASSWORDS APP");
        startActivity(Intent.createChooser(emailIntent, null));
    }
}
