package com.example.surveycovid_19.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.surveycovid_19.DataBase.SurveyDatabaseContract.SurveyColumns.SURVEY_TABLE_NAME;

public class SurveyDatabaseHelper extends SQLiteOpenHelper {
    private static final String SURVEY_DATABASE_NAME = "dbsurvey";

    private static final int SURVEY_DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_SURVEY = String.format("CREATE TABLE %s" +
                    " (%s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL," +
                    " %s TEXT NULL)",
            SURVEY_TABLE_NAME,
            SurveyDatabaseContract.SurveyColumns.ID,
            SurveyDatabaseContract.SurveyColumns.NAME,
            SurveyDatabaseContract.SurveyColumns.AGE,
            SurveyDatabaseContract.SurveyColumns.RESULT
    );

    SurveyDatabaseHelper(Context context) {
        super(context, SURVEY_DATABASE_NAME, null, SURVEY_DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_SURVEY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SURVEY_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}
