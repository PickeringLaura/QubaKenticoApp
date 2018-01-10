package com.shu.qubacms.qubacms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class User_Dashboard extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button logOut = findViewById(R.id.LogOut);
        logOut.setOnClickListener(this);

        Button contactForms = findViewById(R.id.contactformresponses);
        contactForms.setOnClickListener(this);

        Button addtional = findViewById(R.id.addtionalFunctions);
        addtional.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void onClick(View view)
    {
        if (isLogoutButton(view))
        {
            goToExit();
        }
        if (isContactForm(view))
        {
            goToForms();
        }
        if (isAdditionalFunctions(view))
        {
            goToAdditional();
        }
    }

    private boolean isLogoutButton(View view)
    {
        return view == findViewById(R.id.LogOut);
    }

    private boolean isContactForm(View view)
    {
        return view == findViewById(R.id.contactformresponses);
    }

    private boolean isAdditionalFunctions(View view)
    {
        return view == findViewById(R.id.addtionalFunctions);
    }

    private void goToExit(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToForms()
    {
        Intent intent = new Intent(this, contactFormResponses.class);
        startActivity(intent);
    }

    private void goToAdditional()
    {
        Intent intent = new Intent(this, additionalFunctions.class);
        startActivity(intent);
    }

}
