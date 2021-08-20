package com.example.basicbankapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation anim;
    ImageView bankLogo;
    TextView tvBankTitle;
    Button btnAllUsers, btnAllTransactions;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anim = AnimationUtils.loadAnimation(this, R.transition.animation);
        bankLogo = findViewById(R.id.imageView);
        btnAllUsers = findViewById(R.id.button2);
        btnAllTransactions = findViewById(R.id.button);
        tvBankTitle = findViewById(R.id.textView);

        bankLogo.setAnimation(anim);
        tvBankTitle.setAnimation(anim);
        btnAllUsers.setAnimation(anim);
        btnAllTransactions.setAnimation(anim);
    }

    public void ViewUsers(View view) {
        Intent intent = new Intent(this, ViewAllUsers.class);
        startActivity(intent);
    }

    public void ViewTrans(View view) {
        Intent intent = new Intent(this, ViewAllTrans.class);
        startActivity(intent);
    }
}