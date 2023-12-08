package com.example.quanlychitieu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.quanlychitieu.R;


public class Fragment_KhoanChi extends Fragment {

    public Fragment_KhoanChi() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__khoan_chi, container, false);
    }
}