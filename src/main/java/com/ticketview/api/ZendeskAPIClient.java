package com.ticketview.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZendeskAPIClient {
	
	private static final String BASE_URL  = "https://zendeskcodingchallenge2996.zendesk.com";
	private static final String token = "Basic c3NoYWgxMDZAdW5jYy5lZHUvdG9rZW46WGltczVoQ2VIT0F6VzRST3BGSlptNkdGa2Y2Ulh3Qm96M205TnNMZg==";
	private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

	private static Retrofit retrofit = builder.build();

	private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	
	private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC);
	
	public static <T> T createService(Class<T> apiClass) {
		httpClient.interceptors().clear();
		httpClient.addInterceptor(chain -> {
			Request original = chain.request();
			Request.Builder builder1 = original.newBuilder().header("Authorization", token).header("Content-Type", "application/json");
			Request request = builder1.build();
			return chain.proceed(request);
		});
		
		builder.client(httpClient.build());
		retrofit = builder.build();
		
		return retrofit.create(apiClass);
	}
	
	
	

}
