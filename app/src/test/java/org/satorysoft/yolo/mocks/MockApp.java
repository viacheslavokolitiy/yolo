package org.satorysoft.yolo.mocks;

import android.test.mock.MockApplication;

import retrofit2.Retrofit;

/**
 * Created by vokol on 25.03.2016.
 */
public class MockApp extends MockApplication {
    public static final String ENDPOINT = "http://ws.audioscrobbler.com/2.0/";

    public Retrofit getMockedRetrofit(){
        return new Retrofit.Builder().baseUrl(ENDPOINT).build();
    }
}
