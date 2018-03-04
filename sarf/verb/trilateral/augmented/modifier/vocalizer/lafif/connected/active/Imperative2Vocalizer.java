package sarf.verb.trilateral.augmented.modifier.vocalizer.lafif.connected.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;
import sarf.verb.trilateral.augmented.*;

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
        substitutions.add(new SuffixSubstitution("íú",""));// EX: (Íóíøö¡ Şóæøö)
        substitutions.add(new InfixSubstitution("øöíö","øö"));// EX: (ÃäÊö Íóíøöí¡ Şóæøöí)
        substitutions.add(new InfixSubstitution("øöíõ","øõ"));// EX: (ÃäÊã ÍóíøõæÇ¡ ŞóæøõæÇ)
        substitutions.add(new InfixSubstitution("øöíú","øöí"));// EX: (ÃäÊä Íóíøöíäó¡ Şóæøöíäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        return (root.getC2() == 'æ' || root.getC2() == 'í') && root.getC3() == 'í' && (kov == 27 || kov == 28) && formulaNo == 2;
    }
}
