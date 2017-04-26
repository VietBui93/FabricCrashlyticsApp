package com.dinhviet.fab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mLoginButton;
    private EditText mEmailInput;
    private EditText mPassInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        mLoginButton = (Button) findViewById(R.id.button_login);
        mEmailInput = (EditText) findViewById(R.id.edit_email);
        mPassInput = (EditText) findViewById(R.id.edit_user_name);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_login) {
            validateDataInputting(mEmailInput, mPassInput);
            // handle action login click
            logUserInformation(mEmailInput.getText().toString(), mPassInput.getText().toString());
        }
    }

    private void logUserInformation(String email, String password) {
        Crashlytics.setUserEmail(email);
        Crashlytics.setString("password", password);
        Crashlytics.log(email);
        throw new NullPointerException("test crash");
    }

    private void validateDataInputting(EditText emailInput, EditText passInput) {
        if (TextUtils.isEmpty(emailInput.getText()) || TextUtils.isEmpty(passInput.getText())) {
            Toast.makeText(this, "Both email and password are required!", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        Toast.makeText(this, "SUCCESS!", Toast.LENGTH_SHORT).show();
    }
}
