package org.satorysoft.yolo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.satorysoft.yolo.api.LastFMArtistAPI;
import org.satorysoft.yolo.util.LastFmRequestInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LastFMArtistAPITest {
    private LastFMArtistAPI artistAPI;
    private Retrofit retrofit;

    @Before
    public void before_init(){
        OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LastFmRequestInterceptor()).build();

        retrofit = new Retrofit
                .Builder()
                .baseUrl(App.ENDPOINT)
                .client(defaultHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        artistAPI = retrofit.create(LastFMArtistAPI.class);
    }

    @Test
    public void retrofit_should_be_initialized() throws Exception {
        Assert.assertNotNull(retrofit);
    }

    @Test
    public void artist_api_service_should_be_created() throws Exception {
        Assert.assertNotNull(artistAPI);
    }
}
