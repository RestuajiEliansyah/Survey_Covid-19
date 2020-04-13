package com.example.surveycovid_19.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.surveycovid_19.Question;

import java.util.ArrayList;

import static com.example.surveycovid_19.DataBase.SurveyDatabaseContract.SurveyColumns.AGE;
import static com.example.surveycovid_19.DataBase.SurveyDatabaseContract.SurveyColumns.ID;
import static com.example.surveycovid_19.DataBase.SurveyDatabaseContract.SurveyColumns.NAME;
import static com.example.surveycovid_19.DataBase.SurveyDatabaseContract.SurveyColumns.RESULT;
import static com.example.surveycovid_19.DataBase.SurveyDatabaseContract.SurveyColumns.SURVEY_TABLE_NAME;

public class SurveyHelper {
    private static final String DATABASE_TABLE = SURVEY_TABLE_NAME;
    private static SurveyDatabaseHelper surveyDatabaseHelper;
    private static SurveyHelper INSTANCE;

    private static SQLiteDatabase database;

    private SurveyHelper(Context context) {
        surveyDatabaseHelper = new SurveyDatabaseHelper(context);
    }

    public static SurveyHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SurveyHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = surveyDatabaseHelper.getWritableDatabase();
    }

    public void close() {
        surveyDatabaseHelper.close();

        if (database.isOpen())
            database.close();
    }

    public ArrayList<Question> getAllSurvey() {
        ArrayList<Question> arrayList = new ArrayList<>();
        Cursor cursor = database.query(DATABASE_TABLE, null,
                null,
                null,
                null,
                null,
                ID + " ASC",
                null);
        cursor.moveToFirst();
        Question survey;
        if (cursor.getCount() > 0) {
            do {
                survey = new Question();
                survey.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ID)));
                survey.setName(cursor.getString(cursor.getColumnIndexOrThrow(NAME)));
                survey.setAge(cursor.getString(cursor.getColumnIndexOrThrow(AGE)));
                survey.setResult(cursor.getString(cursor.getColumnIndexOrThrow(RESULT)));
                arrayList.add(survey);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insertSurvey(Question survey) {
        ContentValues args = new ContentValues();
        args.put(ID, survey.getId());
        args.put(NAME, survey.getName());
        args.put(AGE, survey.getAge());
        args.put(RESULT, survey.getResult());

        return database.insert(DATABASE_TABLE, null, args);
    }

    public int deleteSurvey(int id) {
        return database.delete(SURVEY_TABLE_NAME, ID + " = '" + id + "'", null);
    }
}

