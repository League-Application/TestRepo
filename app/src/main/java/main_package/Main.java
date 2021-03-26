package main_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yuumigg.R;

import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;

public class Main extends AppCompatActivity {

    private final String TAG = "Main.java";
    private EditText input_summonerName;
    private Button btn_submit;
    private SummonerObject summ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        input_summonerName = findViewById(R.id.input_summonerName);
        btn_submit = findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(v -> new Thread(() -> {
            Log.i(TAG, "Button clicked");
            try {
                summ = new SummonerObject(input_summonerName.getText().toString());
                Toast.makeText(this, "Summ id:" + summ.getName(), Toast.LENGTH_LONG).show();
            } catch (RiotApiException e) {
                Log.e(TAG, "Error");
                e.printStackTrace();
            }
        }));
    }

    public void makeToast(View v) {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show();
    }
}
