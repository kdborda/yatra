package com.example.yatra_receipt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Yatri_Details extends AppCompatActivity {

    String[] Gender = {"જાતિ","પુરુષ", "સ્ત્રી"};
    Spinner spinner;
    EditText yatri_name,age,from_station,to_station,description,p_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yatri_details);

        assign();


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Gender);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        retrivedata();

    }

    private void assign() {

        spinner = findViewById(R.id.spinner);
        yatri_name = findViewById(R.id.yatri_name);
        age = findViewById(R.id.age);
        from_station = findViewById(R.id.from_station);
        to_station = findViewById(R.id.to_station);
        description = findViewById(R.id.description);
        p_number = findViewById(R.id.p_number);
    }

    private void retrivedata() {
        String tyatri_name = yatri_name.getText().toString();
        int tage = Integer.parseInt(age.getText().toString());
        String tfrom_station = from_station.getText().toString();
        String tto_station = to_station.getText().toString();
        String tdescription = description.getText().toString();
        int tp_number = Integer.parseInt(p_number.getText().toString());
    }


}