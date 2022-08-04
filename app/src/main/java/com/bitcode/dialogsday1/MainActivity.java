package com.bitcode.dialogsday1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

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
        btnAlertDialog.setOnClickListener(new BtnAlertDialogClickListener());
    }

    private class BtnAlertDialogClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("BitCode Pune");
            builder.setIcon(R.mipmap.ic_launcher_round);
            builder.setMessage("Are you sure you want to end the exam?");

            /* builder.setPositiveButton("Yes",new YesClickListener());
            builder.setNegativeButton("No", new NoClickListener());
            builder.setNeutralButton("Cancel", new CancelClickListener());
             */

            DialogInterface.OnClickListener listener = new AlertDialogButtonsClickedListener();
            builder.setPositiveButton("Yes",listener);
            builder.setNegativeButton("No", listener);
            builder.setNeutralButton("Cancel",listener);

            builder.setOnCancelListener(new LogoutDialogCancelClickListener());
            builder.setOnDismissListener(new LogoutDialogDismissClickListener());

            AlertDialog logoutDialog = builder.create();
            logoutDialog.show();
        }
    }

    private class AlertDialogButtonsClickedListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                makeToast("Yes Clicked");
            }
            if(which == DialogInterface.BUTTON_NEGATIVE){
                makeToast("No Clicked");
            }
            if(which == DialogInterface.BUTTON_NEUTRAL){
                makeToast("Cancel Clicked");
            }
        }
    }

    private class LogoutDialogCancelClickListener implements DialogInterface.OnCancelListener{
        @Override
        public void onCancel(DialogInterface dialogInterface) {
            makeToast("On Cancel Clicked");
        }
    }

    private class LogoutDialogDismissClickListener implements DialogInterface.OnDismissListener{
        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            makeToast("On Dismiss Clicked");
        }
    }

    private class YesClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            makeToast("Yes Button Clicked");
        }
    }

    private class NoClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            makeToast("No Button Clicked");
        }
    }

    private class CancelClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            makeToast("Cancel Button Clicked");
        }
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

    private void makeToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}