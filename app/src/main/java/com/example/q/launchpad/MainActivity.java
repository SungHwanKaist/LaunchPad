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
        btn3.addMediaPlayer(MediaPlayer.create(this, R.raw.bell1));
        btn4.addMediaPlayer(MediaPlayer.create(this, R.raw.hihat1));
        btn5.addMediaPlayer(MediaPlayer.create(this, R.raw.hihat2));
        btn6.addMediaPlayer(MediaPlayer.create(this, R.raw.hihat3));
        btn7.addMediaPlayer(MediaPlayer.create(this, R.raw.snare1));
        btn8.addMediaPlayer(MediaPlayer.create(this, R.raw.snare2));
        btn9.addMediaPlayer(MediaPlayer.create(this, R.raw.snare3));
        btn10.addMediaPlayer(MediaPlayer.create(this, R.raw.kick1));
        btn11.addMediaPlayer(MediaPlayer.create(this, R.raw.kick2));
        btn12.addMediaPlayer(MediaPlayer.create(this, R.raw.kick3));
        btn13.addMediaPlayer(MediaPlayer.create(this, R.raw.drum1));
        btn14.addMediaPlayer(MediaPlayer.create(this, R.raw.drum2));
        btn15.addMediaPlayer(MediaPlayer.create(this, R.raw.drum3));
        btn16.addMediaPlayer(MediaPlayer.create(this, R.raw.clap1));
        btn17.addMediaPlayer(MediaPlayer.create(this, R.raw.clap2));
        btn18.addMediaPlayer(MediaPlayer.create(this, R.raw.sound1));

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
                btn14.startAudio();
            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn15.startAudio();
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn16.startAudio();
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn17.startAudio();
            }
        });
        btn23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn18.startAudio();
            }
        });
        btn24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btn18.startAudio();
            }
        });
    }

}
