package com.example.passwords;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class yeniHesapActivity extends AppCompatActivity {
    private EditText hesapAdi, name, password = null;
    private Button btnKaydet = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeni_hesap_page);

        hesapAdi = (EditText) findViewById(R.id.hesapAdiText);
        name = (EditText) findViewById(R.id.kullaniciAdiText);
        password = (EditText) findViewById(R.id.sifreText);
        btnKaydet = (Button) findViewById(R.id.btnYeniHesapEkle);

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String hesapadi = hesapAdi.getText().toString().trim();
                    String kullaniciName = name.getText().toString().trim();
                    String Password = password.getText().toString().trim();

                    if(hesapadi.equals("") || kullaniciName.equals("") || Password.equals("")) {
                        Toast.makeText(getApplicationContext(),"HESAP ADI, KULLANICI ADI VE ŞİFRE ALANLARI DOLDURULMALIDIR!", Toast.LENGTH_SHORT).show();
                    } else {
                        Database vt = new Database(yeniHesapActivity.this);
                        vt.VeriEkle(hesapadi,kullaniciName,Password);
                        hesapAdi.setText("");
                        name.setText("");
                        password.setText("");
                        Toast.makeText(getApplicationContext(),"BAŞARIYLA KAYIT OLUŞTURULDU!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"HATA OLUŞTU!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
