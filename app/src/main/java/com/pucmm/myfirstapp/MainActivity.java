package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private EditText txtName, txtLastName;
    private RadioGroup rdgLikes;
    private Spinner spnGender;
    private CheckBox chkJava, chkPython, chkJavaScript, chkGo, chkC, chkCSharp;
    private Button btnClean, btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.name_txt);
        txtLastName = findViewById(R.id.last_name_txt);
    }
}