package com.example.zishane.energycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Double[] energyRate = {3.1, 4.4, 13.2, 9.7, 5.1, 3.7};

    Spinner spn_type;
    TextView txv_rate, txv_total;
    EditText edt_weight, edt_time;

    Double rate, weight, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn_type = (Spinner) findViewById(R.id.spn_Type);
        txv_rate = (TextView) findViewById(R.id.txv_rate);
        txv_total = (TextView) findViewById(R.id.txv_Total);
        edt_weight = (EditText) findViewById(R.id.edt_weight);
        edt_time = (EditText) findViewById(R.id.edt_time);

        spn_type.setOnItemSelectedListener(this);
    }

    public void calc (View v){
        try {
            weight = Double.parseDouble(edt_weight.getText().toString());
            time = Double.parseDouble(edt_time.getText().toString());
            rate =Double.parseDouble(txv_rate.getText().toString());

            txv_total.setText(String.format("消耗熱量\n %.2f千卡", rate * weight * time));
        }catch (Exception e){}

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        txv_rate.setText((energyRate[position]).toString());
        calc(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



