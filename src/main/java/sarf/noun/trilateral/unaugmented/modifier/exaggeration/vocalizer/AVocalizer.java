package sarf.noun.trilateral.unaugmented.modifier.exaggeration.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: الصيغة القياسية فهي غير واردة الرمز في قاعدة السماعي        </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class AVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List<Substitution> substitutions = new LinkedList<Substitution>();

    public AVocalizer() {
        substitutions.add(new InfixSubstitution("اوًا", "اءً")); // EX: (غَزَّاءً)
        substitutions.add(new InfixSubstitution("ايًا", "اءً")); // EX: (رمَّاءً)
        substitutions.add(new InfixSubstitution("او", "اء")); // EX: (غَزَّاءٌ)
        substitutions.add(new InfixSubstitution("اي", "اء")); // EX: (رمَّاءٌ)
    }


    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        if (!nounFormula.equals("فَعَّال")) {
            return false;
        }

        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 21:
            return Conjugation.First || noc == Conjugation.Fifth;
        case 22:
            return Conjugation.First || Conjugation.Third;
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
            return Conjugation.Third || noc == Conjugation.Forth;

        case 27:
        case 29:
            return noc == Conjugation.Second;
        case 28:
            return noc == Conjugation.Second || noc == Conjugation.Forth;
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
