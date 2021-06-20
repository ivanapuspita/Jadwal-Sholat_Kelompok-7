package com.example.jadwalsalat.view.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jadwalsalat.R;
import com.example.jadwalsalat.adapter.JadwalSalatAdapter;
import com.example.jadwalsalat.model.DataItem;
import com.example.jadwalsalat.view.viewmodel.JadwalSalatViewModel;

import java.util.ArrayList;


public class JadwalFragment extends Fragment {


    private JadwalSalatAdapter jadwalSalatAdapter;
    private RecyclerView RV_JadwalSalat;
    private JadwalSalatViewModel jadwalSalatViewModel;


    public JadwalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal, container, false);
    }

//    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        jadwalSalatAdapter = new JadwalSalatAdapter(getContext());
        jadwalSalatAdapter.notifyDataSetChanged();

        RV_JadwalSalat = view.findViewById(R.id.fragmentjadwal_rv);
        RV_JadwalSalat.setLayoutManager(new GridLayoutManager(getContext(),2));

        jadwalSalatViewModel = new ViewModelProvider(this).get(JadwalSalatViewModel.class);
        jadwalSalatViewModel.setJadwalSalat();
        jadwalSalatViewModel.getJadwaSalat().observe(this, getJadwalSalat);


        RV_JadwalSalat.setAdapter(jadwalSalatAdapter);
    }

    private Observer<ArrayList<DataItem>> getJadwalSalat = new Observer<ArrayList<DataItem>>() {
        @Override
        public void onChanged(ArrayList<DataItem> dataItems) {
            if (dataItems != null) {
                jadwalSalatAdapter.setData(dataItems);
            }
        }
    };
}