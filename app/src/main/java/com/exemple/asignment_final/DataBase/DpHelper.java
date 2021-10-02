package com.exemple.asignment_final.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DpHelper extends SQLiteOpenHelper {
    public DpHelper(Context context){
        super(context,"thuchi",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlUser = "CREATE TABLE User("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "email TEXT NOT NULL,"+
                "username TEXT NOT NULL,"+
                "password TEXT NOT NULL);";
        sqLiteDatabase.execSQL(sqlUser);
        String sql="CREATE TABLE LOAI_TC(MaLoai integer primary key autoincrement,"+"TenLoai text,TrangThai text)";
        sqLiteDatabase.execSQL(sql);

        sql = "INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Lại ngân hàng','Thu')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Lương','Thu')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Bán hàng','Thu')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Thu nợ','Thu')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Sinh hoạt hằng ngày','Chi')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Đóng tiền học','Chi')";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Du lịch','Chi')";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE KHOAN_TC(MaGD integer primary key autoincrement,"+"TieuDe text,Ngay date,Tien float,MoTa text,"+"MaLoai interger references LOAI_TC(MaLoai))";
        sqLiteDatabase.execSQL(sql);

        sql = "INSERT INTO KHOAN_TC(TieuDe,Ngay,Tien,MoTa,MaLoai) VALUES('Lương tháng 1/2020','12/09/2020','1000','Lương',2)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO KHOAN_TC(TieuDe,Ngay,Tien,MoTa,MaLoai) VALUES('Bán','11/09/2020','5000','Áo',3)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO KHOAN_TC(TieuDe,Ngay,Tien,MoTa,MaLoai) VALUES('Tiền lãi 2019','21/11/2020','9000','Lãi',1)";
        sqLiteDatabase.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LOAI_TC");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS KHOAN_THU");
        String sqlDropUser = "DROP TABLE User;";
        sqLiteDatabase.execSQL(sqlDropUser);
        onCreate(sqLiteDatabase);
    }
}
