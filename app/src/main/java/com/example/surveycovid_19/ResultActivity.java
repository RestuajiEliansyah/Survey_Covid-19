package com.example.surveycovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_AGE = "extra_age";
    public static final String EXTRA_RESULT = "extra_result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView tvResult = findViewById(R.id.txt_result);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String age = getIntent().getStringExtra(EXTRA_AGE);
        String result = getIntent().getStringExtra(EXTRA_RESULT);
        String Text = name+", Umur Anda "+age+" tahun dan Resiko Terkena Covid-19 adalah " + result;
        tvResult.setText(Text);
    }
}
