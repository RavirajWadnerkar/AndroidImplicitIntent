package com.example.weblinkandphonecallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText urlEditText;
    private EditText phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = findViewById(R.id.urlEditText);
        Button launchButton = findViewById(R.id.launchButton);
        phoneEditText = findViewById(R.id.phoneEditText);
        Button ringButton = findViewById(R.id.ringButton);
        Button closeButton = findViewById(R.id.closeButton);

        launchButton.setOnClickListener(v -> openWebPage(urlEditText.getText().toString()));
        ringButton.setOnClickListener(v -> dialPhoneNumber(phoneEditText.getText().toString()));
        closeButton.setOnClickListener(v -> closeApp());
    }

    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void dialPhoneNumber(String phoneNumber) {
        Uri number = Uri.parse("tel:" + phoneNumber);
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        }
    }

    private void closeApp() {
        finish();
    }
}
