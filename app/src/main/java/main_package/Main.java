package main_package;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yuumigg.R;

import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;

import java.util.concurrent.ExecutionException;

public class Main extends AppCompatActivity {

    private final String TAG = "Main.java";                         // tag for Log
    private EditText input_summonerName, input_secondSummonerName;  // text inputs
    private Button btn_submit;                                      // submit button
    private SummonerObject firSummoner, secSummoner;                // two 'friends' summoners (as objects)
    private SummonerObject[] duo = new SummonerObject[2];           // array of size 2 to store summoners for easy access

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        input_summonerName = findViewById(R.id.input_summonerName);             // reference variables to xml elements
        input_secondSummonerName = findViewById(R.id.input_secondSummonerName);
        btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(v -> {                                    //submit button
//            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
            try {
                duo = new setSummoners().execute().get();                       // runs setSummoners class below
                Log.i(TAG, duo[0].getName());
                SummonerStorage.getInstance().set(duo);
                Intent intent = new Intent(Main.this, InfoActivity.class);
                startActivity(intent);
            } catch (ExecutionException e) {                                    // required catch block
                e.printStackTrace();
            } catch (InterruptedException e) {                                  // required catch block
                e.printStackTrace();
            }
//            Log.i(TAG, "Summoners: " +                                    // log summoners
//                    duo[0].getName() + ", " +
//                    duo[1].getName());

//            Toast.makeText(this, "Got Summoners: "  +
//                    duo[0].getName() + ", " +
//                    duo[1].getName(), Toast.LENGTH_SHORT).show();
        });
    }

    private class setSummoners extends AsyncTask<Void, Void, SummonerObject[]> {
        @Override

        protected SummonerObject[] doInBackground(Void... voids) {
            try {
                firSummoner = new SummonerObject(input_summonerName.getText().toString());          // grab users from input
                secSummoner = new SummonerObject(input_secondSummonerName.getText().toString());    // TODO: add handling for no inputs
                duo[0] = firSummoner;  duo[1] = secSummoner;                                        // set users into array
            } catch (RiotApiException e) {
                Log.e(TAG, "Encountered an error...");
                e.printStackTrace();
            }
            return duo;                                                                             // return array
        }
        @Override
        protected void onPostExecute(SummonerObject[] aVoid) {
            Log.i(TAG, "Grabbed " + duo[0].getName() + " and " + duo[1].getName());
            super.onPostExecute(aVoid);
        }
    }


}