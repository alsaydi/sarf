package sarf.verb.trilateral.augmented.modifier.geminator.generic;

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

        substitutions.add(new ExpressionInfixSubstitution("C1úC3öC3õ", "C1öC3øõ")); // EX: (ÃóÊöãøõæÇ)
        substitutions.add(new ExpressionInfixSubstitution("C1úC3öC3ó", "C1öC3øó")); // EX: (ÃóÊöãøóÇ)
        substitutions.add(new ExpressionInfixSubstitution("C1úC3öC3ö", "C1öC3øö")); // EX: (ÃóÊöãøöí)
        substitutions.add(new ExpressionSuffixSubstitution("C1úC3öC3ú", "C1öC3øó")); // EX: (ÃóÊöãøó)
        substitutions.add(new ExpressionInfixSubstitution("C3öC3õ", "C3øõ")); // EX: (ÇäŞóÖøõæÇ¡ ÍÇÌøõæÇ)
        substitutions.add(new ExpressionInfixSubstitution("C3öC3ó", "C3øó")); // EX: (ÇäúŞóÖøóÇ¡ ÍÇÌøóÇ)
        substitutions.add(new ExpressionInfixSubstitution("C3öC3ö", "C3øö")); // EX: (ÇäúŞóÖøöí¡ ÍÇÌøöí)
        substitutions.add(new ExpressionSuffixSubstitution("C3öC3ú", "C3øó")); // EX: (ÇäúŞóÖøó¡ ÍÇÌøó)
        substitutions.add(new ExpressionSuffixSubstitution("ÇC3óC3ú", "ÇC3øó")); // EX: (ÊÂÌøó)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3óC3úä","ÇC3óC3úä"));// EX: (ÊÂÌóÌúäó)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3óC3", "ÇC3ø")); // EX: (ÊÂÌøõæÇ¡ ÊÂÌøóÇ¡ ÊÂÌøöí)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
