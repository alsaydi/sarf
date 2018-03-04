package sarf.verb.trilateral.augmented.imperative;


import sarf.ImperativeConjugationDataContainer;

public class AugmentedImperativeConjugator {
    private AugmentedImperativeConjugator() {}

    private static AugmentedImperativeConjugator instance = new AugmentedImperativeConjugator();

    private AbstractAugmentedImperativeConjugator notEmphsizedConjugator = new AbstractAugmentedImperativeConjugator(ImperativeConjugationDataContainer.getInstance().getLastDimList(), ImperativeConjugationDataContainer.getInstance().getConnectedPronounList());
    private AbstractAugmentedImperativeConjugator emphsizedConjugator = new AbstractAugmentedImperativeConjugator(ImperativeConjugationDataContainer.getInstance().getEmphasizedLastDimList(), ImperativeConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());

    public static AugmentedImperativeConjugator getInstance() {
        return instance;
    }

    public AbstractAugmentedImperativeConjugator getEmphsizedConjugator() {
        return emphsizedConjugator;
    }

    public AbstractAugmentedImperativeConjugator getNotEmphsizedConjugator() {
        return notEmphsizedConjugator;
    }
}
