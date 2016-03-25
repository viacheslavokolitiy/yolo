package org.satorysoft.yolo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.satorysoft.yolo.util.LastFmRequestInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class APIUnitTest {

    @Mock
    App application;

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

    @Test
    public void test_retrofit_injection() throws Exception {
        when(application.getRetrofit())
                .then(new Answer<String>() {
                    @Override
                    public String answer(InvocationOnMock invocation) throws Throwable {
                        assertNotNull(application.getRetrofit().baseUrl());
                        return application.getRetrofit().baseUrl().encodedQuery();
                    }
                });
    }
}
