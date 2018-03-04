package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("óæöC3õ","óÇC3õ"));// EX: (ÃäÊã ÇäŞÇÏæÇ¡ ÇŞÊÇÏæÇ)
        substitutions.add(new ExpressionInfixSubstitution("óæöC3ö","óÇC3ö"));// EX: (ÃäÊö ÇäŞÇÏí¡ ÇŞÊÇÏí)
        substitutions.add(new ExpressionInfixSubstitution("óæöC3ó","óÇC3ó"));// EX: (ÃäÊãÇ ÇäŞÇÏÇ¡ ÇŞÊÇÏÇ)
        substitutions.add(new ExpressionInfixSubstitution("óæöC3ú","óC3ú"));// EX: (ÃäÊä ÇäŞÏä¡ ÇŞÊÏä)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 15 || kov == 17) && formulaNo == 4) || ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 5);
    }
}
