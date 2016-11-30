package com.mgabrynowicz.permissiontutorialapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class RegisterForm extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText userSurnameEditText;
    private EditText streetNameEditText;
    private EditText streetNumberEditText;
    private EditText cityNameEditText;
    private EditText postCodeEditText;
    private EditText countryEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button registerButton;
    final List<EditText> formFields = new ArrayList<EditText>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        userSurnameEditText = (EditText) findViewById(R.id.userSurnameEditText);
        streetNameEditText = (EditText) findViewById(R.id.streetNameEditText);
        streetNumberEditText = (EditText) findViewById(R.id.streetNumberEditText);
        cityNameEditText = (EditText) findViewById(R.id.cityNameEditText);
        postCodeEditText = (EditText) findViewById(R.id.postCodeEditText);
        //countryEditText = (EditText) findViewById(R.id.countryEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        confirmPasswordEditText = (EditText) findViewById(R.id.confirmPasswordEditText);
        registerButton = (Button) findViewById(R.id.registerButton);


        Locale[] locale = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();
        String country;
        for( Locale loc : locale ){
            country = loc.getDisplayCountry();
            if( country.length() > 0 && !countries.contains(country) ){
                countries.add( country );
            }
        }
        Collections.sort(countries, String.CASE_INSENSITIVE_ORDER);

        Spinner spinner = (Spinner) findViewById(R.id.countries_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, countries);
        spinner.setAdapter(adapter);


        //TODO add countries spinner validation
        //TODO add cities by localization

        formFields.addAll(Arrays.asList(userNameEditText, userSurnameEditText, streetNameEditText,
                streetNumberEditText, cityNameEditText, postCodeEditText,
                emailEditText, phoneNumberEditText, passwordEditText, confirmPasswordEditText));


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkIfFormsAreFilled()) {

                    Toast.makeText(RegisterForm.this, "Yay forms are filled!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterForm.this, "Fill the forms!", Toast.LENGTH_SHORT).show();
                }


            }

        }
        );


    }


    public boolean checkIfFormsAreFilled() {
        boolean filledForms = true;
        for (EditText tmpEditText : formFields) {
            if (tmpEditText.getText().toString().isEmpty()) {
                filledForms = false;

            }

        }
        return filledForms;
    }



    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
        } else {
        }

    }
}



