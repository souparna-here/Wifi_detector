package app.com.wifi_detector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Souparna on 09-06-2017.
 */

public class MyBroadcast extends BroadcastReceiver {
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMan.getActiveNetworkInfo();
        if (netInfo != null && netInfo.getType() == ConnectivityManager.TYPE_WIFI){
            Log.d("WifiReceiver", "Have Wifi Connection");
            Toast.makeText(context, "wifi connected", Toast.LENGTH_SHORT).show();
            mp = MediaPlayer.create(context, R.raw.play3);
            mp.start();
        }
        else {
            Log.d("WifiReceiver", "Don't have Wifi Connection");
            Toast.makeText(context, "wifi Disconnected", Toast.LENGTH_SHORT).show();
            mp = MediaPlayer.create(context, R.raw.play4);
            mp.start();
        }
    }
}
