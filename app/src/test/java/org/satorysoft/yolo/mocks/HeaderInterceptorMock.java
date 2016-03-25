package org.satorysoft.yolo.mocks;

import java.io.IOException;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptorMock implements Interceptor {
    private static final int MAX_AGE = 60 * 60 * 24 * 7;
    private static final int MAX_STALE = 31536000;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("Cache-Control", String.format(Locale.ENGLISH, "max-age=%d,max-stale=%d", MAX_AGE, MAX_STALE))
                .addHeader("Connection", "keep-alive")
                .build();
        return chain.proceed(request);
    }
}
