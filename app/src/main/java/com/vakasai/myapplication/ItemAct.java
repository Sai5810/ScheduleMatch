package com.vakasai.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class ItemAct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        Spinner spin = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> adapt = ArrayAdapter
                .createFromResource(this, R.array.type_arr,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spin.setAdapter(adapt);
    }
}
