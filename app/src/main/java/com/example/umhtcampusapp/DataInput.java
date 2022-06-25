package com.example.umhtcampusapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DataInput extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1;
    EditText text1, text2, text3, text4, text5;
    String edit;
    TextView textv1, textv2, textv3, textv4, textv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_input);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);

        textv1 = (TextView) findViewById(R.id.textView1);
        textv2 = (TextView) findViewById(R.id.textView2);
        textv3 = (TextView) findViewById(R.id.textView3);
        textv4 = (TextView) findViewById(R.id.textView4);
        textv5 = (TextView) findViewById(R.id.textView5);
        ton1 = (Button) findViewById(R.id.buttonSave);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                edit = text1.getText().toString();
                edit = text2.getText().toString();
                edit = text3.getText().toString();
                edit = text4.getText().toString();
                edit = text5.getText().toString();
                if(edit.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Kolom Tidak Boleh Kosong..", Toast.LENGTH_SHORT).show();
                } else {
                    db.execSQL("insert into biodata(NIM,nama,tgl,jk,alamat)values('"+
                        text1.getText().toString()+"','"+
                        text2.getText().toString()+"','"+
                        text3.getText().toString()+"','"+
                        text4.getText().toString()+"','"+
                        text5.getText().toString()+"')");
                    Toast.makeText(getApplicationContext(), "Data Tersimpan..", Toast.LENGTH_LONG).show();
                    finish();
                }
                DataMahasiswa.da.RefreshList();
            }
        });
    }
}