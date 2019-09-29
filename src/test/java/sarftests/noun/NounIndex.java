package sarftests.noun;

public enum NounIndex {
    NominativeSingleMasculine (0),
    NominativeSingleFeminine(1),
    NominativeDualMasculine(2),
    NominativeDualFeminine(3),
    NominativePluralMasculine(4),
    NominativePluralFeminine(5),
    AccusativeSingleMasculine (6),
    AccusativeSingleFeminine(7),
    AccusativeDualMasculine(8),
    AccusativeDualFeminine(9),
    AccusativePluralMasculine(10),
    AccusativePluralFeminine(11),
    GenitiveSingleMasculine (12),
    GenitiveSingleFeminine(13),
    GenitiveDualMasculine(14),
    GenitiveDualFeminine(15),
    GenitivePluralMasculine(16),
    GenitivePluralFeminine(17);

    private final int value;
    NounIndex(int value){
        this.value = value;
    }

    public int getValue(){return value;}
}
