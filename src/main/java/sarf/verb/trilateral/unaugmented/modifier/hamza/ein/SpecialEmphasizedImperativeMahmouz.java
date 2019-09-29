package sarf.verb.trilateral.unaugmented.modifier.hamza.ein;

import java.util.*;

import sarf.WordPresenter;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

import sarf.ConjugationResult;
import sarf.verb.Root;

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
public class SpecialEmphasizedImperativeMahmouz extends SubstitutionsApplier {

    public SpecialEmphasizedImperativeMahmouz() {
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
     * @param words List
     * @param root TrilateralRoot
     */
    @Override
    public void apply(List<WordPresenter> words, Root root) {
        words.set(2, WordPresenter.fromText("سَلَنَّ/اسْألَنَّ"));
        words.set(3, WordPresenter.fromText("سَلِنَّ/اسْألِنَّ"));
        words.set(4, WordPresenter.fromText("سَلاَنِّ/اسْألاَنِّ"));
        words.set(5, WordPresenter.fromText("سَلُنَّ/اسْألُنَّ"));
        words.set(6, WordPresenter.fromText("سَلْنَانِّ/اسْألْنَانِّ"));
    }
}
