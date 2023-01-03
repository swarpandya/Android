package com.example.swar.showactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private Button goToSecondButton;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        goToSecondButton = (Button) findViewById(R.id.showButtonID);
        goToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent shows your intension of what you want to do
                //Our intent is to go from first activity to second
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("Message","Hello from First Activity");
                intent.putExtra("SecondMessage","Hello Again");
                intent.putExtra("Value",123);

                //startActivity(intent);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
                String result = data.getStringExtra("returnData");

                Toast.makeText(FirstActivity.this,result,Toast.LENGTH_LONG).show();
            }
        }
    }
}
