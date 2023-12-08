package com.example.quanlychitieu.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBKhoanThu extends SQLiteOpenHelper {
    public DBKhoanThu(@Nullable Context context){
        super(context,"dbKhoanThu",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="Create table tbKhoanThu(tenkt text,ngay text,sotien text,ghichu text)";
        sqLiteDatabase.execSQL(sql);
    }

    public void ThemDL(KhoanThu kt){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="insert into tbKhoanThu values(?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{kt.getTenkt(), kt.getNgay(), kt.getSotien(), kt.getGhichu()});
    }

    public void SuaDL(KhoanThu kt){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "Update tbKhoanThu set ngay = ?,sotien=?,ghiChu=? where tenkt=?";
        sqLiteDatabase.execSQL(sql, new  String[]{kt.getNgay(), kt.getSotien(),kt.getGhichu(),kt.getTenkt()});
    }
    public KhoanThu LayDLTheoTen(String tenkt) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "SELECT * FROM tbKhoanThu WHERE tenkt = ?";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, new String[]{tenkt});

        KhoanThu khoanThu = null;

        if (cursor.moveToFirst()) {
            khoanThu = new KhoanThu();
            khoanThu.setTenkt(cursor.getString(0));
            khoanThu.setNgay(cursor.getString(1));
            khoanThu.setSotien(cursor.getString(2));
            khoanThu.setGhichu(cursor.getString(3));
        }

        cursor.close();
        return khoanThu;
    }

    public void XoaDL(KhoanThu kt){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "DELETE FROM tbKhoanThu WHERE tenkt=?";
        sqLiteDatabase.execSQL(sql, new String[]{kt.getTenkt()});
    }
    public List<KhoanThu> DocDL(){
        List<KhoanThu>data=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        String sql="select * from tbKhoanThu";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst())
        {
            do {
                KhoanThu khoanThu=new KhoanThu();
                khoanThu.setTenkt(cursor.getString(0));
                khoanThu.setNgay(cursor.getString(1));
                khoanThu.setSotien(cursor.getString(2));
                khoanThu.setGhichu(cursor.getString(3));
                data.add(khoanThu);
            }
            while (cursor.moveToNext());
        }
        return data;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }
}
