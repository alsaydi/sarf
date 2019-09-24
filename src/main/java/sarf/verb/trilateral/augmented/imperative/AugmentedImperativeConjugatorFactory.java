package sarf.verb.trilateral.augmented.imperative;

import com.google.inject.Singleton;
import sarf.ImperativeConjugationDataContainer;

/**
 * this class has method that return instances that know how conjugate the augment imperative verb of both kinds (مؤكد و غير مؤكد)
 */
@Singleton
public final class AugmentedImperativeConjugatorFactory {
    public AugmentedImperativeConjugatorFactory() {}

    private final AugmentedImperativeConjugator notEmphasizedConjugator = new AugmentedImperativeConjugator(ImperativeConjugationDataContainer.getLastDimList(), ImperativeConjugationDataContainer.getConnectedPronounList());
    private final AugmentedImperativeConjugator emphasizedConjugator = new AugmentedImperativeConjugator(ImperativeConjugationDataContainer.getEmphasizedLastDimList(), ImperativeConjugationDataContainer.getEmphasizedConnectedPronounList());

    public AugmentedImperativeConjugator getEmphasizedConjugator() {
        return emphasizedConjugator;
    }

    public AugmentedImperativeConjugator getNotEmphasizedConjugator() {
        return notEmphasizedConjugator;
    }
}
