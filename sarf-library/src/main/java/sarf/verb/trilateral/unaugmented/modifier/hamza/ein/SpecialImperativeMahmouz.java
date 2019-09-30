package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

import sarf.ConjugationResult;
import sarf.WordPresenter;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;
import sarf.verb.Root;

import java.util.Collections;
import java.util.List;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class SpecialImperativeMahmouz extends SubstitutionsApplier {

    public SpecialImperativeMahmouz() {
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return Collections.emptyList();
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        return root.getC1() == 'س' && root.getC2() == 'ء' && root.getC3() == 'ل';
    }

    /**
     * override this method to return the custom list
     *
     * @param words List
     * @param root  TrilateralRoot
     */
    @Override
    public void apply(List<WordPresenter> words, Root root) {
        words.set(2, WordPresenter.fromText("سَلْ/اسْأَلْ"));
        words.set(3, WordPresenter.fromText("سَلِي/اسْأَلِي"));
        words.set(4, WordPresenter.fromText("سَلاَ/اسْأَلاَ"));
        words.set(5, WordPresenter.fromText("سَلُوا/اسْأَلُوا"));
        words.set(6, WordPresenter.fromText("سَلْنَ/اسْأَلْنَ"));
    }
}
