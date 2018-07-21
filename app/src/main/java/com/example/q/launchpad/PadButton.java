package com.example.q.launchpad;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.media.MediaPlayer;
import android.widget.Button;

import java.io.File;

/**
 * Created by jj0ng on 7/20/18.
 */

public class PadButton extends Button {
    private MediaPlayer mp;
    Context context;
    public PadButton(Context context) {
        super(context);
        this.context = context;
    }

    public PadButton(Context context, AttributeSet atts){
        super(context, atts);
        this.context = context;
    }

    public void addMediaPlayer(MediaPlayer mp) {
        this.mp = mp;
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }

    @Override
    public boolean hasOnClickListeners() {
        return super.hasOnClickListeners();
    }

    public void startAudio(){
        this.mp.start();
    }


}