package com.android.myapplicationdev.knowyourfacts;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button btnReadLater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReadLater = (Button) findViewById(R.id.btnReadLater);
        vPager = (ViewPager) findViewById(R.id.viewpager1);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());
        al.add(new Frag3());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);

        btnReadLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 5);

                Intent intent = new Intent(MainActivity.this, ScheduledNotificationReceiver.class);

                //Get activity from broadcast receiver
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 777, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);

            }
        });
    }
        public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.next) {
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem() < max-1){
                int nextPage = vPager.getCurrentItem() + 1;
                vPager.setCurrentItem(nextPage, true);
            }

            return true;
        }
        else if (id == R.id.previous){
            if (vPager.getCurrentItem() > 0){
                int previousPage = vPager.getCurrentItem() - 1;
                vPager.setCurrentItem(previousPage, true);
            }
            return true;
        }
        else {
            Random randomNo = new Random();
            int randomPage = randomNo.nextInt(vPager.getChildCount());
            vPager.setCurrentItem(randomPage, true);
        }

        return super.onOptionsItemSelected(item);
    }



}



