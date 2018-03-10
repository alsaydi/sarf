package sarf.noun.trilateral.unaugmented.modifier.exaggeration.hamza;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class NakesLafifMahmouz extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public NakesLafifMahmouz() {

        substitutions.add(new InfixSubstitution("اءٌ","اءٌ"));// EX: (غزّاءٌ، رمَّاءٌ، مِعطاءٌ، مِجناء، مِعواء، مِيفاء)
        substitutions.add(new InfixSubstitution("اءً","اءً"));// EX: (مِعطاءً ،  )
        substitutions.add(new InfixSubstitution("اءٍ","اءٍ"));// EX: (مِعطاءٍ ،   )
        substitutions.add(new SuffixSubstitution("اءُ","اءُ"));// EX: (المعطاءُ )
        substitutions.add(new SuffixSubstitution("اءِ","اءِ"));// EX: (المعطاءِ )
        substitutions.add(new SuffixSubstitution("آَّءُ","آَّءُ"));// EX: (مَآَّءُ )
        substitutions.add(new SuffixSubstitution("آَّءِ","آَّءِ"));// EX: (مَآَّءِ )
        substitutions.add(new InfixSubstitution("آَّءُ","آَّؤُ"));// EX: (مَآَّؤُونَ )
        substitutions.add(new InfixSubstitution("آَّءِ","آَّئِ"));// EX: (مَآَّئِينَ )
        substitutions.add(new InfixSubstitution("اءُ","اؤُ"));// EX: (معطاؤونَ )
        substitutions.add(new InfixSubstitution("اءِ","ائِ"));// EX: (معطائِينَ )

    }


    public List getSubstitutions() {
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
