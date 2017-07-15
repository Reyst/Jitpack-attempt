package reyst.gsihome.ja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import reyst.gsihome.dtlib.CurrentDateTimeProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("DTLIB", CurrentDateTimeProvider.getDateTime("dd.MM.yyyy hh:mm:ss"));
    }
}
