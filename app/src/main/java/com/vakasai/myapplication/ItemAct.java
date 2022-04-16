package com.vakasai.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ItemAct extends AppCompatActivity {
    final Calendar myCalendar = Calendar.getInstance();
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        Spinner spin = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapt = ArrayAdapter
                .createFromResource(this, R.array.type_arr,
                        android.R.layout.simple_spinner_item);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapt);
        editText = findViewById(R.id.date);
        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, day);
            updateLabel();
        };
        editText.setOnClickListener(view -> new DatePickerDialog(ItemAct.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show());
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(dateFormat.format(myCalendar.getTime()));
    }

    public void formFilled(View v) {
        Intent intent = new Intent();
        Spinner spin = findViewById(R.id.spinner);
        EditText date = findViewById(R.id.date);
        TimePicker stTime = findViewById(R.id.timePicker);
        TimePicker endTime = findViewById(R.id.timePicker2);
        EditText repetitions = findViewById(R.id.repetitions);
        intent.putExtra("type", spin.getSelectedItem().toString());
        intent.putExtra("date", date.getText().toString());
        intent.putExtra("stTime", new int[]{stTime.getHour(), stTime.getMinute()});
        intent.putExtra("endTime", new int[]{endTime.getHour(), endTime.getMinute()});
        intent.putExtra("repetitions", repetitions.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
