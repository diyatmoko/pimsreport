package com.firstresources.pimsfa.helper;

/**
 * @author Yanuar Diyatmoko
 * @version 1.0.0
 * @date 10/05/2019
 */
public class Constants {

    public static final class HTTP {
        public static final String BASE_URL = "http://10.112.61.136:86/api/";
    }

    public static final class PARAMETERS{
        public static final String COMPANY = "A03";
        public static final String LOCATION = "21";
        public static final String AFDELING = "01";

    }

    public static final class PREFERENCES{

    }

    public static final class DATABASE{
        public static final int DATABASE_VERSION = 1;
        //    DBName
        public static final String DATABASE_NAME = "REPORTPIMS";

        //    Global Declaration
        public static final String CreatedBy = "CreatedBy";
        public static final String CreatedDate = "CreatedDate";

        //    Table FA Harian
        public static final String Rpt_FA_Harian = "Rpt_FA_Harian";
        public static final String Year = "Year";
        public static final String Month = "Month";
        public static final String ReportType = "ReportType";
        public static final String SubReportType = "SubReportType";
        public static final String CompanyCode = "CompanyCode";
        public static final String CompanyName = "CompanyName";
        public static final String LocationCode = "LocationCode";
        public static final String LocationDesc = "LocationDesc";
        public static final String AfdelingCode = "AfdelingCode";
        public static final String AfdelingDesc = "AfdelingDesc";
        public static final String Idx = "Idx";
        public static final String IsParent = "IsParent";
        public static final String Nama = "Nama";
        public static final String UOM = "UOM";
        public static final String Budget = "Budget";
        public static final String HI = "HI";
        public static final String Jumlah = "Jumlah";
        public static final String Percentage = "Percentage";
        public static final String _1 = "_1";
        public static final String _2 = "_2";
        public static final String _3 = "_3";
        public static final String _4 = "_4";
        public static final String _5 = "_5";
        public static final String _6 = "_6";
        public static final String _7 = "_7";
        public static final String _8 = "_8";
        public static final String _9 = "_9";
        public static final String _10 = "_10";
        public static final String _11 = "_11";
        public static final String _12 = "_12";
        public static final String _13 = "_13";
        public static final String _14 = "_14";
        public static final String _15 = "_15";
        public static final String _16 = "_16";
        public static final String _17 = "_17";
        public static final String _18 = "_18";
        public static final String _19 = "_19";
        public static final String _20 = "_20";
        public static final String _21 = "_21";
        public static final String _22 = "_22";
        public static final String _23 = "_23";
        public static final String _24 = "_24";
        public static final String _25 = "_25";
        public static final String _26 = "_26";
        public static final String _27 = "_27";
        public static final String _28 = "_28";
        public static final String _29 = "_29";
        public static final String _30 = "_30";
        public static final String _31 = "_31";


        //    Create Table
        public static final String CREATE_TABLE_RPT_FA_HARIAN = "CREATE TABLE IF NOT EXISTS " + Rpt_FA_Harian + " ( "
                + Year + " TEXT, " + Month + " TEXT, " + ReportType + " INTEGER, " + SubReportType + " INTEGER, "
                + CompanyCode + " TEXT, " + CompanyName + " TEXT, " + LocationCode + " TEXT, " + LocationDesc + " TEXT, "
                + AfdelingCode + " TEXT, " + AfdelingDesc + " TEXT, " + Idx + " INTEGER, " + IsParent + " BOOLEAN, "
                + Nama + " TEXT, " + UOM + " TEXT, " + Budget + " DECIMAL (18,2), " + HI + " DECIMAL (18,2), "
                + Jumlah + " DECIMAL (18,2), " + Percentage + " DECIMAL (18,2), "
                + _1 + " DECIMAL (18,2), " + _2 + " DECIMAL (18,2), " + _3 + " DECIMAL (18,2), " + _4 + " DECIMAL (18,2), "
                + _5 + " DECIMAL (18,2), " + _6 + " DECIMAL (18,2), " + _7 + " DECIMAL (18,2), " + _8 + " DECIMAL (18,2), "
                + _9 + " DECIMAL (18,2), " + _10 + " DECIMAL (18,2), " + _11 + " DECIMAL (18,2), " + _12 + " DECIMAL (18,2), "
                + _13 + " DECIMAL (18,2), " + _14 + " DECIMAL (18,2), " + _15 + " DECIMAL (18,2), " + _16 + " DECIMAL (18,2), "
                + _17 + " DECIMAL (18,2), " + _18 + " DECIMAL (18,2), " + _19 + " DECIMAL (18,2), " + _20 + " DECIMAL (18,2), "
                + _21 + " DECIMAL (18,2), " + _22 + " DECIMAL (18,2), " + _23 + " DECIMAL (18,2), " + _24 + " DECIMAL (18,2), "
                + _25 + " DECIMAL (18,2), " + _26 + " DECIMAL (18,2), " + _27 + " DECIMAL (18,2), " + _28 + " DECIMAL (18,2), "
                + _29 + " DECIMAL (18,2), " + _30 + " DECIMAL (18,2), " + _31 + " DECIMAL (18,2), "
                + CreatedBy + " TEXT, " + CreatedDate + " DATETIME)";
    }



}
