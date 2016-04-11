package org.satorysoft.yolo;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.satorysoft.yolo.api.LastFMArtistAPI;
import org.satorysoft.yolo.api.model.Link;
import org.satorysoft.yolo.api.model.Tag;
import org.satorysoft.yolo.api.model.artist.Artist;
import org.satorysoft.yolo.api.model.artist.ArtistBio;
import org.satorysoft.yolo.api.model.artist.ArtistImage;
import org.satorysoft.yolo.api.model.artist.ArtistSearchResult;
import org.satorysoft.yolo.api.model.artist.ArtistStats;
import org.satorysoft.yolo.api.model.artist.SimilarArtist;
import org.satorysoft.yolo.api.model.search.ArtistMatches;
import org.satorysoft.yolo.api.model.search.Query;
import org.satorysoft.yolo.api.model.search.SearchAttribute;
import org.satorysoft.yolo.api.response.ArtistResponse;
import org.satorysoft.yolo.api.response.ArtistSearchResponse;
import org.satorysoft.yolo.util.LastFmRequestInterceptor;

import java.util.ArrayList;
import java.util.List;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
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
public class ModelTest extends TestCase {
    Artist artist;
    private Retrofit retrofit;
    private LastFMArtistAPI artistAPI;
    private ArtistSearchResult artistSearchResult;

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

