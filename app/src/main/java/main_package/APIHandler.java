package main_package;

import android.content.Context;

import androidx.annotation.Nullable;

import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.yuumigg.BuildConfig;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import com.codepath.oauth.OAuthBaseClient;
import com.github.scribejava.core.builder.api.BaseApi;

public class APIHandler extends OAuthBaseClient {
    public static final String CONSUMER_KEY = "RGAPI-59197c22-0db6-442e-ae02-78ca10438dec";
    ApiConfig config = new ApiConfig().setKey(CONSUMER_KEY);
    RiotApi api = new RiotApi(config);

    SummonerObject[] summoners = SummonerStorage.getInstance().get();

    public static final String BASE_URL = "https://na1.api.riotgames.com/lol/"; // Change this, base API URL

    public APIHandler(Context c, BaseApi apiInstance, @Nullable String consumerUrl, @Nullable String consumerKey, @Nullable String consumerSecret, @Nullable String scope, @Nullable String callbackUrl) {
        super(c, apiInstance, BASE_URL, CONSUMER_KEY, consumerSecret, scope, callbackUrl);
    }


    public void getRank(JsonHttpResponseHandler handler, int player) {
        String summonerID = summoners[player].getSummonerID();
        String apiUrl = BASE_URL + "league/v4/entries/by-summoner/" + summonerID;

        // Can specify query string params directly or through RequestParams.
        RequestParams params = new RequestParams();
        client.get(apiUrl, params, handler);
    }

    /* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
     * 	  i.e getApiUrl("statuses/home_timeline.json");
     * 2. Define the parameters to pass to the request (query or body)
     *    i.e RequestParams params = new RequestParams("foo", "bar");
     * 3. Define the request method and make a call to the client
     *    i.e client.get(apiUrl, params, handler);
     *    i.e client.post(apiUrl, params, handler);
     */
}
