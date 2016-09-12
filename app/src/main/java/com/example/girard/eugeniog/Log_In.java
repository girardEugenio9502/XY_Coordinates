package com.example.girard.eugeniog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Log_In extends AppCompatActivity {

    EditText User, Pass;
    Button LogIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);

        User = (EditText) findViewById(R.id.Uname);
        Pass = (EditText) findViewById(R.id.Pword);
        LogIn = (Button) findViewById(R.id.bLogIn);


        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Stores User name
                String username = String.valueOf(User.getText());
                // Stores Password
                String password = String.valueOf(Pass.getText());

                // Validates the User name and Password for admin, admin
                if (username.equals("admin") && password.equals("test")) {
                    Intent intent = new Intent(Log_In.this, Coordinates.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Info", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
