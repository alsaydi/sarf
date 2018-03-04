package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

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
public class YaeiLafifNakesVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public YaeiLafifNakesVocalizer() {
        substitutions.add(new InfixSubstitution("öíñ", "ò")); // EX: (åĞÇ ÑÇãò)
        substitutions.add(new InfixSubstitution("öíò", "ò")); // EX: (ãÑÑÊõ Úáì ÑÇãò)
        substitutions.add(new SuffixSubstitution("öíõ", "öí")); // EX: (åĞÇ ÇáÑÇãí¡ ÑÇãí ÇáÓåã¡ )
        substitutions.add(new SuffixSubstitution("öíó", "öíó")); // EX: (ÑÃíÊõ ÇáÑÇãíó¡ ÑÇãíó ÇáÓåã¡ )
        substitutions.add(new SuffixSubstitution("öíö", "öí")); // EX: (ãÑÑÊõ Úáì ÇáÑÇãí¡ ÑÇãí ÇáÓåã ¡ )
        substitutions.add(new InfixSubstitution("öíõ", "õ")); // EX: (ÑÇãõæäó¡ )
        substitutions.add(new InfixSubstitution("öíö", "ö")); // EX: (ÑÇãöíäó¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
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
