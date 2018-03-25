package com.example.android.amaliayovadiani_1202154301_studycase5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class tambahanKegiatan extends AppCompatActivity {
    private EditText ToDo;
    private EditText Description;
    private EditText Priority;
    private database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahan_kegiatan);
        setTitle("Add To Do");

        ToDo = (EditText) findViewById(R.id.edt_Todo);
        Description = (EditText) findViewById(R.id.edt_Desc);
        Priority = (EditText) findViewById(R.id.edt_Priority);
        db = new database(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(tambahanKegiatan.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void addTodo(View view) { //mengisi kegiatan
        if (db.inputdata(new dataKegiatan(ToDo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){
            Toast.makeText(this, "Berhasil ditambah", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(tambahanKegiatan.this, MainActivity.class));
            this.finish();
        }else {
            Toast.makeText(this, "Silahkan diisi", Toast.LENGTH_SHORT).show();
            ToDo.setText(null); //set jadi kosong
            Description.setText(null);
            Priority.setText(null);
        }
    }

}
