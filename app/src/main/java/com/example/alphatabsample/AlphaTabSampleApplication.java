package com.example.alphatabsample;

import android.app.Application;

public class AlphaTabSampleApplication extends Application {
    private int alphaTabPosition;

    public AlphaTabSampleApplication() {
        setAlphaTabPosition(0);
    }

    public int getAlphaTabPosition() {
        return alphaTabPosition;
    }

    public void setAlphaTabPosition(int alphaTabPosition) {
        this.alphaTabPosition = alphaTabPosition;
    }
}
