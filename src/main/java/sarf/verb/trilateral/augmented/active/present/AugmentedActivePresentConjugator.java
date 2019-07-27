package sarf.verb.trilateral.augmented.active.present;

import sarf.PresentConjugationDataContainer;

public class AugmentedActivePresentConjugator {
    private AugmentedActivePresentConjugator() {}

    private static final AugmentedActivePresentConjugator instance = new AugmentedActivePresentConjugator();

    private final AugmentedPresentConjugator nominativeConjugator = new AugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getNominativeLastDprList(),
            PresentConjugationDataContainer.getInstance().getNominativeConnectedPronounList());
    private final AugmentedPresentConjugator accusativeConjugator = new AugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getAccusativeLastDprList(),
            PresentConjugationDataContainer.getInstance().getAccusativeConnectedPronounList());
    private final AugmentedPresentConjugator jussiveConjugator = new AugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getJussiveLastDprList(),
            PresentConjugationDataContainer.getInstance().getJussiveConnectedPronounList());
    private final AugmentedPresentConjugator emphasizedConjugator = new AugmentedPresentConjugator(PresentConjugationDataContainer.getInstance().getEmphasizedLastDprList(),
            PresentConjugationDataContainer.getInstance().getEmphasizedConnectedPronounList());

    public static AugmentedActivePresentConjugator getInstance() {
        return instance;
    }

    public AugmentedPresentConjugator getAccusativeConjugator() {
        return accusativeConjugator;
    }

    public AugmentedPresentConjugator getEmphasizedConjugator() {
        return emphasizedConjugator;
    }

    public AugmentedPresentConjugator getJussiveConjugator() {
        return jussiveConjugator;
    }

    public AugmentedPresentConjugator getNominativeConjugator() {
        return nominativeConjugator;
    }
}
