package com.example.postpc_demo_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class NumberActivity extends AppCompatActivity {

    EditText sendMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        sendMessageEditText = findViewById(R.id.sendMessageEditText);
        getSaveInstanceState(savedInstanceState);
        sendMessageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 5)
                {
                    Intent intentBack = new Intent(NumberActivity.this, MainActivity.class);
                    intentBack.putExtra("insertedNumber", sendMessageEditText.getText().toString());
                    setResult(RESULT_OK, intentBack);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("sendMessageEditText", sendMessageEditText.getText().toString());
    }

    private void getSaveInstanceState(Bundle bundle){
        if (bundle != null)
        {
            sendMessageEditText.setText(bundle.getString("sendMessageEditText"));
        }
    }
}
