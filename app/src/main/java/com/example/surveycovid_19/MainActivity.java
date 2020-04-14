package com.example.surveycovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_NAME_SURVEY = "extra_name_survey";
    public static final String EXTRA_AGE_SURVEY = "extra_age_survey";
    TextView Soal;
    Button Yes;
    Button No;
    QuestionData Question;
    String result,name_survey,age_survey;
    int Hasil,Number;
    boolean Pressed;
    private ArrayList<Question> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hasil = 0;
        Number = 0;
        name_survey = getIntent().getStringExtra(EXTRA_NAME_SURVEY);
        age_survey = getIntent().getStringExtra(EXTRA_AGE_SURVEY);
        Soal = findViewById(R.id.txt_soal);
        Yes = findViewById(R.id.btn_yes);
        No = findViewById(R.id.btn_no);
        Question = new QuestionData();
        setSoal();
        Yes.setOnClickListener(this);
        No.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(Number <21) {
            switch (v.getId()) {
                case R.id.btn_yes:
                    Hasil += 1;
                    Question.Answers[Number] = true;
                case R.id.btn_no:
                    Question.Answers[Number] = false;
            }
            setSoal();
        }
        else {
            if(Hasil <8 ){
                result = "Rendah";
            }else if( Hasil <15){
                result = "Sedang";
            }else {
                result = "Tinggi";
            }
            Intent resultIntent = new Intent(this,ResultActivity.class);
            resultIntent.putExtra(ResultActivity.EXTRA_NAME,name_survey);
            resultIntent.putExtra(ResultActivity.EXTRA_AGE,age_survey);
            resultIntent.putExtra(ResultActivity.EXTRA_RESULT, result);
            startActivity(resultIntent);
            finish();
        }
    }
    void setSoal(){
        Soal.setText((Number + 1) + "." + Question.Questions[Number]);
        Number++;
    }
}