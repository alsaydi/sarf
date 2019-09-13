package sarf.verb.quadriliteral.augmented.passive.present;

import sarf.PresentConjugationDataContainer;

public class AugmentedPassivePresentConjugator {
    private AugmentedPassivePresentConjugator() {}

    private static final AugmentedPassivePresentConjugator instance = new AugmentedPassivePresentConjugator();

    private final AbstractAugmentedPresentConjugator nominativeConjugator = new AbstractAugmentedPresentConjugator(PresentConjugationDataContainer.getNominativeLastDprList(),
            PresentConjugationDataContainer.getNominativeConnectedPronounList());
    private final AbstractAugmentedPresentConjugator accusativeConjugator = new AbstractAugmentedPresentConjugator(PresentConjugationDataContainer.getAccusativeLastDprList(),
            PresentConjugationDataContainer.getAccusativeConnectedPronounList());
    private final AbstractAugmentedPresentConjugator jussiveConjugator = new AbstractAugmentedPresentConjugator(PresentConjugationDataContainer.getJussiveLastDprList(),
            PresentConjugationDataContainer.getJussiveConnectedPronounList());
    private final AbstractAugmentedPresentConjugator emphasizedConjugator = new AbstractAugmentedPresentConjugator(PresentConjugationDataContainer.getEmphasizedLastDprList(),
            PresentConjugationDataContainer.getEmphasizedConnectedPronounList());

    public static AugmentedPassivePresentConjugator getInstance() {
        return instance;
    }

    public AbstractAugmentedPresentConjugator getAccusativeConjugator() {
        return accusativeConjugator;
    }

    public AbstractAugmentedPresentConjugator getEmphasizedConjugator() {
        return emphasizedConjugator;
    }

    public AbstractAugmentedPresentConjugator getJussiveConjugator() {
        return jussiveConjugator;
    }

    public AbstractAugmentedPresentConjugator getNominativeConjugator() {
        return nominativeConjugator;
    }
}
