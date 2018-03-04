package sarf.verb.trilateral.unaugmented.modifier.geminator.generic;

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
public class ImperativeGeminator extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public ImperativeGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úC3õC3õ","C1õC3øõ"));// EX: (ãõÏøõæÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úC3õC3ó","C1õC3øó"));// EX: (ãõÏøóÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úC3õC3ö","C1õC3øö"));// EX: (ãõÏøöí)
        substitutions.add(new ExpressionSuffixSubstitution("ÇC1úC3õC3ú","C1õC3øó"));// EX: (ãõÏøó)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úC3öC3õ","C1öC3øõ"));// EX: (ÊöãøõæÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úC3öC3ó","C1öC3øó"));// EX: (ÊöãøóÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úC3öC3ö","C1öC3øö"));// EX: (Êöãøöí)
        substitutions.add(new ExpressionSuffixSubstitution("ÇC1úC3öC3ú","C1öC3øó"));// EX: (Êöãøó)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úC3óC3õ","C1óC3øõ"));// EX: (ÚóÖøõæÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úC3óC3ó","C1óC3øó"));// EX: (ÚóÖøóÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC1úC3óC3ö","C1óC3øö"));// EX: (ÚóÖøöí)
        substitutions.add(new ExpressionSuffixSubstitution("ÇC1úC3óC3ú","C1óC3øó"));// EX: (ÚóÖøó)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
