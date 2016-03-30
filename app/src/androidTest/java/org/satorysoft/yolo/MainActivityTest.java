package org.satorysoft.yolo;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.satorysoft.yolo.ui.fragments.SignUpFragment;

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

    public void test_launch_for_new_user() throws Exception {
        final MainActivity mainActivity = launchActivity("org.satorysoft.yolo", MainActivity.class, null);

        if(TextUtils.isEmpty(PreferenceManager.getDefaultSharedPreferences(mainActivity)
                .getString("USER_TOKEN", null))){
            FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, SignUpFragment.newInstance());
            transaction.commit();

            try {
                runTestOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mainActivity.getFragmentManager().executePendingTransactions();
                    }
                });
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            LinearLayout view = ButterKnife.findById(mainActivity, R.id.fragment_container);
            assertNotNull(view);

            RelativeLayout root = (RelativeLayout) view.findViewById(R.id.fragment_sign_up_root);
            assertNotNull(root);
        } else {
            fail();

            mainActivity.finish();
        }
    }
}
