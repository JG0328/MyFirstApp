package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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
    private TextView txtDate, txtLanguages;
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
        rdgLikes.setOnCheckedChangeListener((group, checkedId) -> {
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

        txtLanguages = findViewById(R.id.languages_txt);

        txtDate = findViewById(R.id.date_txt);
        txtDate.setText(getTodayDate());
        txtDate.setOnClickListener(view -> {
            String[] splitArr = txtDate.getText().toString().split("/");
            int dd = Integer.parseInt(splitArr[0]);
            int mm = Integer.parseInt(splitArr[1]) - 1;
            int yyyy = Integer.parseInt(splitArr[2]);

            datePickerDialog = new DatePickerDialog(MainActivity.this, (datePicker, year, month, day) -> txtDate.setText(day + "/" + (month + 1) + "/" + year), yyyy, mm, dd);
            datePickerDialog.show();
        });

        btnSend = findViewById(R.id.send_btn);
        btnSend.setOnClickListener(view -> {
            boolean error = false;

            if (txtName.getText().toString().trim().isEmpty()) {
                txtName.setError("Obligatorio");
                error = true;
            }

            if (txtLastName.getText().toString().trim().isEmpty()) {
                txtLastName.setError("Obligatorio");
                error = true;
            }

            if (rdgLikes.getCheckedRadioButtonId() == R.id.yes_radio_button) {
                if (!chkJava.isChecked() &&
                        !chkPython.isChecked() &&
                        !chkJavaScript.isChecked() &&
                        !chkGo.isChecked() &&
                        !chkC.isChecked() &&
                        !chkGo.isChecked()
                ) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                    alertDialog.setTitle("Obligatorio");
                    alertDialog.setMessage("Elija al menos un lenguaje");
                    alertDialog.setCancelable(true);
                    alertDialog.create().show();

                    error = true;
                }
            }

            // If everything goes well...
            if(!error){

            }
        });
    }

    private void clearForm() {
        txtName.setText("");
        txtName.setError(null);

        txtLastName.setText("");
        txtLastName.setError(null);

        txtDate.setText(getTodayDate());

        rdgLikes.check(R.id.yes_radio_button);

        spnGender.setSelection(0);

        chkJava.setChecked(false);
        chkPython.setChecked(false);
        chkJavaScript.setChecked(false);
        chkGo.setChecked(false);
        chkC.setChecked(false);
        chkCSharp.setChecked(false);
    }

    private String getTodayDate() {
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        return day + "/" + (month + 1) + "/" + year;
    }
}