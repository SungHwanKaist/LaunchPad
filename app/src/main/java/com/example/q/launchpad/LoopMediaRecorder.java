package com.example.q.launchpad;

import android.media.MediaRecorder;
import android.util.Log;

import java.io.IOException;

/**
 * Created by jj0ng on 7/20/18.
 */

public class LoopMediaRecorder extends MediaRecorder {
    private boolean onRecord = false;
    private String LOG_TAG = "LOOP_MEDIA_RECORDER";

    public boolean isRecording() {
        return this.onRecord;
    }
    public void stopRecord (boolean st) {
        if(st) {
            this.onRecord = !st;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        LoopMediaRecorder.this.stop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

            this.release();
        }
        else{
            this.onRecord = st;
        }
    }
    public LoopMediaRecorder(String mFileName) {

        this.setAudioSource(AudioSource.MIC);
        this.setOutputFormat(OutputFormat.MPEG_2_TS);
        this.setOutputFile(mFileName);
        this.setAudioEncoder(AudioEncoder.AMR_NB);
    }
    public void startRecord (boolean st){
        if(!st) {
            this.onRecord = !st;
            try {
                this.prepare();
            } catch (IOException e) {
                Log.e(LOG_TAG, "prepare() failed");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        LoopMediaRecorder.this.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
        else {
            this.onRecord = st;
        }
    }

}
