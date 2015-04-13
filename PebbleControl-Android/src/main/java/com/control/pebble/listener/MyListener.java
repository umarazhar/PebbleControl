package com.control.pebble.listener;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * Created by Lenovo-USER on 4/13/2015.
 */
public class MyListener implements SensorEventListener{

    public float accel_x, accel_y, accel_z;
    private float last_accel_x, last_accel_y, last_accel_z;

    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            last_accel_x = accel_x;
            last_accel_y = accel_y;
            last_accel_z = accel_z;
            accel_x = event.values[0];
            accel_y = event.values[1];
            accel_z = event.values[2];

//            Log.d("onSensorChanged", "Angle: " + Math.toDegrees(Math.atan2(accel_y, -accel_x)));

//            if (last_accel_x - accel_x > 1.5)
//                Log.d("onSensorChanged", "X: " + accel_x);
//            if (last_accel_y - accel_y > 1.5)
//                Log.d("onSensorChanged", "Y: " + accel_y);
//            if (last_accel_z - accel_z > 1.5)
//                Log.d("onSensorChanged", "Z: " + accel_z);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
