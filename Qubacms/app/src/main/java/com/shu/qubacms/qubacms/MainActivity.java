package com.shu.qubacms.qubacms;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());*/

        Button button = (Button) findViewById(R.id.Login);
        button.setOnClickListener(this);
        Button contact = (Button) findViewById(R.id.Contactus);
        contact.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public void onClick(View view) {

        if (isLoginButton(view))
        {
            goToDashboard();
        }
        else if (isContactButton(view))
        {
            goToContact();
        }
        else if (isExitButton(view))
        {
            System.exit(0);
        }
    }

    private boolean isLoginButton(View view) {
        return view == findViewById(R.id.Login);
    }
    private boolean isContactButton(View view) { return view == findViewById(R.id.Contactus);}
    private boolean isExitButton(View view)
    {
        return view == findViewById(R.id.LogOut);
    }

    private void goToDashboard() {
        Intent intent = new Intent(MainActivity.this, User_Dashboard.class);
        startActivity(intent);
    }
    private void goToContact(){
        Intent next = new Intent(MainActivity.this, ContactUs.class);
        startActivity(next);
    }

}
