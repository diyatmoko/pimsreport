package com.firstresources.pimsreport.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.firstresources.pimsreport.model.ReportFAHarian;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yanuar Diyatmoko
 * @version 1.0.0
 * @date 13/05/2019
 */
public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase dbase;

    public DBHelper(Context context) {
        super(context, Constants.DATABASE.DATABASE_NAME, null, Constants.DATABASE.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        db.execSQL(Constants.DATABASE.CREATE_TABLE_RPT_FA_HARIAN);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE " + Constants.DATABASE.Rpt_FA_Harian);

        onCreate(db);
    }
    public void deleteAllTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Constants.DATABASE.Rpt_FA_Harian,null,null);
    }
    public void addReportFAHarian(ReportFAHarian reportFAHarian){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.DATABASE.Year, reportFAHarian.getYear());
        values.put(Constants.DATABASE.Month, reportFAHarian.getMonth());
        values.put(Constants.DATABASE.ReportType, reportFAHarian.getReportType());
        values.put(Constants.DATABASE.SubReportType, reportFAHarian.getSubReportType());
        values.put(Constants.DATABASE.CompanyCode, reportFAHarian.getCompanyCode());
        values.put(Constants.DATABASE.CompanyName, reportFAHarian.getCompanyName());
        values.put(Constants.DATABASE.LocationCode, reportFAHarian.getLocationCode());
        values.put(Constants.DATABASE.LocationDesc, reportFAHarian.getLocationDesc());
        values.put(Constants.DATABASE.AfdelingCode, reportFAHarian.getAfdelingCode());
        values.put(Constants.DATABASE.AfdelingDesc, reportFAHarian.getAfdelingDesc());
        values.put(Constants.DATABASE.Idx, reportFAHarian.getIdx());
        values.put(Constants.DATABASE.IsParent, reportFAHarian.getIsParent());
        values.put(Constants.DATABASE.Nama, reportFAHarian.getNama());
        values.put(Constants.DATABASE.UOM, reportFAHarian.getUOM());
        values.put(Constants.DATABASE.Budget, reportFAHarian.getBudget().toString());
        values.put(Constants.DATABASE.HI, reportFAHarian.getHI().toString());
        values.put(Constants.DATABASE.Jumlah, reportFAHarian.getJumlah().toString());
        values.put(Constants.DATABASE.Percentage, reportFAHarian.getPercentage().toString());
        values.put(Constants.DATABASE._1, reportFAHarian.get1().toString());
        values.put(Constants.DATABASE._2, reportFAHarian.get2().toString());
        values.put(Constants.DATABASE._3, reportFAHarian.get3().toString());
        values.put(Constants.DATABASE._4, reportFAHarian.get4().toString());
        values.put(Constants.DATABASE._5, reportFAHarian.get5().toString());
        values.put(Constants.DATABASE._6, reportFAHarian.get6().toString());
        values.put(Constants.DATABASE._7, reportFAHarian.get7().toString());
        values.put(Constants.DATABASE._8, reportFAHarian.get8().toString());
        values.put(Constants.DATABASE._9, reportFAHarian.get9().toString());
        values.put(Constants.DATABASE._10, reportFAHarian.get10().toString());
        values.put(Constants.DATABASE._11, reportFAHarian.get11().toString());
        values.put(Constants.DATABASE._12, reportFAHarian.get12().toString());
        values.put(Constants.DATABASE._13, reportFAHarian.get13().toString());
        values.put(Constants.DATABASE._14, reportFAHarian.get14().toString());
        values.put(Constants.DATABASE._15, reportFAHarian.get15().toString());
        values.put(Constants.DATABASE._16, reportFAHarian.get16().toString());
        values.put(Constants.DATABASE._17, reportFAHarian.get17().toString());
        values.put(Constants.DATABASE._18, reportFAHarian.get18().toString());
        values.put(Constants.DATABASE._19, reportFAHarian.get19().toString());
        values.put(Constants.DATABASE._20, reportFAHarian.get20().toString());
        values.put(Constants.DATABASE._21, reportFAHarian.get21().toString());
        values.put(Constants.DATABASE._22, reportFAHarian.get22().toString());
        values.put(Constants.DATABASE._23, reportFAHarian.get23().toString());
        values.put(Constants.DATABASE._24, reportFAHarian.get24().toString());
        values.put(Constants.DATABASE._25, reportFAHarian.get25().toString());
        values.put(Constants.DATABASE._26, reportFAHarian.get26().toString());
        values.put(Constants.DATABASE._27, reportFAHarian.get27().toString());
        values.put(Constants.DATABASE._28, reportFAHarian.get28().toString());
        values.put(Constants.DATABASE._29, reportFAHarian.get29().toString());
        values.put(Constants.DATABASE._30, reportFAHarian.get30().toString());
        values.put(Constants.DATABASE._31, reportFAHarian.get31().toString());

        db.insert(Constants.DATABASE.Rpt_FA_Harian, null, values);
        db.close();

    }

    public List<ReportFAHarian> getAllCompany(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<ReportFAHarian> reportFAHarianList = new ArrayList<ReportFAHarian>();

//        String whereClause = "NIK = ?";
//        String [] whereArgs = new String[]{"20140702100019"};

        String[] column  = {Constants.DATABASE.CompanyCode, Constants.DATABASE.CompanyName};
        Cursor cursor = db.query(true, Constants.DATABASE.Rpt_FA_Harian, column, null, null, null, null, null, null);

        try {
            while (cursor.moveToNext()) {
                ReportFAHarian reportFAHarian = new ReportFAHarian();
                reportFAHarian.setCompanyCode(cursor.getString(cursor.getColumnIndex(Constants.DATABASE.CompanyCode)));
                reportFAHarian.setCompanyName(cursor.getString(cursor.getColumnIndex(Constants.DATABASE.CompanyName)));

                reportFAHarianList.add(reportFAHarian);
            }
        } finally {
            cursor.close();
        }

        db.close();

        return reportFAHarianList;
    }

    public List<ReportFAHarian> getAllLocation(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<ReportFAHarian> reportFAHarianList = new ArrayList<ReportFAHarian>();

//        String whereClause = "NIK = ?";
//        String [] whereArgs = new String[]{"20140702100019"};

        String[] column  = {Constants.DATABASE.LocationCode, Constants.DATABASE.LocationDesc};
        Cursor cursor = db.query(true, Constants.DATABASE.Rpt_FA_Harian, column, null, null, null, null, null, null);

        try {
            while (cursor.moveToNext()) {
                ReportFAHarian reportFAHarian = new ReportFAHarian();
                reportFAHarian.setLocationCode(cursor.getString(cursor.getColumnIndex(Constants.DATABASE.LocationCode)));
                reportFAHarian.setLocationDesc(cursor.getString(cursor.getColumnIndex(Constants.DATABASE.LocationDesc)));

                reportFAHarianList.add(reportFAHarian);
            }
        } finally {
            cursor.close();
        }

        db.close();

        return reportFAHarianList;
    }

    public List<ReportFAHarian> getAllAfdeling(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<ReportFAHarian> reportFAHarianList = new ArrayList<ReportFAHarian>();

//        String whereClause = "NIK = ?";
//        String [] whereArgs = new String[]{"20140702100019"};

        String[] column  = {Constants.DATABASE.AfdelingCode, Constants.DATABASE.AfdelingDesc};
        Cursor cursor = db.query(true, Constants.DATABASE.Rpt_FA_Harian, column, null, null, null, null, null, null);

        try {
            while (cursor.moveToNext()) {
                ReportFAHarian reportFAHarian = new ReportFAHarian();
                reportFAHarian.setAfdelingCode(cursor.getString(cursor.getColumnIndex(Constants.DATABASE.AfdelingCode)));
                reportFAHarian.setAfdelingDesc(cursor.getString(cursor.getColumnIndex(Constants.DATABASE.AfdelingDesc)));

                reportFAHarianList.add(reportFAHarian);
            }
        } finally {
            cursor.close();
        }

        db.close();

        return reportFAHarianList;
    }

}