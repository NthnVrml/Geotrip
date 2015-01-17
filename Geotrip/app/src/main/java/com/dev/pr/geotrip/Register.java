package com.dev.pr.geotrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by vermel on 17/01/15.
 */
public class Register extends Activity {

    Button b;
    EditText name;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        name = (EditText) findViewById(R.id.idUser);
        password = null;
        password = (EditText) findViewById(R.id.password);

        b = (Button) findViewById(R.id.ok);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(),"Your id/mail is invalid !",Toast.LENGTH_LONG).show();
                }
                if (password.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(),"Your password is invalid !",Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(),"Registration Successful, Please connect you !",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), Connexion.class);
                startActivity(i);
            }
        });

    }
}
