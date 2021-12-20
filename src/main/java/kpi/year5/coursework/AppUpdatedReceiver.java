

package kpi.year5.coursework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import kpi.year5.coursework.util.API26Wrapper;
import kpi.year5.coursework.util.Logger;

public class AppUpdatedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        if (BuildConfig.DEBUG) Logger.log("app updated");
        if (Build.VERSION.SDK_INT >= 26) {
            API26Wrapper.startForegroundService(context, new Intent(context, StepsSensorListener.class));
        } else {
            context.startService(new Intent(context, StepsSensorListener.class));
        }
    }

}
