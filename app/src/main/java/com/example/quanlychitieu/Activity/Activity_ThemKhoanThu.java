package com.example.quanlychitieu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlychitieu.Model.DBKhoanThu;
import com.example.quanlychitieu.Model.KhoanThu;
import com.example.quanlychitieu.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Activity_ThemKhoanThu extends AppCompatActivity {

    EditText edtTen,edtSoTien,edtNote;
    List<String> danhSachLoai = new ArrayList<>();
    Button btnThem,btnBack;
    TextView tvDatePicker;
    DatePicker dpNgay;
    DBKhoanThu dbKhoanThu;
    ArrayAdapter adapter;
    boolean isDatePickerVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_khoan_thu);
        setControl();
        setEvents();
    }

    private void setEvents() {
        dbKhoanThu =new DBKhoanThu(Activity_ThemKhoanThu.this);
        adapter=new ArrayAdapter<>(Activity_ThemKhoanThu.this, android.R.layout.simple_list_item_1,danhSachLoai);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KhoanThu khoanThu=new KhoanThu();
                khoanThu.setTenkt(edtTen.getText().toString());
                khoanThu.setNgay(tvDatePicker.getText().toString());
                khoanThu.setSotien(edtSoTien.getText().toString());
                khoanThu.setGhichu(edtNote.getText().toString());

                dbKhoanThu.ThemDL(khoanThu);
                Toast.makeText(Activity_ThemKhoanThu.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String defaultDate = dateFormat.format(calendar.getTime());
        tvDatePicker.setText(defaultDate);
        btnThem = findViewById(R.id.btnThem);
        btnBack = findViewById(R.id.btnBack);
        edtTen=findViewById(R.id.edtTen);
        edtSoTien=findViewById(R.id.edtSoTien);
        edtNote=findViewById(R.id.edtNote);
    }
}