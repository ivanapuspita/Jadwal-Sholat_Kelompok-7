package com.example.jadwalsalat.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.jadwalsalat.R;
import com.example.jadwalsalat.model.Timings;

public class JadwalSalatDetailActivity extends AppCompatActivity {
    public static final String Extra_Jadwal="";
    private Timings TimingsItem;
    private TextView tvFajr, tvDhuhr, tvAsr, tvMaghrib,tvIsha,tvImsak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvFajr = findViewById(R.id.tv_value1);
        tvDhuhr = findViewById(R.id.tv_value2);
        tvAsr = findViewById(R.id.tv_value3);
        tvMaghrib = findViewById(R.id.tv_value4);
        tvIsha = findViewById(R.id.tv_value5);
        tvImsak = findViewById(R.id.tv_value6);

        getIncomingIntent();

    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String getTvFajr = bundle.getString("tvFajr");
            String getTvDhuhr = bundle.getString("tvDhuhr");
            String getTvAsr = bundle.getString("tvAsr");
            String getTvMaghrib = bundle.getString("tvMaghrib");
            String getTvIsha = bundle.getString("tvIsha");
            String getTvImsak = bundle.getString("tvImsak");

            tvFajr.setText(getTvFajr);
            tvDhuhr.setText(getTvDhuhr);
            tvAsr.setText(getTvAsr);
            tvMaghrib.setText(getTvMaghrib);
            tvIsha.setText(getTvIsha);
            tvImsak.setText(getTvImsak);
        }

    }


}