package com.example.myapplication4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Deepak on 10/13/2017.
 */

public class Registrationform extends AppCompatActivity {
  private   EditText e1,e2,e3,e4,e5,e6;
    private String name ,email,phone,password,cpassword;
    Button b1;
    Spinner s1,s2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationform);
        e1=(EditText)findViewById(R.id.ed3);
        e2=(EditText)findViewById(R.id.ed4);
        e3=(EditText)findViewById(R.id.ed5);
        e4=(EditText)findViewById(R.id.ed6);
        e5=(EditText)findViewById(R.id.ed7);
        e6=(EditText)findViewById(R.id.ed8);
        b1=(Button)findViewById(R.id.b1);
        s1=(Spinner)findViewById(R.id.sp1);
        s2=(Spinner)findViewById(R.id.sp2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

    }
    public void register() {
        initialize();

        if (!validate()) {
            Toast.makeText(this, "Signup has Failed", Toast.LENGTH_SHORT).show();
        } else {
            onSignupSuccess();
        }
    }

    public void onSignupSuccess(){

    }
    public boolean validate(){
        boolean valid= Boolean.parseBoolean("true");


        if(name.isEmpty()||name.length()>32){
            e1.setError("Please Enter valid name");
            valid= Boolean.parseBoolean("false");
        }
        if(email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){


            e3.setError("Please Enter valid Email Address");
            valid= Boolean.parseBoolean("false");
        }
    if(password.isEmpty()){
        e5.setError("Please Enter Password");
        valid= Boolean.parseBoolean("false");
    }
    if(cpassword.isEmpty()){
        e6.setError("Please Enter Password");
        valid= Boolean.parseBoolean("false");
    }
    if(phone.isEmpty()){
        e4.setError("Please Enter phone number");
        valid= Boolean.parseBoolean("false");
    }

    return valid;
     }


public void initialize(){
    name=e1.getText().toString().trim();
    email=e2.getText().toString().trim();
    phone=e3.getText().toString().trim();
    password=e4.getText().toString().trim();
    cpassword=e5.getText().toString().trim();

}}