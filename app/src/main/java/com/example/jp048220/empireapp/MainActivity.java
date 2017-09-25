package com.example.jp048220.empireapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button StrikeButton;
    Button BallButton;

    TextView StrikeCount;
    TextView BallCount;
    TextView TotalOutsCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BallButton = (Button) findViewById(R.id.BallButton);

        BallCount = (TextView) findViewById(R.id.BallCount);

        StrikeButton = (Button) findViewById(R.id.StrikeButton);

        StrikeCount = (TextView) findViewById(R.id.StrikeCount);

        TotalOutsCount = (TextView) findViewById(R.id.TotalOutsCount);


        BallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String BallNum = BallCount.getText().toString();
                int BallView = Integer.parseInt(BallNum);
                BallView++;

                if (BallView <= 3) {
                        BallCount.setText(String.valueOf(BallView));

                    }
                    else {
                        BallCount.setText(String.valueOf(0));

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Walk");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();

                }
                }

            });

        StrikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StrikeNum = StrikeCount.getText().toString();
                int StrikeView = Integer.parseInt(StrikeNum);
                StrikeView++;
                String TotalOutsNum = TotalOutsCount.getText().toString();
                int TotalOutsCountView = Integer.parseInt(TotalOutsNum);
                TotalOutsCountView++;

                if (StrikeView <= 2) {
                    StrikeCount.setText(String.valueOf(StrikeView));


                } else {
                    StrikeCount.setText(String.valueOf(0));

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Out");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                    TotalOutsCount.setText(String.valueOf(TotalOutsCountView));

                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.resetAction)
        {
            Toast.makeText(this, "Reset menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));

        }
        else if(id==R.id.aboutAction)
        {
            Toast.makeText(this, "About menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AboutActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

