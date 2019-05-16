package com.example.postpc_demo_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView insertedNumber;
    Button fisherman;
    Button number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        getSaveInstanceState(savedInstanceState);
        setListeners();
    }

    private void getViews(){
        insertedNumber = findViewById(R.id.numberTextView);
        fisherman = findViewById(R.id.goFish);
        number = findViewById(R.id.number);
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("insertedNumber", insertedNumber.getText().toString());
    }

    private void getSaveInstanceState(Bundle bundle){
        if (bundle != null)
        {
            insertedNumber.setText(bundle.getString("insertedNumber"));
        }
    }

    private void setListeners(){
        fisherman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FishermanActivity.class);
                startActivity(intent);
            }
        });
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NumberActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                String userInsertedNumber = data.getStringExtra("insertedNumber");
                String insertedNumberMessage = "you have entered: " + userInsertedNumber;
                insertedNumber.setText(insertedNumberMessage);
            }
        }
    }
}
