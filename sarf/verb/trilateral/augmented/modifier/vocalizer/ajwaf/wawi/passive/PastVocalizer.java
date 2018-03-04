package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.passive;

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
public class PastVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PastVocalizer() {

        substitutions.add(new ExpressionInfixSubstitution("úæöC3ú", "öC3ú")); // EX: (ÃõŞöãúÊõ¡ ÇÓÊÏÑÊõ¡)
        substitutions.add(new ExpressionInfixSubstitution("úæöC3ø", "öC3ø")); // EX: (ÃõãöÊøõ)
        substitutions.add(new ExpressionInfixSubstitution("úæöC3ó", "öíC3ó")); // EX: (ÃõŞöíãó¡ ÇÓÊõÏöíÑ¡)
        substitutions.add(new ExpressionInfixSubstitution("úæöC3õ", "öíC3õ")); // EX: (ÃõŞöíãõæÇ¡ ÇÓÊõÏöíÑæÇ¡)
        substitutions.add(new ExpressionInfixSubstitution("õæöC3ú", "öC3ú")); // EX: (ÇäúŞöÏúÊõ¡ ÇŞúÊöÏúÊõ)
        substitutions.add(new ExpressionInfixSubstitution("õæöC3ø", "öC3ø")); // EX: (ÇÎÊöÊøõ)
        substitutions.add(new ExpressionInfixSubstitution("õæöC3ó", "öíC3ó")); // EX: (ÇäŞöíÏó¡ ÇŞúÊöíÏó)
        substitutions.add(new ExpressionInfixSubstitution("õæöC3õ", "öíC3õ")); // EX: (ÇäŞöíÏõæÇ¡ ÇŞÊöíÏõæÇ)
    }

    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 16 || kov == 17) && formulaNo == 1) ||
                ((kov == 15 || kov == 17) && formulaNo == 4) ||
                ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 5) ||
                ((kov == 15 || kov == 16 || kov == 17) && formulaNo == 9);
    }
}
