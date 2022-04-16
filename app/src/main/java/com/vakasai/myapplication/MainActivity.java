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
                String strEditText = data.getStringExtra("editTextValue");
        }
    }

    public void finished(View v) {
        Intent intent = new Intent(this, MatchAct.class);
        startActivity(intent);
    }
}