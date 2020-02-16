package com.example.droidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        //Set up spinner data
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set up spinner
        Spinner spinner = findViewById(R.id.spinner);
        if(spinner != null) {
            spinner.setOnItemSelectedListener(this);
            spinner.setAdapter(adapter);
        }

    }

    public void chooseDeliveryMethod(View view) {
        int id = view.getId();
        String method;

        switch (id) {
            case R.id.same_day_order: {
                method = getString(R.string.same_day_text);
                break;
            }

            case R.id.next_day_order: {
                method = getString(R.string.next_day_text);
                break;
            }

            case R.id.pick_up_order: {
                method = getString(R.string.pick_up_text);
                break;
            }

            default:
                method = "No method chosen.";
                break;
        }
        MainActivity.displayToast(method, getApplicationContext(), Toast.LENGTH_LONG);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String message = parent.getItemAtPosition(position).toString();
        MainActivity.displayToast(message, getApplicationContext(), Toast.LENGTH_LONG);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
