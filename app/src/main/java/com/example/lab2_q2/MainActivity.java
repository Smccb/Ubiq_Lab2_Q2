package com.example.lab2_q2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    //Intent emailIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting button from layout and creating message String to display out
        Button button = (Button)findViewById(R.id.button);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Send email", "");
                EditText emailTyped   = findViewById(R.id.email);
                String emailAdd = emailTyped.getText().toString();
                String[] TO = {emailAdd};
                Toast.makeText(MainActivity.this, emailAdd, Toast.LENGTH_SHORT).show();
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { emailAdd });
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email from application");
                Toast.makeText(MainActivity.this, emailAdd, Toast.LENGTH_SHORT).show();
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello!....");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}