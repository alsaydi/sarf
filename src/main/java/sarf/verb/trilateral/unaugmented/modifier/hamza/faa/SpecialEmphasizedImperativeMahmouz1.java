package sarf.verb.trilateral.unaugmented.modifier.hamza.faa;

import sarf.Conjugation;
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
public class SpecialEmphasizedImperativeMahmouz1 extends SubstitutionsApplier {

    public SpecialEmphasizedImperativeMahmouz1() {
    }

    @Override
    public List<Substitution> getSubstitutions() {
        return Collections.emptyList();
    }

    @Override
    public boolean isApplied(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        return root.getC1() == 'ء' && root.getC2() == 'خ' && root.getC3() == 'ذ' && root.getConjugation() == Conjugation.First;
    }

    /**
     * override this method to return the custom list
     *
     * @param words List
     * @param root  TrilateralRoot
     */
    @Override
    public void apply(List<WordPresenter> words, Root root) {
        words.set(2, WordPresenter.fromText("خُذَنَّ"));
        words.set(3, WordPresenter.fromText("خُذِنَّ"));
        words.set(4, WordPresenter.fromText("خُذَانِّ"));
        words.set(5, WordPresenter.fromText("خُذُنَّ"));
        words.set(6, WordPresenter.fromText("خُذْنَانِّ"));
    }
}
