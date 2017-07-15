package reyst.gsihome.ja;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import me.pinxter.letters.Letters;
import reyst.gsihome.dtlib.CurrentDateTimeProvider;

public class MainActivity extends AppCompatActivity {

    private List<StringData> dataForRv;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("DTLIB", CurrentDateTimeProvider.getDateTime("dd.MM.yyyy hh:mm:ss"));

        prepareData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(lm);

        //noinspection unchecked
        Letters letters = new Letters(this, "text", new ArrayList(dataForRv));
        letters.setOnSelect(new Letters.OnSelect() {
            @Override
            public void onSelect(int index, String letter) {
                recyclerView.getLayoutManager().scrollToPosition(index);
            }
        });

        FrameLayout lettersView = (FrameLayout) findViewById(R.id.letters);
        lettersView.removeAllViews();
        lettersView.addView(letters.getLetterLayout());

        setLettersSize(lettersView, 24);

        initRv(letters);

    }

    private void setLettersSize(View v, int size) {

        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    setLettersSize(child, size);
                }
            } else if (v instanceof TextView) {
                ((TextView) v).setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
            }
        } catch (Exception ignored) {
        }
    }

    private void initRv(Letters letters) {

        RecyclerView.Adapter adapter = new RVAdapter(dataForRv, letters);
        recyclerView.setAdapter(adapter);
    }

    private void prepareData() {
        String[] arr = getResources().getStringArray(R.array.texts);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.toUpperCase().compareTo(s2.toUpperCase());
            }
        });

        //noinspection unchecked
        dataForRv = new ArrayList();
        for (String s : arr) dataForRv.add(new StringData(s));
    }
}
