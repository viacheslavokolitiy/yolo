package org.satorysoft.yolo;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

public class YoloAppTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return Instrumentation.newApplication(YoloMockApp.class, context);
    }
}
