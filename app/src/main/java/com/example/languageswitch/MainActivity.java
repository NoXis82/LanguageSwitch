package com.example.languageswitch;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        Button button = findViewById(R.id.button);
        final Spinner spinner = findViewById(R.id.spinner_language);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (spinner.getSelectedItemPosition()) {
                    case 0:
                        changeLocale("ru");
                        break;
                    case 1:
                        changeLocale("en");
                        break;
                    case 2:
                        changeLocale("de");
                        break;
                }
            }
        });
    }

    public void changeLocale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext()
                .getResources()
                .getDisplayMetrics());
        recreate();
    }
}
