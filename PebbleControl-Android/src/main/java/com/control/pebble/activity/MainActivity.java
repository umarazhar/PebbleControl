package com.control.pebble.activity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.control.pebble.game.ControllerThread;
import com.control.pebble.listener.MyListener;

/**
 * Created by Lenovo-USER on 4/13/2015.
 */
public class MainActivity extends Activity {

    private MyListener myListener;

    private ControllerThread controller;

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myListener = new MyListener();

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(myListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);

        controller = new ControllerThread(myListener);
        controller.start();
    }
}
