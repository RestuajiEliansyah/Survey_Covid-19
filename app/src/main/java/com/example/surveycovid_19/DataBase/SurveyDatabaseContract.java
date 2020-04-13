package com.example.surveycovid_19.DataBase;

import android.provider.BaseColumns;

public class SurveyDatabaseContract {
    static final class SurveyColumns implements BaseColumns
    {
        static final String SURVEY_TABLE_NAME = "survey";
        static final String ID = "id";
        static final String NAME = "name";
        static final String AGE = "age";
        static final String RESULT = "result";
    }
}
