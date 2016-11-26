package com.mgabrynowicz.permissiontutorialapp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private TextView messageText;
    public static final int READ_WRITE_CONTACTS_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.loginButton);
        messageText = (TextView) findViewById(R.id.messageText);
        loginButton.setEnabled(false);


        if (dontHavePermission(Manifest.permission.READ_CONTACTS) || dontHavePermission(Manifest.permission.WRITE_CONTACTS)) {
            if (shouldShowPermissionRationale(Manifest.permission.READ_CONTACTS)
                    && shouldShowPermissionRationale(Manifest.permission.WRITE_CONTACTS)) {
                showRationaleDialog();
            } else {
                requestReadWriteContactsPermission();
            }
        } else {
            loginButton.setEnabled(true);
            messageText.setVisibility(View.INVISIBLE);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(startMainActivityIntent);

            }
        });
    }

    private boolean dontHavePermission(String permission) {
        return ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED;
    }

    private boolean shouldShowPermissionRationale(String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(this, permission);
    }

    private void requestReadWriteContactsPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS},
                READ_WRITE_CONTACTS_REQUEST);
    }

    private void showRationaleDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        requestReadWriteContactsPermission();
                    }
                })
                .setNegativeButton(R.string.no, null)
                .create()
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case READ_WRITE_CONTACTS_REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // nadano uprawnienie
                    loginButton.setEnabled(true);
                    messageText.setVisibility(View.INVISIBLE);
                } else {
                    // odmówiono nadania uprawnienia
                }
            }
        }
    }
}
