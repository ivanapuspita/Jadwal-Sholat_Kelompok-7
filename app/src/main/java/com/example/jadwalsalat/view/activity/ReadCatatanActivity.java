package com.example.jadwalsalat.view.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.jadwalsalat.R;
import com.example.jadwalsalat.adapter.CatatanAdapter;
import com.example.jadwalsalat.database.CatatanModel;
import com.example.jadwalsalat.database.DatabaseCatatan;

import java.util.ArrayList;

public class ReadCatatanActivity extends AppCompatActivity {

    private CatatanAdapter catatanAdapter;
    private RecyclerView rvCatatan;
    private DatabaseCatatan databaseCatatan;
    private ArrayList<CatatanModel> listCatatan = new ArrayList<>();
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_catatan);

        rvCatatan = findViewById(R.id.readactivity_rv_catatan);
        catatanAdapter = new CatatanAdapter(getApplicationContext());
        catatanAdapter.notifyDataSetChanged();
        catatanAdapter.setDialog(new CatatanAdapter.Dialog() {
            @Override
            public void onClick(int position) {
                final CharSequence[] dialogItem = {"Delete"};
                dialog = new AlertDialog.Builder(ReadCatatanActivity.this);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i){
                            case 0:
                                //delete
                                CatatanModel catatanModel = listCatatan.get(position);
                                databaseCatatan.catatanDAO().deleteCatatan(catatanModel);
                                onStart();
                                break;
                            case 1:
//                                CatatanModel catatanModel = listCatatan.get(position);
//                                databaseCatatan.catatanDAO().deleteCatatan(catatanModel);
//                                onStart();
                                break;
                        }
                    }
                });
                dialog.show();
            }
        });

        if (databaseCatatan == null){
            databaseCatatan = DatabaseCatatan.initDbs(getApplicationContext());
        }

        listCatatan.addAll(databaseCatatan.catatanDAO().getCatatancatatan());
        catatanAdapter.setData(listCatatan);

        rvCatatan.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvCatatan.setAdapter(catatanAdapter);

    }

    //untuk mengclearkan
    @Override
    protected void onStart() {
        super.onStart();
        listCatatan.clear();
        listCatatan.addAll(databaseCatatan.catatanDAO().getCatatancatatan());
        catatanAdapter.notifyDataSetChanged();
    }

}