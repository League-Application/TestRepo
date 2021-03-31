package main_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.yuumigg.R;
import org.json.*;

import okhttp3.Headers;

public class InfoActivity extends AppCompatActivity {

    TextView firstSummonerName, firstSummonerRank, firstSummonerLP, firstSummonerLevel;
    TextView secondSummonerName, secondSummonerRank, secondSummonerLP, secondSummonerLevel;
    SummonerObject[] summoners;
    APIHandler client;
    public static final String TAG = "InfoActivity";

    static int player = 0;
    int firstSummoner = 0;
    int secondSummoner = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        client = YummiApp.getClient(this);

        firstSummonerName = findViewById(R.id.firstSummonerName);
        firstSummonerRank = findViewById(R.id.firstSummonerRank);
        firstSummonerLP = findViewById(R.id.firstSummonerLP);
        firstSummonerLevel = findViewById(R.id.tvLevelInt);


        secondSummonerName = findViewById(R.id.secondSummonerName);
        secondSummonerRank = findViewById(R.id.secondSummonerRank);
        secondSummonerLP = findViewById(R.id.secondSummonerLP);
        secondSummonerLevel = findViewById(R.id.tvLevelInt2);

        summoners = SummonerStorage.getInstance().get();

        firstSummonerName.setText(summoners[0].getName());
        secondSummonerName.setText(summoners[1].getName());

        firstSummonerLevel.setText(summoners[0].getSummonerLevel()+"");
        secondSummonerLevel.setText(summoners[1].getSummonerLevel()+"");

        getPlayerRank(firstSummoner);
        getPlayerRank(secondSummoner);

        Log.i(TAG, "first and second rank reached");

    }

    private void getPlayerRank(int player) {
        client.getRank(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.i("InfoActivity", String.valueOf(statusCode));
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        }, player);
    }
}