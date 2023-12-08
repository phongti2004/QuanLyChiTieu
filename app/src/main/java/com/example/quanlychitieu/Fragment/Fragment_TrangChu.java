package com.example.quanlychitieu.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.quanlychitieu.Activity.Activity_ThuChi;
import com.example.quanlychitieu.Activity.Activity_TroGiup;
import com.example.quanlychitieu.Activity.Activity_User;
import com.example.quanlychitieu.R;

public class Fragment_TrangChu extends Fragment {

    ImageView ivUser;
    Button btnKhoanThu, btnKhoanChi, btnThongKe, btnMuctieu, btnTroGiup;

    public Fragment_TrangChu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__trang_chu, container, false);
        setEvent(view);
        return view;
    }

    private void setEvent(View view) {
        btnTroGiup = view.findViewById(R.id.btnTroGiup);
        btnKhoanThu = view.findViewById(R.id.btnKhoanThu);
        btnKhoanChi = view.findViewById(R.id.btnKhoanChi);
        btnThongKe = view.findViewById(R.id.btnThongKe);
        btnMuctieu = view.findViewById(R.id.btnMucTieu);
        ivUser = view.findViewById(R.id.ivUser);

        btnTroGiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity_TroGiup.class);
                startActivity(intent);
            }
        });

        btnKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity_ThuChi.class);
                startActivity(intent);
            }
        });

        btnKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity_ThuChi.class);
                startActivity(intent);
            }
        });

        ivUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity_User.class);
                startActivity(intent);
            }
        });
    }
}