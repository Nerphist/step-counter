

package kpi.year5.coursework.widget;

import android.content.Intent;

import com.google.android.apps.dashclock.api.DashClockExtension;
import com.google.android.apps.dashclock.api.ExtensionData;

import kpi.year5.coursework.Database;
import kpi.year5.coursework.R;
import kpi.year5.coursework.ui.Activity_Main;
import kpi.year5.coursework.ui.Fragment_Overview;
import kpi.year5.coursework.util.Util;

/**
 * Class for providing a DashClock (https://code.google.com/p/dashclock)
 * extension
 */
public class DashClock extends DashClockExtension {

    @Override
    protected void onUpdateData(int reason) {
        ExtensionData data = new ExtensionData();
        Database db = Database.getInstance(this);
        int steps = Math.max(db.getCurrentSteps() + db.getSteps(Util.getToday()), 0);
        data.visible(true).status(Fragment_Overview.formatter.format(steps))
                .icon(R.drawable.ic_dashclock)
                .clickIntent(new Intent(DashClock.this, Activity_Main.class));
        db.close();
        publishUpdate(data);
    }

}
