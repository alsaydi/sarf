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
public class PassivePresentGeminator extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public PassivePresentGeminator() {

        substitutions.add(new ExpressionInfixSubstitution("úC3óC3õ","óC3øõ"));// EX: (íõÊóãøõ¡)
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3ó","óC3øó"));// EX: (íõÊóãøóÇä¡)
        substitutions.add(new ExpressionInfixSubstitution("úC3óC3ö","óC3øö"));// EX: (ÊõÊóãøöí¡)
        substitutions.add(new ExpressionSuffixSubstitution("úC3óC3ú","óC3øó"));// EX: (áã íõÊóãøó¡)
        substitutions.add(new ExpressionSuffixSubstitution("óC3óC3ú","óC3øó"));// EX: (áã íõäúŞóÖøó¡ íõÔúÊóÏøó)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3óC3õ","ÇC3øõ"));// EX: (íõÊóÕóÇãøõ¡ íõÍÇÌø)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3óC3ó","ÇC3øó"));// EX: (íõÊóÕóÇãøóÇ¡ íÍÇÌøÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3óC3ö","ÇC3øö"));// EX: (ÊõÊóÕóÇãøöí¡ ÊÍÇÌöí)
        substitutions.add(new ExpressionSuffixSubstitution("ÇC3óC3ú","ÇC3øó"));// EX: (áã íõÊóÕóÇãøó¡ íÍÇÌøó)
        substitutions.add(new ExpressionInfixSubstitution("óC3óC3õ","óC3øõ"));// EX: (íõÍúãóÑøõ¡ íõŞúÊóÖøõ)
        substitutions.add(new ExpressionInfixSubstitution("óC3óC3ó","óC3øó"));// EX: (áä íõÍúãóÑøó¡ áä íõäúŞóÖøó¡ áä íõÔÊÏøó)
        substitutions.add(new ExpressionInfixSubstitution("óC3óC3ö","óC3øö"));// EX: (ÊõäŞóÖøöíä)

    }

    public List getSubstitutions() {
        return substitutions;
    }
}
