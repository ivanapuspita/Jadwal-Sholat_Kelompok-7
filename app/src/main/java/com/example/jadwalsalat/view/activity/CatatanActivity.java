package com.example.jadwalsalat.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jadwalsalat.R;
import com.example.jadwalsalat.database.CatatanModel;
import com.example.jadwalsalat.database.DatabaseCatatan;

public class CatatanActivity extends AppCompatActivity {
    private DatabaseCatatan databaseCatatan;
    private Button btnLihatData, btnSimpan;
    private EditText etJudul, etCatatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);

        btnLihatData = findViewById(R.id.activitycatatan_btn_lihatdata);
        btnSimpan = findViewById(R.id.activitycatatan_btn_simpan);

        etJudul = findViewById(R.id.activitycatatan_et_judul);
        etCatatan = findViewById(R.id.activitycatatan_et_catatan);

        databaseCatatan = DatabaseCatatan.initDbs(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    CatatanModel catatanModel = new CatatanModel();
                    catatanModel.setWaktu(etJudul.getText().toString());
                    catatanModel.setCatatan(etCatatan.getText().toString());

                    databaseCatatan.catatanDAO().insertCatatan(catatanModel);

                    Log.d("CatatanActivity" , "sukses ");
                    Toast.makeText(getApplicationContext(),"Tersimpan", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Log.e("CatatanActivity" , "gagal menyimpan , msg : "+ex.getMessage());
                    Toast.makeText(getApplicationContext(),"Gagal Menyimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });


        findViewById(R.id.activitycatatan_btn_lihatdata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CatatanActivity.this, com.example.jadwalsalat.view.activity.ReadCatatanActivity.class));

            }
        });
    }
}