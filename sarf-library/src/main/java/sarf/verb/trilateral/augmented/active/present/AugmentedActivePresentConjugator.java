package sarf.verb.trilateral.augmented.active.present;

import com.google.inject.Inject;
import sarf.PresentConjugationDataContainer;

public class AugmentedActivePresentConjugator {

    @Inject
    public AugmentedActivePresentConjugator() {}

    private final AugmentedPresentConjugator nominativeConjugator = new AugmentedPresentConjugator(PresentConjugationDataContainer.getNominativeLastDprList(),
            PresentConjugationDataContainer.getNominativeConnectedPronounList());
    private final AugmentedPresentConjugator accusativeConjugator = new AugmentedPresentConjugator(PresentConjugationDataContainer.getAccusativeLastDprList(),
            PresentConjugationDataContainer.getAccusativeConnectedPronounList());
    private final AugmentedPresentConjugator jussiveConjugator = new AugmentedPresentConjugator(PresentConjugationDataContainer.getJussiveLastDprList(),
            PresentConjugationDataContainer.getJussiveConnectedPronounList());
    private final AugmentedPresentConjugator emphasizedConjugator = new AugmentedPresentConjugator(PresentConjugationDataContainer.getEmphasizedLastDprList(),
            PresentConjugationDataContainer.getEmphasizedConnectedPronounList());

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
