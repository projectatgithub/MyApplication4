package com.example.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
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
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
    }

    @Override
    public void onBackPressed() {
        setupWindowAnimations();
        super.onBackPressed();
    }
    public void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);

        Slide slide = new Slide();
        fade.setDuration(1000);
        getWindow().setReturnTransition(slide);
    }
}
