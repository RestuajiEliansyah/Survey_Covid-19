package com.example.surveycovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.surveycovid_19.DataBase.DatabaseHandler;

import java.util.List;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_RESULT = "extra_result";
    private Question survey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        DatabaseHandler surveyHelper = new DatabaseHandler(this);
        TextView tvResult = findViewById(R.id.txt_result);
        Button history = findViewById(R.id.btn_back);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String age = getIntent().getStringExtra(EXTRA_AGE);
        String result = getIntent().getStringExtra(EXTRA_RESULT);
        String Text = name+", Umur Anda "+age+" tahun dan Resiko Terkena Covid-19 adalah " + result;
        tvResult.setText(Text);
        surveyHelper.save(new Question(name,age,result));
        history.setOnClickListener(this);
        setTitle("Result");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                Intent intent = new Intent(this,UserActivity.class);
                startActivity(intent);
                finish();
        }
    }
}
