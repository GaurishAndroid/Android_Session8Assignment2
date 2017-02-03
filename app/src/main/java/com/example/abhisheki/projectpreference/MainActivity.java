package com.example.abhisheki.projectpreference;

import android.os.Bundle;
import android.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView textName;
    TextView textAge;
    TextView textPhone;
    TextView textCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Button storeinformation = (Button) findViewById(R.id.storeinformation);
         Button showinformation = (Button) findViewById(R.id.showinformation);
         textView = (TextView) findViewById(R.id.txtPrefs);
         textName=(TextView) findViewById(R.id.txtname);
         textAge=(TextView) findViewById(R.id.txtage);
         textPhone=(TextView) findViewById(R.id.txtphone);
         textCity=(TextView) findViewById(R.id.txtcity);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.storeinformation:
                        try {
                            saveSharedPreferences();
                        }
                        catch(Exception exp)
                        {
                            Toast.makeText(MainActivity.this, exp.getMessage(), Toast.LENGTH_LONG).show();
                        }
                        break;
                    case R.id.showinformation:

                        displaySharedPreferences();
                        break;
                    default:
                        break;
                }
            }
        };
        storeinformation.setOnClickListener(listener);
        showinformation.setOnClickListener(listener);
    }

    private void displaySharedPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        String name = prefs.getString("name", "Default");
        String age = prefs.getString("age", "Default");
        String phone = prefs.getString("phone", "Default");
        String city = prefs.getString("city", "Default");

        StringBuilder builder = new StringBuilder();

        builder.append("Name: " + name + "\n");
        builder.append("Age: " + age + "\n");
        builder.append("Phone: " + phone + "\n");
        builder.append("City: " + city + "\n");
        textView.setText(builder.toString());


    }
    private void saveSharedPreferences()
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("name",textName.getText().toString());
        editor.putString("age",textAge.getText().toString());
        editor.putString("phone",textPhone.getText().toString());
        editor.putString("city",textCity.getText().toString());
        editor.commit();
    }

}


