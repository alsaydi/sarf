package sarf.gerund.modifier.trilateral.unaugmented.nomen.geminator;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class Geminator1 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Geminator1() {
        substitutions.add(new ExpressionInfixSubstitution("óC3óC3óÇ","óC3øóÇ"));// EX: (ÑóÏøóÇÊ¡ )
        substitutions.add(new ExpressionInfixSubstitution("óC3úC3ó","óC3øó"));// EX: (ÑóÏøóÉ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        return conjugationResult.getRoot().getC2() == conjugationResult.getRoot().getC3();
    }
}
