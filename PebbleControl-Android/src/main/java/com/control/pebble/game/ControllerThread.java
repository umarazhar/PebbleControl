package com.control.pebble.game;

import android.util.Log;

import com.control.pebble.listener.MyListener;

/**
 * Created by Lenovo-USER on 4/13/2015.
 */
public class ControllerThread extends Thread {

    private MyListener myListener;

    private boolean running = false;

    public ControllerThread(MyListener myListener) {
        this.myListener = myListener;
    }

    public void run() {
        running = true;

        while (running) {

            Log.d("ControllerThread", "PhoneAngle: " + Math.toDegrees(Math.atan2(myListener.accel_y, -myListener.accel_x)));
            delay(20);
        }
    }

    private void delay(long milli) {
        try {
            Thread.currentThread().sleep(milli);
        } catch (InterruptedException e) {

        }
    }
}
