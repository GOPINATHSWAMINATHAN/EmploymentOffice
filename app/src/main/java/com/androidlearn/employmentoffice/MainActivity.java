package com.androidlearn.employmentoffice;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox tenth, twelth, ug, pg;
    Switch job;
    Spinner places;
    ToggleButton color;
    ConstraintLayout myConstraint;
    Button submit;
    RadioGroup gender;
    ArrayList<String> placesName=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Layout Inflation
        gender = (RadioGroup) findViewById(R.id.gender);
        myConstraint = (ConstraintLayout) findViewById(R.id.constraint_layout);
        color = (ToggleButton) findViewById(R.id.toggleButton);
        submit = (Button) findViewById(R.id.button);
        tenth = (CheckBox) findViewById(R.id.checkBox);
        twelth = (CheckBox) findViewById(R.id.checkBox2);
        ug = (CheckBox) findViewById(R.id.checkBox3);
        pg = (CheckBox) findViewById(R.id.checkBox4);
        job = (Switch) findViewById(R.id.switch1);
        places=(Spinner)findViewById(R.id.spinner);
        placesName.add("Puducherry");
        placesName.add("Lawspet");
        placesName.add("Muthialpet");
        placesName.add("Muthaliarpet");
        placesName.add("Nainarmandabam");
        placesName.add("Arumparthapuram");
        placesName.add("Kalapet");
        final ArrayAdapter<String> getPlaces=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,placesName);
        places.setAdapter(getPlaces);
        places.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String place=(String)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),"My place is "+place,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        job.setChecked(true);
//        job.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//            }
//        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = gender.getCheckedRadioButtonId();
                RadioButton check = (RadioButton) findViewById(id);
                String myGender = check.getText().toString();
                if (tenth.isChecked()) {
                    String qualification = tenth.getText().toString();

                    Toast.makeText(getApplicationContext(), "Qualification is" + qualification, Toast.LENGTH_LONG).show();
                }
                if (job.isChecked()) {
                    Toast.makeText(getApplicationContext(), "You got a job!! yeah!!!", Toast.LENGTH_LONG).show();
                }


//                Toast t=new Toast(getApplicationContext());
//                t.makeText(getApplicationContext(),"Gender is"+myGender,Toast.LENGTH_LONG).show();

            }
        });
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (color.isChecked()) {
                    myConstraint.setBackgroundColor(Color.RED);
                } else {
                    myConstraint.setBackgroundColor(Color.WHITE);
                }
            }
        });
    }
}
