package com.kieranmcerlean.focustime;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final long START_TIME_MILLISECONDS = 1500000;

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

        updateTimerText();
    }

    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeRemaining, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeRemaining = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                mTimerIsRunning = false;
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }.start();

        mTimerIsRunning = true;
        mButtonPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);

    }

    private void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerIsRunning = false;
        mButtonStart.setText("start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer(){
        mTimeRemaining = START_TIME_MILLISECONDS;
        updateTimerText();
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void updateTimerText(){
        int minutes = (int) (mTimeRemaining/1000)/60;
        int seconds = (int) (mTimeRemaining/1000)%60;

        String timeRemainingFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        mTVCountdown.setText(timeRemainingFormatted);
    }
}
