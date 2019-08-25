package sarf.verb.quadriliteral.augmented.active.present;

import sarf.PresentConjugationDataContainer;

public class AugmentedActivePresentConjugator {
    private AugmentedActivePresentConjugator() {}

    private static final AugmentedActivePresentConjugator instance = new AugmentedActivePresentConjugator();

    private final QuadriAugmentedPresentConjugator nominativeConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getNominativeLastDprList(),
            PresentConjugationDataContainer.getInstance().getNominativeConnectedPronounList());
    private final QuadriAugmentedPresentConjugator accusativeConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getAccusativeLastDprList(),
            PresentConjugationDataContainer.getInstance().getAccusativeConnectedPronounList());
    private final QuadriAugmentedPresentConjugator jussiveConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getJussiveLastDprList(),
            PresentConjugationDataContainer.getInstance().getJussiveConnectedPronounList());
    private final QuadriAugmentedPresentConjugator emphasizedConjugator = new QuadriAugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getEmphasizedLastDprList(),
            PresentConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());

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
