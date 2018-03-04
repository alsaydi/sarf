package sarf.noun.trilateral.unaugmented.modifier.exaggeration.vocalizer;

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
public class I2Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public I2Vocalizer() {

        substitutions.add(new InfixSubstitution("öíñ","ò"));// EX: (åĞÇ ãóÖò¡ Úóæò¡ æóŞò)
        substitutions.add(new InfixSubstitution("öíò","ò"));// EX: (ãÑÑÊõ Úáì ãóÖò)
        substitutions.add(new SuffixSubstitution("öíõ","öí"));// EX: (åĞÇ ÇáãóÖöí¡ )
        substitutions.add(new SuffixSubstitution("öíó","öíó"));// EX: (ÑÃíÊõ ÇáãóÖöíó¡ )
        substitutions.add(new SuffixSubstitution("öíö","öí"));// EX: (ãÑÑÊõ Úáì ÇáãóÖöí ¡ )
        substitutions.add(new InfixSubstitution("öíõ","õ"));// EX: (ãóÖõæäó¡ )
        substitutions.add(new InfixSubstitution("öíö","ö"));// EX: (ãóÖöíäó¡ )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        if (!nounFormula.equals("İóÚöá")) {
            return false;
        }

        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 26:
            switch (noc) {
            case 2:
            case 3:
            case 4:
                return true;
            }
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
