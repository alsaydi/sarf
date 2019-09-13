package sarf.verb.quadriliteral.augmented.imperative;

import sarf.ImperativeConjugationDataContainer;

public class AugmentedImperativeConjugator {
    private AugmentedImperativeConjugator() {}

    private static final AugmentedImperativeConjugator instance = new AugmentedImperativeConjugator();

    private final AbstractAugmentedImperativeConjugator notEmphsizedConjugator = new AbstractAugmentedImperativeConjugator(ImperativeConjugationDataContainer.getLastDimList(), ImperativeConjugationDataContainer.getConnectedPronounList());
    private final AbstractAugmentedImperativeConjugator emphsizedConjugator = new AbstractAugmentedImperativeConjugator(ImperativeConjugationDataContainer.getEmphasizedLastDimList(), ImperativeConjugationDataContainer.getEmphasizedConnectedPronounList());

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
