package sarf.verb.trilateral.unaugmented.modifier.vocalizer;

import sarf.Conjugation;
import sarf.ConjugationResult;

import java.util.*;

import sarf.substitution.SubstitutionsApplier;
import sarf.verb.trilateral.unaugmented.modifier.*;


/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description:كان  من  ضمنها  هذا  الجذر  أو  لا في حالات الاعلال يتم فحص قائمة من الجذور اذا
 *  </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class ListedVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public ListedVocalizer() {
    }

    /**
     * isApplied
     *
     * @param conjugationResult NounConjugationResult
     * @return boolean
     * @todo Implement this
     *   sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier
     *   method
     */
    public boolean isApplied(ConjugationResult conjugationResult) {
        var root = conjugationResult.getRoot();
        //فحص الباب التصريفي أولاً
        if (root.getConjugation() != getNoc()) return false;

        for (Object o : getAppliedRoots()) {
            String appliedRoot = (String) o;
            char c1 = appliedRoot.charAt(0);
            char c2 = appliedRoot.charAt(1);
            char c3 = appliedRoot.charAt(2);
            if (c1 == root.getC1() && c2 == root.getC2() && root.getC3() == c3)
                return true;
        }
        return false;
    }

    protected abstract List getAppliedRoots();
    protected abstract Conjugation getNoc();
}
