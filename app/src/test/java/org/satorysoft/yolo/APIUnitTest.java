package org.satorysoft.yolo;

import org.junit.Test;
import org.satorysoft.yolo.mocks.MockApp;
import org.satorysoft.yolo.mocks.MockService;
import org.satorysoft.yolo.util.LastFmRequestInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import static org.junit.Assert.assertNotNull;

public class APIUnitTest {

    @Test
    public void test_retrofit_adapter_exist() throws Exception {
        MockApp mockApp = new MockApp();
        assertNotNull(mockApp.getMockedRetrofit());
    }

    @Test
    public void test_rest_factory_creation() throws Exception {
        MockApp mockApp = new MockApp();

        Retrofit retrofit = mockApp.getMockedRetrofit();
        assertNotNull(retrofit);

        MockService service = retrofit.create(MockService.class);

        assertNotNull(service);
    }

    @Test
    public void test_request_interceptor() throws Exception {
        OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LastFmRequestInterceptor()).build();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(App.ENDPOINT)
                .client(defaultHttpClient).build();

        assertNotNull(retrofit);
    }
}
