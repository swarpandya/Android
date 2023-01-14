package com.example.swar.tipcalculatortest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView textViewSeekbar;
    private int seekbarPercentage;
    private float enteredBillFloat;
    private TextView totalBillTv;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = (EditText) findViewById(R.id.billamountID);
        seekBar = (SeekBar) findViewById(R.id.percentageSeekBar);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        totalResultTextView = (TextView)findViewById(R.id.resultID);
        textViewSeekbar = (TextView) findViewById(R.id.textViewSeekbar);
        totalBillTv = (TextView) findViewById(R.id.totalBillTextView);

        //Log.d(TAG,"Hello from Calculate Method");

        //this and MainActivity.this is same
        //Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_LONG).show();

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewSeekbar.setText(String.valueOf(seekBar.getProgress())+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarPercentage = seekBar.getProgress();

            }
        });
    }

    @Override
    public void onClick(View view) {
        calculate();
    }

    public void calculate(){
        float result = 0.0f;
        if(!enteredAmount.getText().toString().equals("")){
            enteredBillFloat=Float.parseFloat(enteredAmount.getText().toString());
            result = enteredBillFloat * seekbarPercentage / 100;
            totalResultTextView.setText("Your tip will be $"+String.valueOf(result));
            totalBillTv.setText("Total Bill: $"+String.valueOf(enteredBillFloat+result));
        }
        else{
            Toast.makeText(MainActivity.this,"Please Enter your Bill",Toast.LENGTH_LONG).show();
        }


    }
}
