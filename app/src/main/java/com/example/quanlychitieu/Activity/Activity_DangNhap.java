package com.example.quanlychitieu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlychitieu.R;

public class Activity_DangNhap extends AppCompatActivity {

    EditText edtTK,edtMK;
    Button btnDangNhap,btnDangKi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        onCreate();
        setEvent();
    }

    private void setEvent() {
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_DangNhap.this, Activity_DangKi.class);
                startActivity(intent);
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_DangNhap.this, Activity_TrangChu.class);
                startActivity(intent);
            }
        });
    }
    private void onCreate() {
        edtTK = findViewById(R.id.edtTK);
        edtMK = findViewById(R.id.edtMK);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKi = findViewById(R.id.btnDangKi);
    }
}