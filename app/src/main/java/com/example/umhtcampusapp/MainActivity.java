package com.example.umhtcampusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lihatdata=(Button)findViewById(R.id.lihat_data);
        Button inputdata=(Button)findViewById(R.id.input_data);
        Button info=(Button)findViewById(R.id.informasi);
        lihatdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent inte = new Intent(MainActivity.this, DataMahasiswa.class);
                startActivity(inte);
            }
        });
        inputdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent inte = new Intent(MainActivity.this, DataInput.class);
                startActivity(inte);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent inte = new Intent(MainActivity.this, Informasi.class);
                startActivity(inte);
            }
        });
    }
}