package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText txtName, txtLastName;
    private TextView txtDate;
    private RadioGroup rdgLikes;
    private Spinner spnGender;
    private CheckBox chkJava, chkPython, chkJavaScript, chkGo, chkC, chkCSharp;
    private Button btnClean, btnSend;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private LinearLayout lyProgramming;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.name_txt);
        txtLastName = findViewById(R.id.last_name_txt);

        lyProgramming = findViewById(R.id.languages_layout);

        rdgLikes = findViewById(R.id.like_radio_group);
        rdgLikes.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) (group, checkedId) -> {
            if (checkedId == R.id.no_radio_button)
                lyProgramming.setVisibility(View.INVISIBLE);
            else
                lyProgramming.setVisibility(View.VISIBLE);
        });

        spnGender = findViewById(R.id.gender_spinner);

        chkJava = findViewById(R.id.java_checkbox);
        chkJavaScript = findViewById(R.id.js_checkbox);
        chkPython = findViewById(R.id.python_checkbox);
        chkGo = findViewById(R.id.go_checkbox);
        chkC = findViewById(R.id.c_checkbox);
        chkCSharp = findViewById(R.id.c_sharp_checkbox);

        btnClean = findViewById(R.id.clean_btn);
        btnClean.setOnClickListener(view -> clearForm());

        txtDate = findViewById(R.id.date_txt);
        txtDate.setOnClickListener(view -> {
            calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);

            if (!txtDate.getText().toString().equalsIgnoreCase(getResources().getString(R.string.select_date))) {
                String[] splitArr = txtDate.getText().toString().split("/");
                day = Integer.parseInt(splitArr[0]);
                month = Integer.parseInt(splitArr[1]) - 1;
                year = Integer.parseInt(splitArr[2]);
            }

            datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    txtDate.setText(day + "/" + (month + 1) + "/" + year);
                }
            }, year, month, day);
            datePickerDialog.show();
        });
    }

    private void clearForm () {
        txtName.setText("");
        txtLastName.setText("");
        txtDate.setText(getResources().getString(R.string.select_date));

        rdgLikes.check(R.id.yes_radio_button);

        spnGender.setSelection(0);

        chkJava.setChecked(false);
        chkPython.setChecked(false);
        chkJavaScript.setChecked(false);
        chkGo.setChecked(false);
        chkC.setChecked(false);
        chkCSharp.setChecked(false);
    }
}