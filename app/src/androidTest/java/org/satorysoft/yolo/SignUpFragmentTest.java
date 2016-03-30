package org.satorysoft.yolo;

import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Assert;
import org.junit.Before;
import org.satorysoft.yolo.ui.fragments.SignUpFragment;

public class SignUpFragmentTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private SignUpFragment signUpFragment;

    public SignUpFragmentTest() {
        super(MainActivity.class);
    }

    @Override
    @Before
    protected void setUp() throws Exception {
        super.setUp();
        signUpFragment = SignUpFragment.newInstance();
        try {
            runTestOnUiThread(new Runnable() {
                @Override
                public void run() {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_container, signUpFragment, null).commit();
                    getActivity().getSupportFragmentManager().executePendingTransactions();
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void test_actionbar_should_not_be_null() throws Exception {
        Assert.assertNotNull(getActivity());

        try {
            runTestOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
                    Assert.assertNotNull(toolbar);
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void test_actionbar_title_should_be_empty() throws Exception {
        Assert.assertNotNull(getActivity());

        try {
            runTestOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

                    Assert.assertNotNull(toolbar);

                    String title = toolbar.getTitle().toString();

                    Assert.assertEquals(getActivity().getString(R.string.empty), title);
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
