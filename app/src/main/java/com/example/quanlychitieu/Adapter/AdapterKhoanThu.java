package com.example.quanlychitieu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlychitieu.Model.KhoanThu;
import com.example.quanlychitieu.R;

import java.util.List;

public class AdapterKhoanThu extends ArrayAdapter {
    Context context;
    int resource;
    List<KhoanThu> data;

    public AdapterKhoanThu(@NonNull Context context, int resource, @NonNull List<KhoanThu> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        TextView tvTenKT = convertView.findViewById(R.id.tvTenKT);
        TextView tvSoTien = convertView.findViewById(R.id.tvSoTien);
        TextView tvNgay = convertView.findViewById(R.id.tvNgay);
        TextView tvNote = convertView.findViewById(R.id.tvNote);
        KhoanThu khoanThu = data.get(position);
        tvTenKT.setText(khoanThu.getTenkt());
        tvSoTien.setText(khoanThu.getSotien());
        tvNote.setText(khoanThu.getGhichu());
        tvNgay.setText(khoanThu.getNgay()); // Gán giá trị ngày vào tvNgay

        return convertView;
    }
}
