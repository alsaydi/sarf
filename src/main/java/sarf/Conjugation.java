package sarf;

/**
 * It's one of the six bab of tasreef
 * أحد أبواب التصريف الستة
 */
public enum  Conjugation {
    First(1),
    Second(2),
    Third(3),
    Forth(4),
    Fifth(5),
    Sixth(6);

    private int value;
    Conjugation(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
