package com.example.surveycovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.surveycovid_19.DataBase.DatabaseHandler;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    TextView history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        history = findViewById(R.id.txt_history);
        setTitle("History");
        DatabaseHandler surveyHelper = new DatabaseHandler(this);
        Log.d("reading", "reading all data");
        List<Question> listQuestion=surveyHelper.findAll();
        String Text = "";
        for(Question b:listQuestion){
            Text += "Nama : " + b.getName() + "\nUmur  : " + b.getAge()+"\nHasil   : "+ b.getResult()+"\n\n\n";
            Log.d("data", "ID :"+b.getId()+" | NAME :"+b.getName()+" | AGE:"+b.getAge()+" | RESULT:"+b.getResult());
            history.setText(Text);
        }
    }
}
