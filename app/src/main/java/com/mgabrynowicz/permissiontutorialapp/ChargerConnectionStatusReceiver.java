package com.mgabrynowicz.permissiontutorialapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.widget.Toast;

/**
 * Created by RENT on 2016-11-28.
 */

public class ChargerConnectionStatusReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Intent batteryIntent = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        String action = intent.getAction();
        String chargerType = "";
        int chargerTypeInt =  batteryIntent != null ? batteryIntent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) : 0;

        switch (chargerTypeInt) {

            case BatteryManager.BATTERY_PLUGGED_AC:
                chargerType = "AC";
                break;

            case BatteryManager.BATTERY_PLUGGED_USB:
                chargerType = "USB";
                break;
        }


        if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, chargerType + " Charger connected", Toast.LENGTH_SHORT).show();
        }
        if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            Toast.makeText(context,"Charger discconnected", Toast.LENGTH_SHORT).show();
        }

    }
}
