package com.example.quanlychitieu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychitieu.Adapter.AdapterKhoanThu;
import com.example.quanlychitieu.Fragment.Fragment_KhoanThu;
import com.example.quanlychitieu.Model.DBKhoanThu;
import com.example.quanlychitieu.Model.KhoanThu;
import com.example.quanlychitieu.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Activity_ChiTietKhoanThu extends AppCompatActivity {

    TextView tvTen;
    EditText edtSoTien,edtNote;
    DBKhoanThu dbKhoanThu;
    ArrayAdapter adapter_lkt;
    static AdapterKhoanThu adapterKhoanThu;


    static List<KhoanThu> data_kt = new ArrayList<>();
    List<String> danhSachLoai = new ArrayList<>();
    Button btnXoa, btnSua,btnBack;
    TextView tvDatePicker;
    DatePicker dpNgay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_khoan_thu);
        setControl();
        setEvents();
    }


    boolean isDatePickerVisible;
    private void setEvents() {
        dbKhoanThu = new DBKhoanThu(this);
        KhoanThu kt=(KhoanThu) getIntent().getSerializableExtra("item");
        adapter_lkt = new ArrayAdapter(this, android.R.layout.simple_list_item_1,danhSachLoai);
        tvTen.setText(kt.getTenkt());
        edtSoTien.setText(kt.getSotien());
        tvDatePicker.setText(kt.getNgay());
        edtNote.setText(kt.getGhichu());

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý khi nút Sửa được nhấn
                KhoanThu khoanThu = new KhoanThu();
                khoanThu.setTenkt(tvTen.getText().toString());
                khoanThu.setNgay(tvDatePicker.getText().toString());
                khoanThu.setSotien(edtSoTien.getText().toString());
                khoanThu.setGhichu(edtNote.getText().toString());
                dbKhoanThu.SuaDL(khoanThu);
                Toast.makeText(Activity_ChiTietKhoanThu.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                data_kt.clear();
                data_kt.addAll(dbKhoanThu.DocDL());
                adapterKhoanThu.notifyDataSetChanged();
                onBackPressed();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý khi nút Xóa được nhấn
                KhoanThu khoanThu = new KhoanThu();
                khoanThu.setTenkt(tvTen.getText().toString());
                dbKhoanThu.XoaDL(khoanThu);
                Toast.makeText(Activity_ChiTietKhoanThu.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
                data_kt.clear();
                data_kt.addAll(dbKhoanThu.DocDL());
                adapterKhoanThu.notifyDataSetChanged();
                onBackPressed();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tvDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDatePickerVisible) {
                    dpNgay.setVisibility(View.GONE);  // Ẩn DatePicker
                    isDatePickerVisible = false;
                } else {
                    dpNgay.setVisibility(View.VISIBLE);  // Hiển thị DatePicker
                    isDatePickerVisible = true;
                }
            }
        });

        dpNgay.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Hiển thị ngày đã chọn trong TextView
                String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                tvDatePicker.setText(selectedDate);

                // Thu nhỏ DatePicker (ẩn nó sau khi ngày được chọn)
                dpNgay.setVisibility(View.GONE);
                isDatePickerVisible = false;
            }
        });
    }

    private void setControl() {
        tvDatePicker = findViewById(R.id.tvDatePicker);
        dpNgay = findViewById(R.id.dpNgay);
        dpNgay.setVisibility(View.GONE);  // Ban đầu, ẩn DatePicker
        tvTen = findViewById(R.id.tvTenKT);
        edtSoTien = findViewById(R.id.edtSoTien);
        edtNote = findViewById(R.id.edtNote);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnBack = findViewById(R.id.btnBack);
    }
}