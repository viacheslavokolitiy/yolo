package org.satorysoft.yolo;

import org.junit.Test;

import retrofit2.Retrofit;

import static org.junit.Assert.*;

public class APIUnitTest {

    @Test
    public void test_retrofit_adapter_exist() throws Exception {
        App app = App.getAppInstance();
        assertNotNull(app);

        Retrofit retrofit = app.getRetrofit();
        assertNotNull(retrofit);
    }
}
