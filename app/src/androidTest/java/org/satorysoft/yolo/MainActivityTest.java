package org.satorysoft.yolo;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;

import butterknife.ButterKnife;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void test_toolbar_should_exist() throws Exception {
        final Instrumentation instrumentation = getInstrumentation();
        Instrumentation.ActivityMonitor monitor = instrumentation.addMonitor(MainActivity.class.getName(),
                null, false);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(instrumentation.getTargetContext(), MainActivity.class.getName());

        instrumentation.startActivitySync(intent);

        Activity currentActivity = getInstrumentation().waitForMonitor(monitor);
        assertNotNull(currentActivity);

        Toolbar toolbar = ButterKnife.findById(currentActivity, R.id.toolbar);
        assertNotNull(toolbar);


        instrumentation.removeMonitor(monitor);
    }
}
