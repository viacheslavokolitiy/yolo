package org.satorysoft.yolo;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.satorysoft.yolo.api.LastFMArtistAPI;
import org.satorysoft.yolo.util.LastFmRequestInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@RunWith(MockitoJUnitRunner.class)
public class LastFMArtistAPITest extends TestCase {
    private LastFMArtistAPI artistAPI;
    private Retrofit retrofit;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Before
    public void beforeEach(){
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
