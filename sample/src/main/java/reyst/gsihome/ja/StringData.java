package reyst.gsihome.ja;

import java.io.Serializable;


@SuppressWarnings("WeakerAccess")
public class StringData implements Serializable {

    private String text;

    public StringData() {}

    public StringData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
