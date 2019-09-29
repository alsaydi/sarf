package sarf;

public abstract class Word {
    public WordPresenter producePresenter() {
        return WordPresenter.fromText(this.toString());
    }

    public static Word empty()
    {
        return new Word() {
            @Override
            public String toString() {
                return "";
            }

            ;
        };
    }

    public static Word fromString(String text) {
        return new Word() {
            @Override
            public String toString() {
                return text;
            }
        };
    }
}
