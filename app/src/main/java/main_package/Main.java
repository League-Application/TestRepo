package main_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yuumigg.R;

import net.rithms.riot.api.RiotApiException;

import java.util.concurrent.ExecutionException;

public class Main extends AppCompatActivity {

    private final String TAG = "Main.java";
    private EditText input_summonerName;
    private Button btn_submit;
    private SummonerObject currentSummoner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        input_summonerName = findViewById(R.id.input_summonerName);
        btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(v -> { //submit button
            // TODO:
            //
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
            try {
                currentSummoner = new setSummoner().execute().get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "Got summoner name " + currentSummoner.getName());
        });
    }

    private class setSummoner extends AsyncTask<Void, Void, SummonerObject> {
        @Override
        protected SummonerObject doInBackground(Void... voids) {
            try {
                currentSummoner = new SummonerObject(input_summonerName.getText().toString());
            } catch (RiotApiException e) {
                Log.e(TAG, "Encountered an error...");
                e.printStackTrace();
            }
            return currentSummoner;
        }
        @Override
        protected void onPostExecute(SummonerObject aVoid) {
            Log.i(TAG, "Summoner " + currentSummoner.getName() + " grabbed!");
            super.onPostExecute(aVoid);
        }
    }


}
