package reyst.gsihome.ja;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.pinxter.letters.Letters;

@SuppressWarnings("WeakerAccess")
public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<StringData> model;
    private Letters letters;


    public RVAdapter(List<StringData> dataForRv, Letters letters) {
        this.letters = letters;
        model = new ArrayList<>(dataForRv);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new StringDataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        StringDataViewHolder sdHolder = (StringDataViewHolder) holder;
        sdHolder.letter.setText(letters.getLetter(position));
        sdHolder.mainText.setText(model.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    private class StringDataViewHolder extends RecyclerView.ViewHolder {

        TextView letter;
        TextView mainText;

        public StringDataViewHolder(View v) {
            super(v);
            letter = v.findViewById(R.id.letter_place);
            mainText = v.findViewById(R.id.main_text);
        }
    }
}
