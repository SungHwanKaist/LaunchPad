package com.example.q.launchpad;

/**
 * Created by jj0ng on 7/20/18.
 */

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import java.io.IOException;

public class LoopMediaPlayer {

    public static final String TAG = LoopMediaPlayer.class.getSimpleName();
    private Context mContext = null;
    private int mResId = 0;
    private int mCounter = 1;
    private String mPath = null;

    private MediaPlayer mCurrentPlayer = null;
    private MediaPlayer mNextPlayer = null;

    public static LoopMediaPlayer create(Context context, String path) {
        return new LoopMediaPlayer(context, path);
    }

    protected LoopMediaPlayer(Context context, String path) {
        this.mContext = context;
        mPath = path;
        try {
            mCurrentPlayer = new MediaPlayer();
            mCurrentPlayer.setDataSource(mPath);
            mCurrentPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mCurrentPlayer.start();
                }
            });
            mCurrentPlayer.prepareAsync();
            createNextMediaPlayerPath();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createNextMediaPlayerPath() {
        mNextPlayer = new MediaPlayer();
        try {
            mNextPlayer.setDataSource(mPath);
            mNextPlayer.setVolume(1,1);
            mNextPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mNextPlayer.seekTo(0);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mCurrentPlayer.setNextMediaPlayer(mNextPlayer);
                    }
                    mCurrentPlayer.setOnCompletionListener(onCompletionListener);
                }
            });
            mNextPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.release();
            mCurrentPlayer = mNextPlayer;

            createNextMediaPlayerPath();

            Log.d(TAG, String.format("Loop #%d", ++mCounter));
        }
    };

    public boolean isPlaying() throws IllegalStateException {
        if (mCurrentPlayer != null) {
            return mCurrentPlayer.isPlaying();
        } else {
            return false;
        }
    }

    public void setVolume(float leftVolume, float rightVolume) {
        if (mCurrentPlayer != null) {
            mCurrentPlayer.setVolume(leftVolume, rightVolume);
        } else {
            Log.d(TAG, "setVolume()");
        }

    }

    public void start() throws IllegalStateException {
        if (mCurrentPlayer != null) {
            Log.d(TAG, "start()");
            mCurrentPlayer.start();
        } else {
            Log.d(TAG, "start() | mCurrentPlayer is NULL");
        }

    }

    public void stop() throws IllegalStateException {
        if (mCurrentPlayer != null && mCurrentPlayer.isPlaying()) {
            Log.d(TAG, "stop()");
            mCurrentPlayer.stop();
        } else {
            Log.d(TAG, "stop() | mCurrentPlayer " +
                    "is NULL or not playing");
        }

    }

    public void pause() throws IllegalStateException {
        if (mCurrentPlayer != null && mCurrentPlayer.isPlaying()) {
            Log.d(TAG, "pause()");
            mCurrentPlayer.pause();
        } else {
            Log.d(TAG, "pause() | mCurrentPlayer " +
                    "is NULL or not playing");
        }

    }

    public void setWakeMode(Context c, int mode) {
        if (mCurrentPlayer != null) {
            mCurrentPlayer.setWakeMode(c, mode);
            Log.d(TAG, "setWakeMode() | ");
        } else {
            Log.d(TAG, "setWakeMode() | " +
                    "mCurrentPlayer is NULL");
        }
    }

    public void setAudioStreamType(int audioStreamType) {
        if (mCurrentPlayer != null) {
            mCurrentPlayer.setAudioStreamType(audioStreamType);
        } else {
            Log.d(TAG, "setAudioStreamType() | " +
                    "mCurrentPlayer is NULL");
        }
    }

    public void release() {
        Log.d(TAG, "release()");
        if (mCurrentPlayer != null)
            mCurrentPlayer.release();
        if (mNextPlayer != null)
            mNextPlayer.release();
    }

    public void reset() {
        if (mCurrentPlayer != null) {
            Log.d(TAG, "reset()");
            mCurrentPlayer.reset();
        } else {
            Log.d(TAG, "reset() | " +
                    "mCurrentPlayer is NULL");
        }

    }

}