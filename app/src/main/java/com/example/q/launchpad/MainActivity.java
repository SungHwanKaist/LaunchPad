package com.example.q.launchpad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.AudioManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);
        Button btn5 = (Button)findViewById(R.id.button5);
        Button btn6 = (Button)findViewById(R.id.button6);
        Button btn7 = (Button)findViewById(R.id.button7);
        Button btn8 = (Button)findViewById(R.id.button8);
        Button btn9 = (Button)findViewById(R.id.button9);
        Button btn10 = (Button)findViewById(R.id.button10);
        Button btn11 = (Button)findViewById(R.id.button11);
        Button btn12 = (Button)findViewById(R.id.button12);
        Button btn13 = (Button)findViewById(R.id.button13);
        Button btn14 = (Button)findViewById(R.id.button14);
        Button btn15 = (Button)findViewById(R.id.button15);
        Button btn16 = (Button)findViewById(R.id.button16);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}
