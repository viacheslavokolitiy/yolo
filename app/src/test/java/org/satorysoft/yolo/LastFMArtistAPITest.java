package org.satorysoft.yolo;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.satorysoft.yolo.api.LastFMArtistAPI;
import org.satorysoft.yolo.api.model.artist.Artist;
import org.satorysoft.yolo.api.response.ArtistResponse;
import org.satorysoft.yolo.util.LastFmRequestInterceptor;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.observers.TestSubscriber;
import rx.plugins.RxJavaPlugins;
import rx.schedulers.Schedulers;

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
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
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

    @Test
    public void artist_api_should_return_artist_info() throws Exception {
        Assert.assertNotNull(retrofit);
        Assert.assertNotNull(artistAPI);

        final RxJavaPlugins rxJavaPlugins = RxJavaPlugins.getInstance();
        rxJavaPlugins.registerSchedulersHook(new RxJavaSchedulersHookExt(){
            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }
        });

        final Observable<ArtistResponse> artistObservable = artistAPI.artistInfo("Queen").asObservable();
        final TestSubscriber<ArtistResponse> testSubscriber = new TestSubscriber<>();

        artistObservable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<ArtistResponse> artistResponses = testSubscriber.getOnNextEvents();
        Assert.assertNotNull(artistResponses);
        Assert.assertTrue(artistResponses.size() > 0);

        Artist ar1 = artistResponses.get(0).getArtist();
        Artist ar2 = artistResponses.get(0).getArtist();
        assertTrue(ar1.equals(ar2));
        assertTrue(ar1.hashCode() == ar2.hashCode());

        assertNotNull(ar1.getArtistBio());
        assertNotNull(ar1.getMbid());
        assertNotNull(ar1.getArtistTags());
        assertNotNull(ar1.getArtistStats());
        assertNotNull(ar1.getArtistName());
        assertNotNull(ar1.getUrl());
        assertNotNull(ar1.getArtistImage());
        assertNotNull(ar1.isStreamable());
        assertNotNull(ar1.isOnTour());
        assertNotNull(ar1.getSimilarArtists());
    }
}
