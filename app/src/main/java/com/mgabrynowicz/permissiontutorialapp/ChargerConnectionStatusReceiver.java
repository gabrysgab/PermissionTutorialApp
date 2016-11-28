package com.mgabrynowicz.permissiontutorialapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

/**
 * Created by RENT on 2016-11-28.
 */

public class ChargerConnectionStatusReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String chargerType = "";
        int chargerTypeInt = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        String debug = String.valueOf(chargerTypeInt);

        if (chargerTypeInt == BatteryManager.BATTERY_PLUGGED_AC) {
            chargerType = "AC";
        }
        if (chargerTypeInt == BatteryManager.BATTERY_PLUGGED_USB) {
            chargerType = "USB";
        }

        if (action.equals(Intent.ACTION_POWER_CONNECTED)) {


            Toast.makeText(context, chargerType + debug +  " Charger connected", Toast.LENGTH_SHORT).show();


        }

        if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {

            Toast.makeText(context, chargerType + debug + " Charger discconnected", Toast.LENGTH_SHORT).show();
        }

    }
}
