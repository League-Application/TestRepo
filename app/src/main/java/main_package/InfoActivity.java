package main_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.yuumigg.R;

public class InfoActivity extends AppCompatActivity {

    TextView firstSummonerName, firstSummonerRank, firstSummonerLP;
    TextView secondSummonerName, secondSummonerRank, secondSummonerLP;
    SummonerObject[] summoners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        firstSummonerName = findViewById(R.id.firstSummonerName);
        firstSummonerRank = findViewById(R.id.firstSummonerRank);
        firstSummonerLP = findViewById(R.id.firstSummonerLP);

        secondSummonerName = findViewById(R.id.secondSummonerName);
        secondSummonerRank = findViewById(R.id.secondSummonerRank);
        secondSummonerLP = findViewById(R.id.secondSummonerLP);

        summoners = SummonerStorage.getInstance().get();

        firstSummonerName.setText(summoners[0].getName());
        secondSummonerName.setText(summoners[1].getName());



    }
}