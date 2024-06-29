package com.example.blog_it;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;




public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    AppCompatButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences=getSharedPreferences("blog",MODE_PRIVATE);
        String username=preferences.getString("user",null);
        if(username!=null)
        {
            Intent i=new Intent(getApplicationContext(), login_page.class);
            startActivity(i);
        }


        e1 = (EditText) findViewById(R.id.uname);
        e2 = (EditText) findViewById(R.id.pass);
        b1 = (AppCompatButton) findViewById(R.id.signinbtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = e1.getText().toString();
                String password = e2.getText().toString();
                if (username.equals("admin") && password.equals("1234")) {
                    SharedPreferences preferences=getSharedPreferences("blog",MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("user","admin");
                    editor.apply();
                    Intent i = new Intent(getApplicationContext(), login_page.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "InvalidPassword", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}