package com.ugb.urban_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Brujula extends AppCompatActivity implements SensorEventListener {

    private ImageView compass;
    private static SensorManager manager;
    private static Sensor sensor;
    private float current_degree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brujula);

        compass = findViewById(R.id.compass);
        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        manager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
     float degree = Math.round(event.values[0]);
        RotateAnimation animation = new RotateAnimation(current_degree, -degree, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(120);
        animation.setFillAfter(true);
        compass.startAnimation(animation);
        current_degree = degree;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}