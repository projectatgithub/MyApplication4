package com.example.myapplication4;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.balysv.materialripple.MaterialRippleLayout;
import com.google.firebase.database.FirebaseDatabase;


public class Registrationform extends AppCompatActivity {
    private EditText e1, e2, e3, e4, e5, e6;
    private String name, email, phone, password, cpassword;
    private MaterialRippleLayout b1;
    private Spinner s1, s2;
    private Vibrator vibrator;
FirebaseDatabase firebaseDatabase;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationform);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        ;
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        e1 = (EditText) findViewById(R.id.ed3);
        e2 = (EditText) findViewById(R.id.ed4);
        e3 = (EditText) findViewById(R.id.ed5);
        e4 = (EditText) findViewById(R.id.ed6);
        e5 = (EditText) findViewById(R.id.ed7);
        e6 = (EditText) findViewById(R.id.ed8);
        b1 = (MaterialRippleLayout) findViewById(R.id.submitripple);
        s1 = (Spinner) findViewById(R.id.sp1);
        s2 = (Spinner) findViewById(R.id.sp2);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if ((i == 1) || i == 0) {

                    s2.setEnabled(false);
                    s2.setClickable(false);
                    s2.setDropDownVerticalOffset(20);
                    s2.setVisibility(View.GONE);
                } else {
                    s2.setEnabled(true);
                    s2.setClickable(true);
                    s2.setDropDownVerticalOffset(20);
                    s2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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
            // Toast.makeText(this, "Signup has Failed", Toast.LENGTH_SHORT).show();
        } else {
            onSignupSuccess();
        }
    }

    public void onSignupSuccess() {

    }

    public boolean validate() {
        boolean valid = Boolean.parseBoolean("true");


        if (TextUtils.isEmpty(name) || name.length() > 32) {
            e1.setError("Please Enter valid name");
            valid = Boolean.parseBoolean("false");
        }
        if (TextUtils.isEmpty(email) /*|| !Patterns.EMAIL_ADDRESS.matcher(email).matches()*/) {


            e3.setError("Please Enter valid Email Address");
            valid = Boolean.parseBoolean("false");
        }
        if (TextUtils.isEmpty(password)) {
            e5.setError("Please Enter Password");
            valid = Boolean.parseBoolean("false");
        }
        if (TextUtils.isEmpty(cpassword)) {
            e6.setError("Please Enter Password");
            valid = Boolean.parseBoolean("false");
        }
        if (TextUtils.isEmpty(phone)) {
            e4.setError("Please Enter phone number");
            valid = Boolean.parseBoolean("false");
        }
        if (s1.getSelectedItem().equals("DEPARTMENT")) {
            Toast.makeText(this, "please select Department", Toast.LENGTH_SHORT).show();
            valid = Boolean.parseBoolean("false");
        }
        if (s1.getSelectedItem().equals("B TECH") && s2.getSelectedItem().equals("BRANCH")) {
            Toast.makeText(this, "please select Branch", Toast.LENGTH_SHORT).show();
            valid = Boolean.parseBoolean("false");
            vibrator.vibrate(300);
        }


        return valid;
    }


    public void initialize() {
        name = e1.getText().toString().trim();
        email = e2.getText().toString().trim();
        phone = e3.getText().toString().trim();
        password = e4.getText().toString().trim();
        cpassword = e5.getText().toString().trim();

    }


}