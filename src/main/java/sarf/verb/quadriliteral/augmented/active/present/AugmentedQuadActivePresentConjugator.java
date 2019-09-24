package sarf.verb.quadriliteral.augmented.active.present;

import sarf.PresentConjugationDataContainer;

public class AugmentedQuadActivePresentConjugator {
    public AugmentedQuadActivePresentConjugator() {}

    private final QuadriAugmentedPresentConjugator nominativeConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getNominativeLastDprList(),
            PresentConjugationDataContainer.getNominativeConnectedPronounList());
    private final QuadriAugmentedPresentConjugator accusativeConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getAccusativeLastDprList(),
            PresentConjugationDataContainer.getAccusativeConnectedPronounList());
    private final QuadriAugmentedPresentConjugator jussiveConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getJussiveLastDprList(),
            PresentConjugationDataContainer.getJussiveConnectedPronounList());
    private final QuadriAugmentedPresentConjugator emphasizedConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getEmphasizedLastDprList(),
            PresentConjugationDataContainer.getEmphasizedConnectedPronounList());

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
