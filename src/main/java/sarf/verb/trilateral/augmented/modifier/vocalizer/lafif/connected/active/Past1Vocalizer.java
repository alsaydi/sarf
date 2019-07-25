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
public class Past1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Past1Vocalizer() {
        substitutions.add(new SuffixSubstitution("َيَ","َا"));// EX: (أحْيَا، حَيَّا، حايا، ازدَيَا، تحايا، تحَيَّا، استحيا)
        substitutions.add(new InfixSubstitution("يُو", "وْ")); // EX: (أحْيَوْا، حَيَّوْا حايَوْا، ، ازدَيَوْا، تحايَوْا، تَحَيَّوْا، استَحْيَوْا)
        substitutions.add(new InfixSubstitution("يَت", "ت")); // EX: (أحْيَتْ، حيَّت، حايَتْ، ، ازدَيَتْ،  تحايتْ، تَحَيَّتْ، استحيَتْ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();
        AugmentedTrilateralRoot root = conjugationResult.getRoot();
        if (root.getC2() == root.getC3() && root.getC3() == 'ي' && kov == KindOfVerb.Lafeef_Maqroon) {
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
            case 9:
                return true;
            }
        }
        return false;
    }
}
