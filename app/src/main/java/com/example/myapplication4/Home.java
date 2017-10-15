package com.example.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.spark.submitbutton.SubmitButton;

/**
 * Created by root on 15/10/17.
 */

public class Home extends AppCompatActivity {
    private SubmitButton Admin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);
        Admin= (SubmitButton) findViewById(R.id.admin);
        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Registrationform.class));
            }
        });
    }
}
