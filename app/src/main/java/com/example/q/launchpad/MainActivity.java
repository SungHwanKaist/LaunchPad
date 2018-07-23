package com.example.q.launchpad;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.SoundPool;
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
        else{
            Log.d("START_PLAY","STARTED");
//                this.mPlayer.create(this, this.mFilename);
            this.mPlayer = new LoopMediaPlayer(getApplicationContext(),this.mFilename);
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
//        mPlayer = new LoopMediaPlayer(getApplicationContext(),this.mFilename );
        Log.d("FILENAME_ON_CREATE",mFilename);

        final SoundPool beatpool = new SoundPool(24, AudioManager.STREAM_MUSIC, 0);
        final int beat1 = beatpool.load(this, R.raw.bass1, 1);
        final int beat2 = beatpool.load(this, R.raw.bass2, 1);
        final int beat3 = beatpool.load(this, R.raw.bass3, 1);
        final int beat4 = beatpool.load(this, R.raw.bell1, 1);
        final int beat5 = beatpool.load(this, R.raw.clap1, 1);
        final int beat6 = beatpool.load(this, R.raw.clap2, 1);
        final int beat7 = beatpool.load(this, R.raw.crush1, 1);
        final int beat8 = beatpool.load(this, R.raw.drum1, 1);
        final int beat9 = beatpool.load(this, R.raw.drum2, 1);
        final int beat10 = beatpool.load(this, R.raw.drum3, 1);
        final int beat11 = beatpool.load(this, R.raw.drum4, 1);
        final int beat12 = beatpool.load(this, R.raw.hihat1, 1);
        final int beat13 = beatpool.load(this, R.raw.hihat2, 1);
        final int beat14 = beatpool.load(this, R.raw.hihat3, 1);
        final int beat15 = beatpool.load(this, R.raw.hihat4, 1);
        final int beat16 = beatpool.load(this, R.raw.hihat5, 1);
        final int beat17 = beatpool.load(this, R.raw.kick1, 1);
        final int beat18 = beatpool.load(this, R.raw.kick2, 1);
        final int beat19 = beatpool.load(this, R.raw.kick3, 1);
        final int beat20 = beatpool.load(this, R.raw.kick4, 1);
        final int beat21 = beatpool.load(this, R.raw.kick5, 1);
        final int beat22 = beatpool.load(this, R.raw.snare1, 1);
        final int beat23 = beatpool.load(this, R.raw.snare2, 1);
        final int beat24 = beatpool.load(this, R.raw.snare3, 1);
        final int beat25 = beatpool.load(this, R.raw.sound1, 1);
        final int beat26 = beatpool.load(this, R.raw.sound2, 1);
        final int beat27 = beatpool.load(this, R.raw.sound3, 1);
        final int beat28 = beatpool.load(this, R.raw.sound4, 1);
        final int beat29 = beatpool.load(this, R.raw.sound5, 1);
        final int beat30 = beatpool.load(this, R.raw.sound6, 1);

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
        final PadButton btn25 = (PadButton)findViewById(R.id.button25);
        final PadButton btn26 = (PadButton)findViewById(R.id.button26);
        final PadButton btn27 = (PadButton)findViewById(R.id.button27);
        final PadButton btn28 = (PadButton)findViewById(R.id.button28);
        final PadButton btn29 = (PadButton)findViewById(R.id.button29);
        final PadButton btn30 = (PadButton)findViewById(R.id.button30);


        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat1, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat2, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat3, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat4, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat5, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat6, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat7, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat8, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat9, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat10, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat11, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat12, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat13, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat14, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat15, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat16, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat17, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat18, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat19, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat20, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat21, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat22, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat23, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat24, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat25, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat26, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat27, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat28, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat29, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });
        btn30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beatpool.play(beat30, 1.0F, 1.0F, 0, 0, 1.0F);
            }
        });

        final SoundPool pianopool = new SoundPool(36, AudioManager.STREAM_MUSIC, 0);
    }

}
