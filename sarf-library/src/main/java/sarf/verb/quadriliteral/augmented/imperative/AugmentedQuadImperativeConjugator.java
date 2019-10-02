package sarf.verb.quadriliteral.augmented.imperative;

import sarf.ImperativeConjugationDataContainer;

public class AugmentedQuadImperativeConjugator {
    public AugmentedQuadImperativeConjugator() {}

    private final AbstractAugmentedImperativeConjugator notEmphasizedConjugator = new AbstractAugmentedImperativeConjugator(ImperativeConjugationDataContainer.getLastDimList(), ImperativeConjugationDataContainer.getConnectedPronounList());
    private final AbstractAugmentedImperativeConjugator emphasizedConjugator = new AbstractAugmentedImperativeConjugator(ImperativeConjugationDataContainer.getEmphasizedLastDimList(), ImperativeConjugationDataContainer.getEmphasizedConnectedPronounList());

    public AbstractAugmentedImperativeConjugator getEmphasizedConjugator() {
        return emphasizedConjugator;
    }

    public AbstractAugmentedImperativeConjugator getNotEmphasizedConjugator() {
        return notEmphasizedConjugator;
    }
}
