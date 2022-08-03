package com.bitcode.dialogsday1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button btnDatePickerDialog,btnTimePickerDialog,btnAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    private void initViews(){
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnTimePickerDialog =findViewById(R.id.btnTimePickerDialog);
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
    }

    private void initListeners(){
        btnDatePickerDialog.setOnClickListener(new BtnDatePickerDialogClickListener());
        btnTimePickerDialog.setOnClickListener(new BtnTimePickerDialogClickListener());
    }

    private class BtnDatePickerDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog =
                    new DatePickerDialog(MainActivity.this,
                            new MyOnDateSetListener(),
                            2022,
                            8,
                            15);

            datePickerDialog.show();
        }
    }

    class MyOnDateSetListener implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            btnDatePickerDialog.setText(year +"-"+(month+1)+"-"+dayOfMonth);
        }
    }

    private class BtnTimePickerDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            TimePickerDialog timePickerDialog =
                    new TimePickerDialog(MainActivity.this,
                            new MyOnTimeSetListener(),
                            22,
                            48,
                            false
                            );

            timePickerDialog.show();
        }
    }

    class MyOnTimeSetListener implements TimePickerDialog.OnTimeSetListener{

        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
            btnTimePickerDialog.setText(hour +":"+minutes);
        }
    }
}