package org.satorysoft.yolo;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.satorysoft.yolo.api.LastFMArtistAPI;
import org.satorysoft.yolo.api.model.artist.Artist;
import org.satorysoft.yolo.api.model.artist.ArtistSearchResult;
import org.satorysoft.yolo.api.response.ArtistResponse;
import org.satorysoft.yolo.api.response.ArtistSearchResponse;
import org.satorysoft.yolo.util.LastFmRequestInterceptor;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.observers.TestSubscriber;
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

        final RxAndroidPlugins rxAndroidPlugins = RxAndroidPlugins.getInstance();
        rxAndroidPlugins.registerSchedulersHook(new RxAndroidSchedulersHook(){
            @Override
            public Scheduler getMainThreadScheduler() {
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

        Artist artist = artistResponses.get(0).getArtist();

        Assert.assertNotNull(artist);

        assertNotNull(artist.getArtistBio());
        assertNotNull(artist.getMbid());
        assertNotNull(artist.getArtistTags());
        assertNotNull(artist.getArtistStats());
        assertNotNull(artist.getArtistName());
        assertNotNull(artist.getUrl());
        assertNotNull(artist.getArtistImage());
        assertNotNull(artist.isStreamable());
        assertNotNull(artist.isOnTour());
        assertNotNull(artist.getSimilarArtists());

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void artist_api_should_return_artist_matches() throws Exception {
        Assert.assertNotNull(retrofit);
        Assert.assertNotNull(artistAPI);

        final RxAndroidPlugins rxAndroidPlugins = RxAndroidPlugins.getInstance();
        rxAndroidPlugins.registerSchedulersHook(new RxAndroidSchedulersHook(){
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        final Observable<ArtistSearchResponse> artistResponseObservable =
                artistAPI.getArtistMatch("Queen").asObservable();
        final TestSubscriber<ArtistSearchResponse> subscriber = new TestSubscriber<>();

        artistResponseObservable.subscribe(subscriber);

        subscriber.assertNoErrors();

        List<ArtistSearchResponse> artistResponses = subscriber.getOnNextEvents();
        Assert.assertNotNull(artistResponses);
        Assert.assertTrue(artistResponses.size() > 0);

        ArtistSearchResult result = artistResponses.get(0).getArtistSearchResult();

        Assert.assertNotNull(result);

        assertNotNull(result.getArtistMatches());
        assertNotNull(result.getItemsPerPage());
        assertNotNull(result.getOpenSearchQuery());
        assertNotNull(result.getSearchAttribute());
        assertNotNull(result.getStartIndex());
        assertNotNull(result.getTotalResults());

        RxAndroidPlugins.getInstance().reset();
    }
}
