package com.example.anotherfirstapp;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button btnSellAll, btnCurRead, btnWantToread, btnAlreadyRead, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.in, R.anim.out);
        initWidget();
        setOnClickListnerWork();
        work(10,10);
        Log.d(TAG, "onCreate: strarted");
        Log.e(TAG, "onCreate: error", new Throwable());
        Log.i(TAG, "onCreate: information");
        Log.v(TAG,"verbose");

    }
    private void work(int a, int b){
        int result = a+b;
        Log.d(TAG, "Result: " + result);
    }
    private void setOnClickListnerWork(){
        btnSellAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });
        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadActivity.class);
                startActivity(intent);
            }
        });
        btnCurRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReading.class);
                startActivity(intent);
            }
        });
        btnWantToread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantToActivity.class);
                startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutTapped();
            }
        });
    }
    private void aboutTapped(){
        Log.d(TAG, "aboutTapped: started");
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("About my Library App")
                .setMessage("Build and published by Mustafa Hamim\n" +
                        "\n"+
                        "If you want to hire me or \n" +
                        "if you want to check my other works\n" +
                        "take a look at:\n" +
                        "rabu.org")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, myWebView.class);
                        intent.putExtra("url","https://www.google.com");
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create().show();
    }
    private void initWidget(){
        btnSellAll = (Button)findViewById(R.id.btnSeeAll);
        btnCurRead = (Button)findViewById(R.id.btnCurRead);
        btnWantToread = (Button)findViewById(R.id.btnWantToRead);
        btnAlreadyRead = (Button)findViewById(R.id.btnAlreadyRead);
        btnAbout = (Button)findViewById(R.id.btnAbout);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}
