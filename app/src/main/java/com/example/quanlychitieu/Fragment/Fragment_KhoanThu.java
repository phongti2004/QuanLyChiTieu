package com.example.quanlychitieu.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.quanlychitieu.Activity.Activity_ChiTietKhoanThu;
import com.example.quanlychitieu.Activity.Activity_ThemKhoanThu;
import com.example.quanlychitieu.Adapter.AdapterKhoanThu;
import com.example.quanlychitieu.Model.DBKhoanThu;
import com.example.quanlychitieu.Model.KhoanThu;
import com.example.quanlychitieu.R;

import java.util.ArrayList;
import java.util.List;

public class Fragment_KhoanThu extends Fragment {
    static ListView lvDanhSach;
    Button btnThem;
    DBKhoanThu dbKhoanThu;
    static List<KhoanThu> data_kt = new ArrayList<>();
    static AdapterKhoanThu adapterKhoanThu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__khoan_thu, container, false);
        setControl(view);
        setEvent();
        return view;
    }

    private void setEvent() {
        dbKhoanThu = new DBKhoanThu(getContext());
        adapterKhoanThu = new AdapterKhoanThu(getContext(),R.layout.khoanthu_item_layout,data_kt);
        lvDanhSach.setAdapter(adapterKhoanThu);
        docDuLieu();

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getContext(), Activity_ChiTietKhoanThu.class);
                intent.putExtra("item",data_kt.get(i));
                startActivity(intent);
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Activity_ThemKhoanThu.class);
                startActivity(intent);
            }
        });
    }

    private void docDuLieu() {
        data_kt.clear();
        data_kt.addAll(dbKhoanThu.DocDL());
        adapterKhoanThu.notifyDataSetChanged();
    }
    private void setControl(View view) {
        btnThem = view.findViewById(R.id.btnThem);
        lvDanhSach = view.findViewById(R.id.lvDanhSach);
    }
}