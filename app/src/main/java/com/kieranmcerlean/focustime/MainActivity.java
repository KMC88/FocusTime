package com.kieranmcerlean.focustime;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final long START_TIME_MILLISECONDS = 6000000;

    private TextView mTVCountdown;
    private Button mButtonStart;
    private Button mButtonPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;
    private boolean mTimerIsRunning;

    private long mTimeRemaining = START_TIME_MILLISECONDS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTVCountdown = (TextView)findViewById(R.id.tv_counter);
        mButtonStart = (Button)findViewById(R.id.button_start);
        mButtonPause = (Button)findViewById(R.id.button_pause);
        mButtonReset = (Button)findViewById(R.id.button_reset);

        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mTimerIsRunning){
                    startTimer();
                }
            }
        });

        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTimerIsRunning){
                    pauseTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    private void startTimer(){


    }

    private void pauseTimer(){

    }

    private void resetTimer(){

    }
}
