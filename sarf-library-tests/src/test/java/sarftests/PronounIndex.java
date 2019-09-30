package sarftests;

public enum PronounIndex {
    FirstPersonSingular(0),
    FirstPersonPlural(1),

    SecondPersonMasculineSingular(2),
    SecondPersonFeminineSingular(3),
    SecondPersonDual(4),
    SecondPersonMasculinePlural(5),
    SecondPersonFemininePlural(6),

    ThirdPersonMasculineSingular(7),
    ThirdPersonFeminineSingular(8),
    ThirdPersonMasculineDual(9),
    ThirdPersonFeminineDual(10),

    ThirdPersonMasculinePlural(11),
    ThirdPersonFemininePlural(12);

    private final int value;
    PronounIndex(int value){
        this.value = value;
    }
    public int getValue(){return value;}
}
