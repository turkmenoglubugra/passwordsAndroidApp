package com.example.passwords;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class guncelle extends AppCompatActivity {
    private EditText hesapAdi, kullanciAdi, sifre= null;
    private Button btnGuncelle = null;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hesap_guncelle);

        hesapAdi = (EditText) findViewById(R.id.hesapAdiText);
        kullanciAdi = (EditText) findViewById(R.id.kullaniciAdiText);
        sifre = (EditText) findViewById(R.id.sifreText);
        btnGuncelle = (Button) findViewById(R.id.btnHesapGuncelle);

        Intent myIntent = getIntent();
        id = Integer.valueOf(myIntent.getStringExtra("id"));
        String firstKeyName = myIntent.getStringExtra("firstKeyName");
        String secondKeyName= myIntent.getStringExtra("secondKeyName");
        String thirdKeyName= myIntent.getStringExtra("thirdKeyName");

        hesapAdi.setText(firstKeyName);
        kullanciAdi.setText(secondKeyName);
        sifre.setText(thirdKeyName);

        btnGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String adi = hesapAdi.getText().toString().trim();
                    String kullanici = kullanciAdi.getText().toString().trim();
                    String Sifre = sifre.getText().toString().trim();
                    if(adi.equals("") || kullanici.equals("") || Sifre.equals("")) {
                        Toast.makeText(getApplicationContext(),"HESAP ADI, KULLANCI ADI VE ŞİFRE ALANLARI DOLDURULMALIDIR!", Toast.LENGTH_SHORT).show();
                    } else {
                        Database vt = new Database(guncelle.this);
                        vt.VeriDuzenle(id,adi,kullanici,Sifre);
                        Toast.makeText(getApplicationContext(),"BAŞARIYLA KAYIT GÜNCELLENDİ!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"HATA OLUŞTU!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
