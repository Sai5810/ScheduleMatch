package com.vakasai.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> launchItem;
    int bottom = R.id.addBtn;

    public void addToBottomView(TextView tv, ConstraintLayout lay, String s) {
        tv.setText(s);
        tv.setTextSize(20);
        tv.setId(View.generateViewId());
        ConstraintSet set = new ConstraintSet();
        lay.addView(tv, 0);
        set.clone(lay);
        set.connect(tv.getId(), ConstraintSet.TOP, bottom, ConstraintSet.BOTTOM, 10);
        set.connect(tv.getId(), ConstraintSet.LEFT, lay.getId(), ConstraintSet.LEFT, 0);
        set.connect(tv.getId(), ConstraintSet.RIGHT, lay.getId(), ConstraintSet.RIGHT, 0);
        set.applyTo(lay);
        bottom = tv.getId();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchItem = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        ConstraintLayout lay = findViewById(R.id.main);
                        String username = ((EditText) findViewById(R.id.username)).getText().toString();
                        addToBottomView(new TextView(MainActivity.this), lay, data.getStringExtra("type"));
                        int[] st = data.getIntArrayExtra("stTime");
                        int[] end = data.getIntArrayExtra("endTime");
                        addToBottomView(new TextView(MainActivity.this), lay,
                                st[0] + ":" + st[1] + " - " + end[0] + ":" + end[1]);
                        addToBottomView(new TextView(MainActivity.this), lay,
                                data.getStringExtra("date"));
                        if (data.hasExtra("repetitions")) {
                            addToBottomView(new TextView(MainActivity.this), lay,
                                    "Repeats every " + data.getIntExtra("repetitions", 0) + " days");

                        }
                    }
                });
    }

    public void add_item(View view) {
        Intent intent = new Intent(this, ItemAct.class);
        launchItem.launch(intent);
    }

    public void finished(View v) {
        Intent intent = new Intent(this, MatchAct.class);
        startActivity(intent);
    }
}