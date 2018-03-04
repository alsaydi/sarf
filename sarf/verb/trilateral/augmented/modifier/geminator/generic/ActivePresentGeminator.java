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
public class ActivePresentGeminator extends SubstitutionsApplier {

    private List substitutions = new LinkedList();

    public ActivePresentGeminator() {
        substitutions.add(new ExpressionInfixSubstitution("úC3öC3õ", "öC3øõ")); // EX: (íõÊöãøõ)
        substitutions.add(new ExpressionInfixSubstitution("úC3öC3ó", "öC3øó")); // EX: (íõÊöãøóÇä)
        substitutions.add(new ExpressionInfixSubstitution("úC3öC3ö", "öC3øö")); // EX: (ÊõÊöãøöíäó)
        substitutions.add(new ExpressionSuffixSubstitution("úC3öC3ú", "öC3øó")); // EX: (áã íõÊöãøó)
        substitutions.add(new ExpressionInfixSubstitution("óC3öC3õ", "óC3øõ")); // EX: (íÃÊóãø)
        substitutions.add(new ExpressionInfixSubstitution("óC3öC3ó", "óC3øó")); // EX: (íÃÊóãøÇä)
        substitutions.add(new ExpressionInfixSubstitution("óC3öC3ö", "óC3øö")); // EX: (ÊÃÊóãøöíäó)
        substitutions.add(new ExpressionSuffixSubstitution("óC3öC3ú", "óC3øó")); // EX: (áã íÃÊóãø)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3óC3õ", "ÇC3øõ")); // EX: (íóÊóÕóÇãøõ¡)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3óC3ó", "ÇC3øó")); // EX: (íóÊóÕóÇãøóÇ¡)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3óC3ö", "ÇC3øö")); // EX: (ÊóÊóÕóÇãøöí¡)
        substitutions.add(new ExpressionSuffixSubstitution("ÇC3óC3ú", "ÇC3øó")); // EX: (áã íóÊóÕóÇãøó¡)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3öC3õ", "ÇC3øõ")); // EX: (íõÍÇÌø)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3öC3ó", "ÇC3øó")); // EX: (íõÍÇÌøÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇC3öC3ö", "ÇC3øö")); // EX: (ÊõÍÇÌøöí)
        substitutions.add(new ExpressionSuffixSubstitution("ÇC3öC3ú", "ÇC3øó")); // EX: (áã  í KõÍÇÌøó)
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
