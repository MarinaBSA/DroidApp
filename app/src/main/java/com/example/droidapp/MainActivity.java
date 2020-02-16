package com.example.droidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final String ORDER_ITEM = "ORDER_ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickOnOrder(View view) {
        int id = view.getId();
        String message;
        switch (id) {
            case R.id.donut_imageview:
                message = getString(R.string.donut_order);
                displayToast(message, getApplicationContext(), Toast.LENGTH_LONG);
                break;
            case R.id.ice_cream_imageview:
                message = getString(R.string.ice_cream_order);
                displayToast(message, getApplicationContext(), Toast.LENGTH_LONG);
                break;
            case R.id.froyo_imageview:
                message = getString(R.string.froyo_order);
                displayToast(message, getApplicationContext(), Toast.LENGTH_LONG);
                break;
            default:
                break;
        }

    }


    public static void displayToast(String message, Context context, int length) {
        Toast toast = Toast.makeText(context,message, length);
        toast.show();
    }

}
