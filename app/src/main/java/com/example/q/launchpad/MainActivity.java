package com.example.q.launchpad;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.media.AudioManager;

public class MainActivity extends AppCompatActivity {
    private String mFilename = null;
    private LoopMediaPlayer mPlayer = null;
    private LoopMediaRecorder mRecorder = null;
//    private LoopMediaRecorder mRecorder = new LoopMediaRecorder(mFilename);
//    private LoopMediaPlayer mPlayer = new LoopMediaPlayer(getApplicationContext(), mFilename);
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.record:
                if(item.getTitle().equals(R.string.action_record)) {
                    item.setIcon(ContextCompat.getDrawable(this, R.drawable.stop));
                    item.setTitle(R.string.action_stop);
                    startRecord();
                }
                else{
                    item.setIcon(ContextCompat.getDrawable(this, R.drawable.manual_record));
                    item.setTitle(R.string.action_record);
                    stopRecord();
                }
                return true;
            case R.id.play:
                if(item.getTitle().equals(R.string.action_play)) {
                    item.setIcon(ContextCompat.getDrawable(this, R.drawable.stop));
                    item.setTitle(R.string.action_stop);
                    startPlay();
                }
                else{
                    item.setIcon(ContextCompat.getDrawable(this, R.drawable.play_arrow));
                    item.setTitle(R.string.action_play);
                    stopPlay();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void stopRecord() {
        if(this.mRecorder == null) {
            Log.d("STOP_RECORD", "NO_RECORDER");
        }
        else {
            this.mRecorder.stopRecord(this.mRecorder.isRecording());
            this.mPlayer = new LoopMediaPlayer(this, mFilename);

        }
    }
    private void startPlay() {
        if(this.mFilename == null) {
            Log.d("START_PLAY","NO_FILENAME");
        }
        else{
            //            instantiation must be in onCreate();
            if(mPlayer.isPlaying()) {
                Log.d("START_PLAY","ALREADY_STARTED");
            }
            else{
                mPlayer.start();
            }
        }
    }
    private void stopPlay() {
        if(mPlayer.isPlaying()){
            mPlayer.stop();
        }
    }
    private void startRecord(){
        if(this.mPlayer != null) {
            this.mPlayer.release();
            this.mPlayer = null;
        }
        if(this.mFilename == null){
            Log.d("START_RECORD","NO_FILENAME");
        }
        else{
            this.mRecorder = new LoopMediaRecorder(this.mFilename);
            this.mRecorder.startRecord(this.mRecorder.isRecording());
        }
    }
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
