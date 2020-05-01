package com.example.passwords;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class hesapListePage  extends AppCompatActivity {
    private ListView veriListele;
    private int idBul = 0;
    private List<String> list;
    private List<String> listTable = new ArrayList<String>();
    private List<String> passwords = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hesap_listele);
        veriListele = (ListView) findViewById(R.id.hesapListe);
        veriListele.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Tıklanan verimizi alıyoruz
                String item = veriListele.getItemAtPosition(position).toString();
                // - Göre bölüyoruz
                String[] itemBol = item.split(" - ");
                incele(itemBol[0].toString(),itemBol[1].toString(),passwords.get(position));
            }
        });
        Listele();
    }
    public void Listele(){
        Database vt = new Database(hesapListePage.this);
        list = vt.VeriListele();
        listTable.clear();
        for (String ws : list) {
            String[] itemBol = ws.split(" - ");
            passwords.add(itemBol[3].toString());
            listTable.add(itemBol[1].toString()+" - "+itemBol[2].toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(hesapListePage.this, android.R.layout.simple_list_item_1,android.R.id.text1,listTable);
        veriListele.setAdapter(adapter);
    }

    public void incele(String a1, String a2, String a3){
        Intent myIntent = new Intent(this, hesapInceleActivity.class);
        myIntent.putExtra("firstKeyName", a1);
        myIntent.putExtra("secondKeyName", a2);
        myIntent.putExtra("thirdKeyName", a3);
        startActivity(myIntent);
    }

}
