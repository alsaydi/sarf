package sarf.verb.quadriliteral.augmented.active.present;

import sarf.PresentConjugationDataContainer;

public class AugmentedActivePresentConjugator {
    private AugmentedActivePresentConjugator() {}

    private static final AugmentedActivePresentConjugator instance = new AugmentedActivePresentConjugator();

    private final QuadriAugmentedPresentConjugator nominativeConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getNominativeLastDprList(),
            PresentConjugationDataContainer.getNominativeConnectedPronounList());
    private final QuadriAugmentedPresentConjugator accusativeConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getAccusativeLastDprList(),
            PresentConjugationDataContainer.getAccusativeConnectedPronounList());
    private final QuadriAugmentedPresentConjugator jussiveConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getJussiveLastDprList(),
            PresentConjugationDataContainer.getJussiveConnectedPronounList());
    private final QuadriAugmentedPresentConjugator emphasizedConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getEmphasizedLastDprList(),
            PresentConjugationDataContainer.getEmphasizedConnectedPronounList());

    public static AugmentedActivePresentConjugator getInstance() {
        return instance;
    }

    public QuadriAugmentedPresentConjugator getAccusativeConjugator() {
        return accusativeConjugator;
    }

    public QuadriAugmentedPresentConjugator getEmphasizedConjugator() {
        return emphasizedConjugator;
    }

    public QuadriAugmentedPresentConjugator getJussiveConjugator() {
        return jussiveConjugator;
    }

    public QuadriAugmentedPresentConjugator getNominativeConjugator() {
        return nominativeConjugator;
    }
}
