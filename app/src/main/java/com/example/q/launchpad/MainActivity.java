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
//    private MediaPlayer mPlayer = null;
    private LoopMediaRecorder mRecorder = null;
    private Menu menu;
//    private LoopMediaRecorder mRecorder = new LoopMediaRecorder(mFilename);
//    private LoopMediaPlayer
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
        MenuItem item = menu.findItem(R.id.stop_record);
        MenuItem item2 = menu.findItem(R.id.stop_play);
        item.setVisible(false);
        item2.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        this.menu = menu;
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        String t = (String) item.getTitle();
        switch (item.getItemId()) {
            case R.id.record:
                    startRecord();
                    item.setVisible(false);
                    MenuItem it = this.menu.findItem(R.id.stop_record);
                    it.setVisible(true);
                return true;
            case R.id.stop_record:
                    stopRecord();
                    item.setVisible(false);
                    MenuItem it2 = this.menu.findItem(R.id.record);
                    it2.setVisible(true);
                    return true;
            case R.id.play:
                    startPlay();
                    item.setVisible(false);
                    MenuItem it3 = this.menu.findItem(R.id.stop_play);
                    it3.setVisible(true);
                    return true;
            case R.id.stop_play:
                    stopPlay();
                    item.setVisible(false);
                    MenuItem it4 = this.menu.findItem(R.id.play);
                    it4.setVisible(true);
                    return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void stopRecord() {
        if(this.mRecorder == null) {
            Log.d("STOP_RECORD", "NO_RECORDER");
        }
        else if(this.mRecorder.isRecording()){
            this.mRecorder.stopRecord();
            Log.d("FILENAME", this.mFilename);
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
            if(mPlayer.isPlaying()) {
                Log.d("START_PLAY","ALREADY_STARTED");
            }
            else{
                Log.d("START_PLAY","STARTED");
                this.mPlayer.create(this, this.mFilename);
            }
        }
    }
    private void stopPlay() {
        if(mPlayer == null) {
            Log.d("STOP_PLAY", "NO_PLAYER");
            return;
        }
//        if(mPlayer.isPlaying()){
            mPlayer.stop();
            mPlayer.reset();
            mPlayer.release();
//        }
//        else {
//            Log.d("STOP_PLAY", "NOT_ON_PLAYING");
//        }
    }
    private void startRecord(){
//        if(this.mPlayer != null) {
//            this.mPlayer.reset();
//            this.mPlayer.release();
//            this.mPlayer = null;
//        }
        if(this.mFilename == null){
            Log.d("START_RECORD","NO_FILENAME");
        }
        else{
            this.mRecorder = new LoopMediaRecorder(this.mFilename);
            if(!this.mRecorder.isRecording()) {
                this.mRecorder.startRecord();
                Log.d("START_RECORD","STARTED");
            }
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
<<<<<<< HEAD
        mPlayer = new LoopMediaPlayer(getApplicationContext(),this.mFilename );
        mPlayer.stop();
        mPlayer.reset();
        mPlayer.release();
        Log.d("FILENAME_ON_CREATE",mFilename);
=======



>>>>>>> bc1e5469c686dff39c5d71491f0f76a6219b05fb
        final PadButton btn1 = (PadButton)findViewById(R.id.button1);
        final PadButton btn2 = (PadButton)findViewById(R.id.button2);
        final PadButton btn3 = (PadButton)findViewById(R.id.button3);
        final PadButton btn4 = (PadButton)findViewById(R.id.button4);
        final PadButton btn5 = (PadButton)findViewById(R.id.button5);
        final PadButton btn6 = (PadButton)findViewById(R.id.button6);
        final PadButton btn7 = (PadButton)findViewById(R.id.button7);
        final PadButton btn8 = (PadButton)findViewById(R.id.button8);
        final PadButton btn9 = (PadButton)findViewById(R.id.button9);
        final PadButton btn10 = (PadButton)findViewById(R.id.button10);
        final PadButton btn11 = (PadButton)findViewById(R.id.button11);
        final PadButton btn12 = (PadButton)findViewById(R.id.button12);
        final PadButton btn13 = (PadButton)findViewById(R.id.button13);
        final PadButton btn14 = (PadButton)findViewById(R.id.button14);
        final PadButton btn15 = (PadButton)findViewById(R.id.button15);
        final PadButton btn16 = (PadButton)findViewById(R.id.button16);
        final PadButton btn17 = (PadButton)findViewById(R.id.button17);
        final PadButton btn18 = (PadButton)findViewById(R.id.button18);
        final PadButton btn19 = (PadButton)findViewById(R.id.button19);
        final PadButton btn20 = (PadButton)findViewById(R.id.button20);
        final PadButton btn21 = (PadButton)findViewById(R.id.button21);
        final PadButton btn22 = (PadButton)findViewById(R.id.button22);
        final PadButton btn23 = (PadButton)findViewById(R.id.button23);
        final PadButton btn24 = (PadButton)findViewById(R.id.button24);



        btn1.addMediaPlayer(MediaPlayer.create(this, R.raw.bass1));
        btn2.addMediaPlayer(MediaPlayer.create(this, R.raw.bass2));
        btn3.addMediaPlayer(MediaPlayer.create(this, R.raw.bass3));
        btn4.addMediaPlayer(MediaPlayer.create(this, R.raw.bell1));
        btn5.addMediaPlayer(MediaPlayer.create(this, R.raw.hihat1));
        btn6.addMediaPlayer(MediaPlayer.create(this, R.raw.hihat2));
        btn7.addMediaPlayer(MediaPlayer.create(this, R.raw.hihat3));
        btn8.addMediaPlayer(MediaPlayer.create(this, R.raw.hihat4));
        btn9.addMediaPlayer(MediaPlayer.create(this, R.raw.hihat5));
        btn10.addMediaPlayer(MediaPlayer.create(this, R.raw.kick1));
        btn11.addMediaPlayer(MediaPlayer.create(this, R.raw.kick2));
        btn12.addMediaPlayer(MediaPlayer.create(this, R.raw.kick3));
        btn13.addMediaPlayer(MediaPlayer.create(this, R.raw.kick4));
        btn14.addMediaPlayer(MediaPlayer.create(this, R.raw.drum1));
        btn15.addMediaPlayer(MediaPlayer.create(this, R.raw.drum2));
        btn16.addMediaPlayer(MediaPlayer.create(this, R.raw.drum3));
        btn17.addMediaPlayer(MediaPlayer.create(this, R.raw.clap1));
        btn18.addMediaPlayer(MediaPlayer.create(this, R.raw.clap2));
        btn19.addMediaPlayer(MediaPlayer.create(this, R.raw.sound1));
        btn20.addMediaPlayer(MediaPlayer.create(this, R.raw.sound2));
        btn21.addMediaPlayer(MediaPlayer.create(this, R.raw.sound3));
        btn22.addMediaPlayer(MediaPlayer.create(this, R.raw.sound4));
        btn23.addMediaPlayer(MediaPlayer.create(this, R.raw.sound5));
        btn24.addMediaPlayer(MediaPlayer.create(this, R.raw.sound6));

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
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn7.startAudio();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn8.startAudio();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn9.startAudio();
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn10.startAudio();
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn11.startAudio();
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn12.startAudio();
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn13.startAudio();
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn14.startAudio();
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn15.startAudio();
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn16.startAudio();
            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn17.startAudio();
            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn18.startAudio();
            }
        });
        btn19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn19.startAudio();
            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn20.startAudio();
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn21.startAudio();
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn22.startAudio();
            }
        });
        btn23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn23.startAudio();
            }
        });
        btn24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn24.startAudio();
            }
        });
    }

}
