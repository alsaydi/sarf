package sarf.noun.trilateral.augmented.modifier.activeparticiple.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.IAugmentedTrilateralModifier;
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
public class YaeiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public YaeiNakesLafifVocalizer() {
        substitutions.add(new SuffixSubstitution("öíõ", "öí")); // EX: (åĞÇ ÇáãõåúÏöí¡ )
        substitutions.add(new SuffixSubstitution("öíó", "öíó")); // EX: (ÑÃíÊõ ÇáãõåúÏöíó¡ )
        substitutions.add(new SuffixSubstitution("öíö", "öí")); // EX: (ãÑÑÊõ Úáì ÇáãõåúÏöí ¡ )
        substitutions.add(new InfixSubstitution("öíñ", "ò")); // EX: (åĞÇ ãõåúÏò)
        substitutions.add(new InfixSubstitution("öíò", "ò")); // EX: (ãÑÑÊõ Úáì ãõåúÏò)
        substitutions.add(new InfixSubstitution("öíõ", "õ")); // EX: (ãõåúÏõæäó¡ )
        substitutions.add(new InfixSubstitution("öíö", "ö")); // EX: (ãõåúÏöíäó¡ )
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'í')
            return false;

        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 24:
        case 30:
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

        case 25:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 11:
                return true;
            }

        case 26:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            }

        case 27:
            switch (formulaNo) {
            case 1:
            case 2:
            case 5:
            case 7:
            case 8:
            case 9:
                return true;
            }

        case 28:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
                return true;
            }

        case 29:
            switch (formulaNo) {
            case 5:
            case 7:
            case 9:
                return true;
            }

        }
        return false;
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
