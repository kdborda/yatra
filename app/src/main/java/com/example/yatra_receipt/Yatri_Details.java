package com.example.yatra_receipt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;

public class Yatri_Details extends AppCompatActivity {

    String[] Gender = {"જાતિ","પુરુષ", "સ્ત્રી"};
    Spinner spinner;
    EditText yatri_name,age,from_station,to_station,description,p_number;
    Button generateRecieptBtn;
    TextView gender;

    Boolean isEdit;

    Realm realm;

    long receiptNo = 0;


    // Firebase initializations.
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("data");
    DatabaseReference databaseReference;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yatri_details);

        assign();


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,Gender);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("જાતિ")){

                } else {
                    gender.setText(adapterView.getSelectedItem().toString());
                }
            }
        });

        retrivedata();
        generateReciept();
//        dataretrive();


    }

    private void generateReciept() {

        generateRecieptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tyatri_name = yatri_name.getText().toString();
                String tage = age.getText().toString();
                String tgender = gender.getText().toString();
                String tfrom_station = from_station.getText().toString();
                String tto_station = to_station.getText().toString();
                String tdescription = description.getText().toString();

                if (generateRecieptBtn.getText().toString().equals("Generate Invoice")){
                    Realm.init(getApplicationContext());
                    realm = Realm.getDefaultInstance();

                    if (yatri_name.getText().toString().length() == 0 ||
                            age.getText().toString().length() ==0 ||
                            gender.getText().toString().equals("જાતિ") ||
                            from_station.getText().toString().length() == 0 ||
                            to_station.getText().toString().length() == 0 ||
                            description.getText().toString().length() == 0 ||
                            p_number.getText().toString().length() == 0 ){

                        Toast.makeText(getApplicationContext(), "Some Fields Are Empty !!", Toast.LENGTH_SHORT).show();
                    } else if (p_number.getText().toString().length() != 10) {
                        Toast.makeText(getApplicationContext(), "Mobile No. Invalid !!", Toast.LENGTH_SHORT).show();
                    } else {

                        // Get current data and time.
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String currentData = sdf.format(new Date());
                        long createdTime = System.currentTimeMillis();


                        Intent intent = getIntent();
                        String dataName = intent.getStringExtra("name");
                        String datagam = intent.getStringExtra("gam");
                        String datam_no = intent.getStringExtra("m_no");
                        String datayatra = intent.getStringExtra("yatra");
                        String datapeople = intent.getStringExtra("people");
                        String datachild = intent.getStringExtra("child");
                        String dataamount = intent.getStringExtra("amount");
                        String datadepo = intent.getStringExtra("depo");
                        String databaki = intent.getStringExtra("baki");
                        String datasvikarnar = intent.getStringExtra("svikarnar");


                        // Uploading data to firebase realtime.
                        Data dataF = new Data();
                        dataF.receiptNo = receiptNo + 1;
                        dataF.name = dataName;
                        dataF.gam = datagam;
                        dataF.mobileNo = datam_no;
                        dataF.tithiYatra = datayatra;
                        dataF.people = datapeople;
                        dataF.children = datachild;
                        dataF.amount = dataamount;
                        dataF.deposit = datadepo;
                        dataF.baki = databaki;
                        dataF.svikarnar = datasvikarnar;
                        dataF.createdTime = new Date().getTime();

                        dataF.Yatri_name = tyatri_name;
                        dataF.age = tage;
                        dataF.from_station = tfrom_station;
                        dataF.to_sation = tto_station;
                        dataF.desc = tdescription;
                        dataF.gender = tgender;

                        myRef.child(String.valueOf(receiptNo + 1)).setValue(dataF);



                    }
                }

            }
        });
    }

    private void dataretrive() {

        Intent intent = getIntent();
        String Name = intent.getStringExtra("name");
        String gam = intent.getStringExtra("gam");
        String m_no = intent.getStringExtra("m_no");
        String yatra = intent.getStringExtra("yatra");
        String people = intent.getStringExtra("people");
        String child = intent.getStringExtra("child");
        String amount = intent.getStringExtra("amount");
        String depo = intent.getStringExtra("depo");
        String baki = intent.getStringExtra("baki");
        String svikarnar = intent.getStringExtra("svikarnar");
        String id = intent.getStringExtra("id");
    }

    private void assign() {

        spinner = findViewById(R.id.spinner);
        yatri_name = findViewById(R.id.yatri_name);
        age = findViewById(R.id.age);
        from_station = findViewById(R.id.from_station);
        to_station = findViewById(R.id.to_station);
        description = findViewById(R.id.description);
        p_number = findViewById(R.id.p_number);
        generateRecieptBtn = findViewById(R.id.generateRecieptBtn);
    }

    private void retrivedata() {
        String tyatri_name = yatri_name.getText().toString();
        String tage = age.getText().toString();
        String tgender = gender.getText().toString();
        String tfrom_station = from_station.getText().toString();
        String tto_station = to_station.getText().toString();
        String tdescription = description.getText().toString();
        int tp_number = Integer.parseInt(p_number.getText().toString());

        String rYatri = getIntent().getStringExtra("Yatri_name");
        String rage = getIntent().getStringExtra("age");
        String rgender = getIntent().getStringExtra("gender");
        String rfrom_station= getIntent().getStringExtra("from_station");
        String rto_station = getIntent().getStringExtra("to_station");
        String rdesc = getIntent().getStringExtra("desc");
        String rp_number = getIntent().getStringExtra("mobileNo");

        String id = getIntent().getStringExtra("dataId");

        if (id != null && !id.isEmpty()) {
            isEdit = true;
        }

        if (isEdit){
            generateRecieptBtn.setText("Save Data");
            Toast.makeText(this, "Mobile No cannot be changed.", Toast.LENGTH_SHORT).show();
            p_number.setInputType(0);

            yatri_name.setText(rYatri);
            age.setText(rage);
            spinner.setSelection(Integer.parseInt(rgender));
            from_station.setText(rfrom_station);
            to_station.setText(rto_station);
            description.setText(rdesc);
            p_number.setText(rp_number);
            isEdit = false;


        }



    }


}