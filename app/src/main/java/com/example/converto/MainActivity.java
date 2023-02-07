package com.example.converto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String [] measures = {"Inch/Feet","Meter/Yard","Celsius/Fahrenheit","Celsius/Kelvin","KiloGrams/Pound[lbs]"};
    EditText input,output;
    View outBg,sett;
    Button Go;
    String convInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.Menu);
        input = findViewById(R.id.input);
        output = findViewById(R.id.Out);
        outBg = findViewById(R.id.outbg);
        Go = findViewById(R.id.GoBtn);
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, R.layout.spinnere , measures);
        adapter.setDropDownViewResource(R.layout.spinnere_drop);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convInput = measures[position];
                output.setVisibility(View.INVISIBLE);
                outBg.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, convInput, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inpt = input.getText().toString().trim();
//                Toast.makeText(MainActivity.this, inpt, Toast.LENGTH_SHORT).show();
                if(inpt.equals("")){
                    Toast.makeText(MainActivity.this, "Please Enter Valid Inputs", Toast.LENGTH_SHORT).show();
                }else{
                    float a = Float.parseFloat(inpt);
                    output.setVisibility(View.VISIBLE);
                    outBg.setVisibility(View.VISIBLE);
                    switch (convInput){
                        case "Inch/Feet":
                            float res = (float) (a/12.0);
                            output.setText(Float.toString(res)+" "+"Feet");
                            break;
                        case "Meter/Yard":
                            float res1 = (float) (a*1.094);
                            output.setText(Float.toString(res1)+" Yards");
                            break;
                        case "Celsius/Fahrenheit":
                            float res2 = (float) ((a*(9.0/5.0))+32.0);
                            output.setText(Float.toString(res2)+" Fahrenheit");
                            break;
                        case "KiloGrams/Pound[lbs]":
                            float res3 = (float) (a*2.205);
                            output.setText(Float.toString(res3)+" Pounds");
                            break;
                        case "Celsius/Kelvin":
                            float res4 = (float) (a+273.15);
                            output.setText(Float.toString(res4)+" Kelvins");
                            break;
                        default:
                            Toast.makeText(MainActivity.this, "Not a Valid Input", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void onClickSett(View v) {
                startActivity(new Intent(MainActivity.this,Settings.class));
    }

}