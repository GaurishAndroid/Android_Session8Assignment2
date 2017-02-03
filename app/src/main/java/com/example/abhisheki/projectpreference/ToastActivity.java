package com.example.abhisheki.projectpreference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by ABHISHEKI on 03-02-2017.
 */

public class ToastActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String s = getIntent().getStringExtra("PreferenceString");
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
