package com.example.q.launchpad;

import android.content.Context;
import android.media.MediaRecorder;
import android.util.Log;
import android.widget.Toast;

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
    public void stopRecord () {
            try {
                this.stop();
                this.reset();
                this.release();
                this.onRecord = false;
            } catch ( Exception e) {
                e.printStackTrace();
            }
    }
    public LoopMediaRecorder(String mFileName) {

        this.setAudioSource(AudioSource.MIC);
        this.setOutputFormat(OutputFormat.MPEG_4);
        this.setOutputFile(mFileName);
        this.setAudioEncoder(AudioEncoder.DEFAULT);
    }
    public void startRecord (){
            try {
                this.prepare();
                this.start();
                this.onRecord = true;
            } catch (IOException e) {
                Log.e(LOG_TAG, "prepare() failed");
                e.printStackTrace();
                this.onRecord = false;
            } catch (Exception e) {
                this.onRecord = false;
                e.printStackTrace();
            }
    }

}
