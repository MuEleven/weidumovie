package com.bw.movie.tools;

import com.bw.movie.app.Api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class OkHttpUtils {
    //单例模式
    private  static OkHttpUtils okHttpUtils = new OkHttpUtils();
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    private OkHttpUtils(){
        //拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder = request.newBuilder();
                        builder.addHeader("userId","18");
                        builder.addHeader("sessionId","15320748258726");
                        Request build = builder.build();
                        return chain.proceed(build);
                    }
                })
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://mobile.bwstudent.com/movieApi/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static OkHttpUtils getOkHttpUtils(){
        return okHttpUtils;
    }

    public Api api(){
        return retrofit.create(Api.class);
    }
}
