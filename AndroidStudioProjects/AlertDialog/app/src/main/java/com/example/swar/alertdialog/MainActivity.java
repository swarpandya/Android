package com.example.swar.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder alertDialog;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.showDialogID);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show the actual dialog(Alert Dialog)
                alertDialog = new AlertDialog.Builder(MainActivity.this);

                //set things up- setup title
                //alertDialog.setTitle(R.string.title); This is same as below No.2
                alertDialog.setTitle(getResources().getString(R.string.title));

                //set message
                alertDialog.setMessage(getResources().getString(R.string.message));

                //set cancelable
                alertDialog.setCancelable(false);

                //set positive button
                alertDialog.setPositiveButton(getResources().getString(R.string.yes),//new event listner
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Exit our window activity
                                MainActivity.this.finish();
                            }
                        });

                //set negative button
                alertDialog.setNegativeButton(getResources().getString(R.string.no),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                //create the actual dialog
                AlertDialog dialog = alertDialog.create();

                //show the dialog
                dialog.show();
            }
        });
    }
}
