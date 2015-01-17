package com.dev.pr.geotrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vermel on 17/01/15.
 */

public class Connexion extends Activity {

    Button signin;
    Button Register;
    TextView user;
    TextView pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.connexion);

        signin = (Button) findViewById(R.id.go);
        Register = (Button) findViewById(R.id.sign);

        user = (TextView) findViewById(R.id.password);
        pass = (EditText) findViewById(R.id.UserName);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });

         signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhotoIntentActivity.class);
                Bundle b = new Bundle();
                new MyAsyncTask().execute(user.getText().toString(), pass.getText().toString());

                System.out.println("USER ?"+user.getText()+"?  password"+pass.getText());
                if (!user.getText().toString().matches("") && !pass.getText().toString().matches("")) {
                    b.putString("username", user.getText().toString()); //Your id
                    b.putString("password", pass.getText().toString()); //Your id
                    i.putExtras(b);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Your Account is invalid", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
