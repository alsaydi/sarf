package sarf.verb.trilateral.augmented.imperative;


import sarf.ImperativeConjugationDataContainer;

public class AugmentedImperativeConjugator {
    private AugmentedImperativeConjugator() {}

    private static final AugmentedImperativeConjugator instance = new AugmentedImperativeConjugator();

    private final AbstractAugmentedImperativeConjugator notEmphasizedConjugator = new AbstractAugmentedImperativeConjugator(ImperativeConjugationDataContainer.getInstance().getLastDimList(), ImperativeConjugationDataContainer.getInstance().getConnectedPronounList());
    private final AbstractAugmentedImperativeConjugator emphasizedConjugator = new AbstractAugmentedImperativeConjugator(ImperativeConjugationDataContainer.getInstance().getEmphasizedLastDimList(), ImperativeConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());

    public static AugmentedImperativeConjugator getInstance() {
        return instance;
    }

    public AbstractAugmentedImperativeConjugator getEmphasizedConjugator() {
        return emphasizedConjugator;
    }

    public AbstractAugmentedImperativeConjugator getNotEmphasizedConjugator() {
        return notEmphasizedConjugator;
    }
}
