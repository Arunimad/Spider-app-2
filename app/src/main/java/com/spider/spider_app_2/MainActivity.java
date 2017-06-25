package com.spider.spider_app_2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements SensorEventListener{


    private SensorManager senman;
    private Sensor sen;
    TextView text;
    TextView text2;
    TextView text3;

    Uri notification;
    Ringtone r;










    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         text = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);

        senman = (SensorManager) getSystemService(SENSOR_SERVICE);
        sen = senman.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        r = RingtoneManager.getRingtone(getApplicationContext(),notification);









    }

    protected void onResume(){

        super.onResume();

         senman.registerListener(this,sen,SensorManager.SENSOR_DELAY_NORMAL);



    }

    protected void onPause(){
        super.onPause();
        senman.unregisterListener(this);
    }



    public void onSensorChanged(SensorEvent event){






        if(event.values[0] == 0){




            text.setText("Near");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            text.setText("Near");


            r.play();


















        }
        else {

            text.setText("Far");
            text3.setText("(If near,will be alarmed in 10_secs)");
            r.stop();
        }





    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
