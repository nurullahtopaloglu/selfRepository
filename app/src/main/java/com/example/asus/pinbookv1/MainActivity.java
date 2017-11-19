package com.example.asus.pinbookv1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        // User authorization and verification controls.
        firebaseAuth = FirebaseAuth.getInstance();
        Intent intent = new Intent();

        if (firebaseAuth.getCurrentUser() != null) {

            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user.isEmailVerified()) {
                intent.setClass(getApplicationContext(), ProfileActivity.class);
            } else {
                intent.setClass(getApplicationContext(), LoginActivity.class);
            }
        } else {
            intent.setClass(getApplicationContext(), EntranceActivity.class);
        }

        // Pass to the next page.
        passToNextActivity(intent);

    }

    private void passToNextActivity(Intent intent) {
        finish();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //
            }
        }, 300000);

        startActivity(intent);
    }

    private void Test() {

        int i = 1 + 1;
        int ii = 2 + 2;
        int iii = i + ii;
        int iiii = iii + ii;
        String x;


        return;
    }

}
