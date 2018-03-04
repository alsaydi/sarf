package sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
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
public class NakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public NakesLafifVocalizer() {

        substitutions.add(new InfixSubstitution("َوٌ", "ًى")); // EX: (هذا مَغْزًى )
        substitutions.add(new InfixSubstitution("َوًا", "ًى")); // EX: (رأيت مَغْزًى )
        substitutions.add(new InfixSubstitution("َوٍ", "ًى")); // EX: (بِمَغْزًى )
        substitutions.add(new SuffixSubstitution("َوُ", "َى")); // EX: (هذا مَغْزَى الأمر)
        substitutions.add(new SuffixSubstitution("َوَ", "َى")); // EX: (رأيت مَغْزَى الأمر)
        substitutions.add(new SuffixSubstitution("َوِ", "َى")); // EX: (بِمَغْزَى الأمر)
        substitutions.add(new InfixSubstitution("َيٌ", "ًى")); // EX: (هذا مرمًى )
        substitutions.add(new InfixSubstitution("َيًا", "ًى")); // EX: (رأيت مرمًى)
        substitutions.add(new InfixSubstitution("َيٍ", "ًى")); // EX: (بِمرمًى)
        substitutions.add(new SuffixSubstitution("َيُ", "َى")); // EX: (هذا مرمَى القوم)
        substitutions.add(new SuffixSubstitution("َيَ", "َى")); // EX: (رأيت مرمَى القوم)
        substitutions.add(new SuffixSubstitution("َيِ", "َى")); // EX: (بِمرمَى القوم)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (!conjugationResult.getNounFormula().equals("مَفْعَل")) {
            return false;
        }

        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 21:
            return noc == 1 || noc == 5;
        case 22:
            return noc == 1 || noc == 3;
        case 23:
            switch (noc) {
            case 1:
            case 3:
            case 4:
            case 5:
                return true;
            }

        case 24:
        case 26:
            switch (noc) {
            case 2:
            case 3:
            case 4:
                return true;
            }

        case 25:
            return noc == 3 || noc == 4;

        case 27:
        case 29:
            return noc == 2;
        case 28:
            return noc == 2 || noc == 4;
        case 30:
            switch (noc) {
            case 2:
            case 4:
            case 6:
                return true;
            }

        }
        return false;
    }

}
