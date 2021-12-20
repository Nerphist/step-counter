

package kpi.year5.coursework.widget;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import kpi.year5.coursework.R;

public class WidgetConfig extends Activity implements OnClickListener {

    private static int widgetId;

    @Override
    protected void onPause() {
        super.onPause();
        WidgetUpdateService.enqueueUpdate(this);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        final Bundle extras = intent.getExtras();
        if (extras != null) {
            setContentView(R.layout.widgetconfig);

            widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);

            final Intent resultValue = new Intent();
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
            setResult(RESULT_OK, resultValue);
        } else {
            finish();
        }
    }

    @Override
    public void onClick(final View v) {
    }

}
