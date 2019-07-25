package sarf;

/**
 * It's one of the six bab of tasreef
 * أحد أبواب التصريف الستة
 * الأول - فعَل -- يفعٌل (بفتح عين الماضي و بضـم عين المضارع)
 * الثاني - فعَل -- يفعِل (بفتح عين الماضي و بكسر عين المضارع)
 * الثالث - فعَل -- يفعَل (بفتح عين الماضي و بفتح عين المضارع)
 *
 * الرابع - فعٍل -- يفعَل (بكسر عين الماضي و فتح عين المضارع)
 * الخامس - فعٌل -- يفعٌل (بضـم عين الماضي و ضـم عين المضارع)
 * السادس - فعٍل -- يفعِل (بكسر عين الماضي و كسر عين المضارع)
 */
public enum  Conjugation {
    First(1),
    Second(2),
    Third(3),
    Forth(4),
    Fifth(5),
    Sixth(6);

    private final int value;
    Conjugation(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
