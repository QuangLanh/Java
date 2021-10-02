package com.exemple.asignment_final.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.exemple.asignment_final.DataBase.DpHelper;

public class ThongKeDao {
    public static double tongTienTheoTT(Context context, String trangthai){
        double tongTien = 0;
        DpHelper helper = new DpHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String str = "select SUM(Tien) as TongTien "
                +"from KHOAN_TC join LOAI_TC "
                +"on KHOAN_TC.MaLoai = LOAI_TC.MaLoai "
                +"where TrangThai = '"+ trangthai +"'";

        Cursor cs = db.rawQuery(str,null);
        cs.moveToFirst();
        if (cs.getCount() >= 0){
            tongTien = cs.getDouble(0);
        }
        return tongTien;
    }
}
