package com.mgabrynowicz.permissiontutorialapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


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
        for (Locale loc : locale) {
            country = loc.getDisplayCountry();
            if (country.length() > 0 && !countries.contains(country)) {
                countries.add(country);
            }
        }
        Collections.sort(countries, String.CASE_INSENSITIVE_ORDER);

        Spinner spinner = (Spinner) findViewById(R.id.countries_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        formFields.addAll(Arrays.asList(userNameEditText, userSurnameEditText, streetNameEditText,
                streetNumberEditText, cityNameEditText, postCodeEditText,
                emailEditText, phoneNumberEditText, passwordEditText, confirmPasswordEditText));


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (checkIfFormsAreFilled()) {

                    Toast.makeText(RegisterForm.this, "Yay forms are filled!", Toast.LENGTH_SHORT).show();
                } else {
                    Snackbar snackbar = Snackbar.make(findViewById(R.id.activity_register_form), "Please fill all forms", Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    TextView txtv = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                    txtv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    snackbarView.setBackgroundColor(ContextCompat.getColor(RegisterForm.this, R.color.primary));
                    snackbar.show();

                }
            }
        });
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