        this.artist = new Artist();
        this.artistSearchResult = new ArtistSearchResult();
    }

    @Test
    public void artist() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistModel();

        assertNotNull(this.artist.getArtistBio());
        assertNotNull(this.artist.getArtistName());
        assertNotNull(this.artist.getMbid());
        assertNotNull(this.artist.getUrl());
        assertNotNull(this.artist.getArtistImage());
        assertNotNull(this.artist.isStreamable());
        assertNotNull(this.artist.isOnTour());
        assertNotNull(this.artist.getArtistStats());
        assertNotNull(this.artist.getSimilarArtists());
        assertNotNull(this.artist.getArtistTags());

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void artist_bio_should_be_valid() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistModel();

        ArtistBio artistBio = this.artist.getArtistBio();

        assertNotNull(artistBio);

        ArtistBio mockedBio = new ArtistBio();
        mockedBio.setBioLinks(artistBio.getBioLinks());
        mockedBio.setContent(artistBio.getContent());
        mockedBio.setPublished(artistBio.getPublished());
        mockedBio.setSummary(artistBio.getSummary());

        assertNotNull(mockedBio.getBioLinks());
        assertNotNull(mockedBio.getContent());
        assertNotNull(mockedBio.getPublished());
        assertNotNull(mockedBio.getSummary());

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void artist_matches_should_be_valid() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistSearchResult();

        ArtistMatches artistMatches = this.artistSearchResult.getArtistMatches();
        assertNotNull(artistMatches);

        ArtistMatches mockedMatch = new ArtistMatches();
        mockedMatch.setArtist(artistMatches.getArtist());

        assertNotNull(mockedMatch.getArtist());

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void artist_search_query_should_be_valid() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistSearchResult();

        Query query = this.artistSearchResult.getOpenSearchQuery();
        assertNotNull(query);

        Query mocked = new Query();
        mocked.setQueryRole(query.getQueryRole());
        mocked.setQuerySearchTerms(query.getQuerySearchTerms());
        mocked.setQueryText(query.getQueryText());
        mocked.setStartPage(query.getStartPage());

        assertNotNull(mocked.getQueryRole());
        assertNotNull(mocked.getQuerySearchTerms());
        assertNotNull(mocked.getQueryText());
        assertNotNull(mocked.getStartPage());
    }

    @Test
    public void artist_search_result_should_be_valid() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistSearchResult();

        assertNotNull(this.artistSearchResult.getStartIndex());
        assertNotNull(this.artistSearchResult.getTotalResults());
        assertNotNull(this.artistSearchResult.getSearchAttribute());
        assertNotNull(this.artistSearchResult.getOpenSearchQuery());
        assertNotNull(this.artistSearchResult.getArtistMatches());
        assertNotNull(this.artistSearchResult.getItemsPerPage());

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void artist_stats_should_be_valid() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistModel();

        ArtistStats stats = this.artist.getArtistStats();
        assertNotNull(stats);

        ArtistStats mockedStats = new ArtistStats();
        mockedStats.setListeners(stats.getListeners());
        mockedStats.setPlayCount(stats.getPlayCount());

        assertNotNull(mockedStats.getListeners());
        assertNotNull(mockedStats.getPlayCount());

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void similar_artists_should_be_valid() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistModel();

        SimilarArtist similarArtist = this.artist.getSimilarArtists();
        assertNotNull(similarArtist);

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void artist_image_model_should_be_valid() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistModel();

        ArtistImage[] artistImage = this.artist.getArtistImage();

        assertNotNull(artistImage);

        List<ArtistImage> images = new ArrayList<>();

        for(ArtistImage image : artistImage){
            ArtistImage mockedImage = new ArtistImage();
            mockedImage.setText(image.getText());
            mockedImage.setImageSize(image.getImageSize());
            images.add(mockedImage);
        }

        for(ArtistImage artistImages : images){
            assertNotNull(artistImages.getText());
            assertNotNull(artistImages.getImageSize());
        }

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void search_attribute_should_be_valid() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistSearchResult();

        SearchAttribute searchAttribute = this.artistSearchResult.getSearchAttribute();
        assertNotNull(searchAttribute);

        SearchAttribute mockedAttribute = new SearchAttribute();
        mockedAttribute.setSearchFor(searchAttribute.getSearchFor());

        assertNotNull(mockedAttribute.getSearchFor());

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void artist_link_should_not_be_null() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistModel();

        Link link = this.artist.getArtistBio().getBioLinks();
        assertNotNull(link);

        Link mocked = new Link();
        mocked.setLinkText(link.getLinkText());
        mocked.setRef(link.getRef());
        mocked.setRelation(link.getRelation());

        assertNotNull(mocked);

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void artist_model_equals_test() throws Exception {
        Artist artist = getAndSetArtistModel();
        EqualsVerifier
                .forClass(artist.getClass())
                .suppress(Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS)
                .verify();
    }

    @Test
    public void artist_image_equals_test() throws Exception {
        ArtistImage[] artistImage = getAndSetArtistModel().getArtistImage();

        for(ArtistImage image : artistImage){
            EqualsVerifier
                    .forClass(image.getClass())
                    .suppress(Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS)
                    .verify();
        }
    }

    @Test
    public void artist_search_result_equals_test() throws Exception {
        ArtistSearchResult searchResult = getAndSetArtistSearchResult();
        EqualsVerifier
                .forClass(searchResult.getClass())
                .suppress(Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS)
                .verify();
    }

    @Test
    public void link_equals_test() throws Exception {
        Link link = getAndSetArtistModel().getArtistBio().getBioLinks();
        EqualsVerifier
                .forClass(link.getClass())
                .suppress(Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS)
                .verify();
    }

    @Test
    public void artist_tags_should_not_be_null() throws Exception {
        assertNotNull(retrofit);
        assertNotNull(artistAPI);

        getAndSetArtistModel();

        Tag tag = this.artist.getArtistTags();
        assertNotNull(tag);

        Tag mocked = new Tag();
        mocked.setTagName(tag.getTagName());
        mocked.setTagUrl(tag.getTagUrl());

        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void stringify_artist_model_test() throws Exception {
        Artist artist = getAndSetArtistModel();
        assertTrue(artist.toString().contains("Artist"));
    }

    @Test
    public void stringify_artist_search_result_test() throws Exception {
        ArtistSearchResult searchResult = getAndSetArtistSearchResult();
        assertTrue(searchResult.toString().contains("ArtistSearchResult"));
    }

    private ArtistSearchResult getAndSetArtistSearchResult(){
        final RxAndroidPlugins rxAndroidPlugins = RxAndroidPlugins.getInstance();
        rxAndroidPlugins.registerSchedulersHook(new RxAndroidSchedulersHook(){
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        final Observable<ArtistSearchResponse> artistObservable = artistAPI
                .getArtistMatch("Queen")
                .asObservable();

        final TestSubscriber<ArtistSearchResponse> testSubscriber = new TestSubscriber<>();

        artistObservable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();

        List<ArtistSearchResponse> artistResponses = testSubscriber.getOnNextEvents();

        ArtistSearchResponse searchResponse = artistResponses.get(0);
        EqualsVerifier
                .forClass(searchResponse.getClass())
                .suppress(Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS)
                .verify();

        assertTrue(searchResponse.toString().contains("ArtistSearchResponse"));

        Assert.assertNotNull(artistResponses);
        Assert.assertTrue(artistResponses.size() > 0);

        ArtistSearchResult searchResult = artistResponses.get(0).getArtistSearchResult();
        assertNotNull(searchResult);

        this.artistSearchResult.setArtistMatches(searchResult.getArtistMatches());
        this.artistSearchResult.setItemsPerPage(searchResult.getItemsPerPage());
        this.artistSearchResult.setOpenSearchQuery(searchResult.getOpenSearchQuery());
        this.artistSearchResult.setSearchAttribute(searchResult.getSearchAttribute());
        this.artistSearchResult.setStartIndex(searchResult.getStartIndex());
        this.artistSearchResult.setTotalResults(searchResult.getTotalResults());

        RxAndroidPlugins.getInstance().reset();

        return artistSearchResult;
    }

    private Artist getAndSetArtistModel() {
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

        ArtistResponse response = artistResponses.get(0);
        EqualsVerifier
                .forClass(response.getClass())
                .suppress(Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS)
                .verify();

        assertTrue(response.toString().contains("ArtistResponse"));

        Assert.assertNotNull(artistResponses);
        Assert.assertTrue(artistResponses.size() > 0);

        Artist lastFMArtist = artistResponses.get(0).getArtist();

        Assert.assertNotNull(lastFMArtist);

        this.artist.setArtistBio(lastFMArtist.getArtistBio());
        this.artist.setArtistName(lastFMArtist.getArtistName());
        this.artist.setMbid(lastFMArtist.getMbid());
        this.artist.setUrl(lastFMArtist.getUrl());
        this.artist.setArtistImage(lastFMArtist.getArtistImage());
        this.artist.setStreamable(lastFMArtist.isStreamable());
        this.artist.setOnTour(lastFMArtist.isOnTour());
        this.artist.setArtistStats(lastFMArtist.getArtistStats());
        this.artist.setSimilarArtists(lastFMArtist.getSimilarArtists());
        this.artist.setArtistTags(lastFMArtist.getArtistTags());

        RxAndroidPlugins.getInstance().reset();

        return artist;
    }
}
