package sarf.verb;

public final class RootLetter{
    public static final String C1 = "C1";
    public static final String C2 = "C2";
    public static final String C3 = "C3";
    public static final String C4 = "C4";

    private final String moniker;
    private final char value;

    public RootLetter(String moniker, char value){
        this.moniker = moniker;
        this.value = value;
    }

    public String getMoniker() {
        return moniker;
    }

    public char getValue() {
        return value;
    }
}

