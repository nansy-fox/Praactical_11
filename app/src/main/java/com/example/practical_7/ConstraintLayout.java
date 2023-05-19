package com.example.practical_7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ConstraintLayout extends AppCompatActivity {
    Button registration;
    EditText userName, userSurname, phoneNomber;
    CheckBox check;
    boolean AllFieldsChecked = false;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
        userName =(EditText) findViewById(R.id.editTextTextPersonName);
        userSurname = (EditText)findViewById(R.id.editTextTextPersonName2);
        phoneNomber = (EditText)findViewById(R.id.editTextTextPersonName3);
        registration = findViewById(R.id.Btnreg);
        check = findViewById(R.id.checkBox);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllFieldsChecked = CheckAllFields();
                if (AllFieldsChecked) {
                    Intent intent = new Intent(ConstraintLayout.this, Layout.class);
                    startActivity(intent);
                }
            }
        });
    }
    private boolean CheckAllFields() {
        if (userName.length() == 0 && !check.isChecked()) {
            userName.setError("Поле обязательно для заполнения");
            return false;
        }
        if (userSurname.length() == 0 && !check.isChecked()) {
            userSurname.setError("Поле обязательно для заполнения");
            return false;
        }
        if (phoneNomber.length() == 0 && !check.isChecked()) {
            phoneNomber.setError("Поле обязательно для заполнения");
            return false;
        } else if (phoneNomber.length() < 10) {
            phoneNomber.setError("Некорректный номер телефона");
            return false;
        }
        return true;
    }
}