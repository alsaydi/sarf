package sarf.noun;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;

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
public abstract class TrilateralNounSubstitutionApplier extends SubstitutionsApplier {

    private static final List<String> appliedPronounsIndexes = new ArrayList<>(18);
    static {
        for (int i=0; i<18; i++) {
            appliedPronounsIndexes.add(i+1 +"");
        }
    }

    public TrilateralNounSubstitutionApplier() {
    }

    @Override
    protected List<String> getAppliedPronounsIndexes() {
        return appliedPronounsIndexes;
    }
}
