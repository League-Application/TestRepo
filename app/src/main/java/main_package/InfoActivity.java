package main_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.yuumigg.R;
import org.json.*;

public class InfoActivity extends AppCompatActivity {

    TextView firstSummonerName, firstSummonerRank, firstSummonerLP, firstSummonerLevel;
    TextView secondSummonerName, secondSummonerRank, secondSummonerLP, secondSummonerLevel;
    SummonerObject[] summoners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

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
        

    }
}