package com.example.swar.tryme;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private View windowView;
    private Button tryMeButton;
    private int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors = new int[]{Color.BLACK,Color.RED,Color.CYAN,Color.BLUE,Color.GRAY,
        Color.DKGRAY,Color.GREEN,Color.YELLOW};

        windowView = findViewById(R.id.windowViewId);

        tryMeButton = findViewById(R.id.trymebutton);
        tryMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int colorArrayLength = colors.length;
                Random random = new Random();
                int randomNum = random.nextInt(colorArrayLength);
                windowView.setBackgroundColor(colors[randomNum]);

                Log.d("Random",String.valueOf(randomNum));
            }
        });
    }
}
