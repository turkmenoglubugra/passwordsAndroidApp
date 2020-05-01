package com.example.passwords;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class hesapInceleActivity extends AppCompatActivity {
    private EditText hesapAdi, kullanciAdi, sifre= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hesap_incele);

        Intent myIntent = getIntent();
        String firstKeyName = myIntent.getStringExtra("firstKeyName");
        String secondKeyName= myIntent.getStringExtra("secondKeyName");
        String thirdKeyName= myIntent.getStringExtra("thirdKeyName");

        hesapAdi = (EditText) findViewById(R.id.hesapAdiText);
        kullanciAdi = (EditText) findViewById(R.id.kullaniciAdiText);
        sifre =  (EditText) findViewById(R.id.sifreText);


        hesapAdi.setText(firstKeyName);
        kullanciAdi.setText(secondKeyName);
        sifre.setText(thirdKeyName);

    }
}
