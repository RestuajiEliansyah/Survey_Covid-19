package com.example.surveycovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {
    Button next;
    EditText name;
    EditText age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        next = findViewById(R.id.btn_lanjut);
        name = findViewById(R.id.edt_nama);
        age = findViewById(R.id.edt_umur);
        next.setOnClickListener(this);
        setTitle("Biodata");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lanjut:
                String inputName = name.getText().toString().trim();
                String inputAge = age.getText().toString().trim();
                if(TextUtils.isEmpty(inputName)){
                    name.setError("Field ini tidak boleh kosong");
                }
                else if(TextUtils.isEmpty(inputAge)){
                    age.setError("Field ini Tidak boleh kosong");
                }
                else{
                    Intent intent = new Intent(this,MainActivity.class);
                    intent.putExtra(MainActivity.EXTRA_NAME_SURVEY,inputName);
                    intent.putExtra(MainActivity.EXTRA_AGE_SURVEY,inputAge);
                    startActivity(intent);
                    finish();
                }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                Intent intent = new Intent(this,HistoryActivity.class);
                startActivity(intent);
                break;
        }
    }
}
