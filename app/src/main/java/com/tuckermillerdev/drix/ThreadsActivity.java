package com.tuckermillerdev.drix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ThreadsActivity extends AppCompatActivity {

    Button mSignout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);

        mSignout = findViewById(R.id.signOutBtn);
        mAuth = FirebaseAuth.getInstance();

        mSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                FirebaseUser currentUser = mAuth.getCurrentUser();
                updateUI(currentUser);
            }
        });
    }

    public void updateUI(FirebaseUser user){
        if (user == null) {
            startActivity(new Intent(ThreadsActivity.this, AuthenticationActivity.class));
        }
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
