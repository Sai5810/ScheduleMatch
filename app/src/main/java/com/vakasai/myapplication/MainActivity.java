package com.vakasai.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add_item(View view) {
        Intent intent = new Intent(this, ItemAct.class);
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            int[] stTime = data.getIntArrayExtra("stTime");
            int[] endTime = data.getIntArrayExtra("endTime");
            int repetitions = Integer.parseInt(data.getStringExtra("repetitions"));
            String type = data.getStringExtra("type");
            String date = data.getStringExtra("date");

        }
    }

    public void finished(View v) {
        Intent intent = new Intent(this, MatchAct.class);
        startActivity(intent);
    }
}