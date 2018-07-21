package com.example.q.launchpad;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
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

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private String mFilename = null;
    private LoopMediaPlayer mPlayer = null;
    private LoopMediaRecorder mRecorder = null;
//    private LoopMediaRecorder mRecorder = new LoopMediaRecorder(mFilename);
//    private LoopMediaPlayer mPlayer = new LoopMediaPlayer(getApplicationContext(), mFilename);
private String[] PERMISSIONS = {
        Manifest.permission.RECORD_AUDIO,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
};
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
        String t = (String) item.getTitle();
        switch (item.getItemId()) {
            case R.id.record:
                if(t.equals("record")) {
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
                if(t.equals("play")) {
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
            Log.d("FILENAME", this.mFilename);
//            this.mPlayer = new LoopMediaPlayer(this, this.mFilename);

        }
    }
    private void startPlay() {
        if(this.mFilename == null) {
            Log.d("START_PLAY","NO_FILENAME");
        }
        else if(mPlayer == null) {
            Log.d("START_PLAY","NO_PLAYER");
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
        if(mPlayer == null) {
            Log.d("STOP_PLAY", "NO_PLAYER");
            return;
        }
        if(mPlayer.isPlaying()){
            mPlayer.stop();
        }
    }
    private void startRecord(){
        if(this.mPlayer != null) {
            this.mPlayer.release();
            this.mPlayer = null;
        }
        else if(this.mFilename == null){
            Log.d("START_RECORD","NO_FILENAME");
        }
        else{
            this.mRecorder = new LoopMediaRecorder(this.mFilename);
            this.mRecorder.startRecord(this.mRecorder.isRecording());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for( String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED)
                Log.d("PERMISSIONS",permission + "IS GRANTED");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, PERMISSIONS, 4);
        String sdcard = Environment.getExternalStorageState();
        if( !sdcard.equals(Environment.MEDIA_MOUNTED)) {
            mFilename = Environment.getRootDirectory().getAbsolutePath();
        }
        else {
            mFilename = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        mFilename += "/audiorecordtest.mp3";
        final PadButton btn1 = (PadButton)findViewById(R.id.button1);
        final PadButton btn2 = (PadButton)findViewById(R.id.button2);
        final PadButton btn3 = (PadButton)findViewById(R.id.button3);
        final PadButton btn4 = (PadButton)findViewById(R.id.button4);
        final PadButton btn5 = (PadButton)findViewById(R.id.button5);
        final PadButton btn6 = (PadButton)findViewById(R.id.button6);
        PadButton btn7 = (PadButton)findViewById(R.id.button7);
        PadButton btn8 = (PadButton)findViewById(R.id.button8);
        PadButton btn9 = (PadButton)findViewById(R.id.button9);
        PadButton btn10 = (PadButton)findViewById(R.id.button10);
        PadButton btn11 = (PadButton)findViewById(R.id.button11);
        PadButton btn12 = (PadButton)findViewById(R.id.button12);
        PadButton btn13 = (PadButton)findViewById(R.id.button13);
        PadButton btn14 = (PadButton)findViewById(R.id.button14);
        PadButton btn15 = (PadButton)findViewById(R.id.button15);
        PadButton btn16 = (PadButton)findViewById(R.id.button16);
        PadButton btn17 = (PadButton)findViewById(R.id.button17);
        PadButton btn18 = (PadButton)findViewById(R.id.button18);

        btn1.addMediaPlayer(MediaPlayer.create(this, R.raw.kick_01));
        btn2.addMediaPlayer(MediaPlayer.create(this, R.raw.kick_02));
        btn3.addMediaPlayer(MediaPlayer.create(this, R.raw.kick_03));
        btn4.addMediaPlayer(MediaPlayer.create(this, R.raw.hat_01));
        btn5.addMediaPlayer(MediaPlayer.create(this, R.raw.hat_01));
        btn6.addMediaPlayer(MediaPlayer.create(this, R.raw.hat_01));


        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               btn1.startAudio();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn2.startAudio();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn3.startAudio();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn4.startAudio();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn5.startAudio();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn6.startAudio();
            }
        });


    }





}
