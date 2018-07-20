package com.example.q.launchpad;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import java.io.File;

/**
 * Created by jj0ng on 7/20/18.
 */

public class PadButton extends Button {
    private File sounds;
    public PadButton(Context context) {
        super(context);
    }

    public void addMp3(File file) {
        this.sounds = file;
    };

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);

    }

    @Override
    public boolean hasOnClickListeners() {
        return super.hasOnClickListeners();
    }


}
