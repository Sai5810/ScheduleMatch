package com.vakasai.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class ItemAct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapt = ArrayAdapter
                .createFromResource(this, R.array.type_arr,
                        android.R.layout.simple_spinner_item);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapt);
    }
    public void formFilled(View v) {
        Intent intent = new Intent();
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        EditText date = (EditText) findViewById(R.id.date);
        EditText time = (EditText) findViewById(R.id.time);
        EditText repetitions = (EditText) findViewById(R.id.repetitions);
        intent.putExtra("type", spin.getSelectedItem().toString());
        intent.putExtra("date", date.getText().toString());
        intent.putExtra("time", time.getText().toString());
        intent.putExtra("repetitions", repetitions.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
