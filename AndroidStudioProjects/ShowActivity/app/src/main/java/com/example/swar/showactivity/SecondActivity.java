package com.example.swar.showactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private TextView showMessage;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        showMessage = (TextView) findViewById(R.id.messageTextView);
        backButton = (Button) findViewById(R.id.goBackButtonID);
        Bundle extras = getIntent().getExtras();

        //check
        if(extras != null){
            String message = extras.getString("SecondMessage");
            int myInt = extras.getInt("Value");

            showMessage.setText("Message is "+message+" and : "+String.valueOf(myInt));
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData","From SecondActivity");
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
