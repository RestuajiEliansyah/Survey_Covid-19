package com.example.surveycovid_19.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.surveycovid_19.Question;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "SurveyManager";

    private static final String TABLE_SURVEY = "t_survey";

    private static final String KEY_ID = "id";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_UMUR = "umur";
    private static final String KEY_HASIL = "hasil";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SURVEY_TABLE = "CREATE TABLE " + TABLE_SURVEY + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAMA + " TEXT,"
                + KEY_UMUR + " TEXT,"
                + KEY_HASIL + " TEXT" + ")";
        db.execSQL(CREATE_SURVEY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SURVEY);

        onCreate(db);
    }

    public void save(Question survey){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAMA, survey.getName());
        values.put(KEY_UMUR, survey.getAge());
        values.put(KEY_HASIL, survey.getResult());
        db.insert(TABLE_SURVEY, null, values);
        db.close();
    }

    public Question findOne(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_SURVEY, new String[]{KEY_ID,KEY_NAMA,KEY_UMUR},
                KEY_ID+"=?", new String[]{String.valueOf(id)}, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }


        return new Question(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3));
    }

    public List<Question> findAll(){
        List<Question> listSurvey=new ArrayList<Question>();
        String query="SELECT * FROM "+TABLE_SURVEY;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Question survey=new Question();
                survey.setId(Integer.valueOf(cursor.getString(0)));
                survey.setName(cursor.getString(1));
                survey.setAge(cursor.getString(2));
                survey.setResult(cursor.getString(3));
                listSurvey.add(survey);
            }while(cursor.moveToNext());
        }

        return listSurvey;
    }

    public void update(Question survey){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_NAMA, survey.getName());
        values.put(KEY_UMUR, survey.getAge());
        values.put(KEY_HASIL, survey.getResult());

        db.update(TABLE_SURVEY, values, KEY_ID+"=?", new String[]{String.valueOf(survey.getId())});
        db.close();
    }

    public void delete(Question survey){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_SURVEY, KEY_ID+"=?", new String[]{String.valueOf(survey.getId())});
        db.close();
    }
}
