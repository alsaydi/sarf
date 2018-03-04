package sarf.noun.trilateral.augmented.modifier.passiveparticiple.vocalizer;

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

        substitutions.add(new InfixSubstitution("Çíóíñ","ÇíğÇ"));// EX: (åĞÇ ãõÊóÍÇíğÇ)
        substitutions.add(new InfixSubstitution("ÇíóíğÇ","ÇíğÇ"));// EX: (ÑÃíÊõ ãõÊóÍÇíğÇ)
        substitutions.add(new InfixSubstitution("Çíóíò","ÇíğÇ"));// EX: (ãÑÑÊõ Úáì ãõÊóÍÇíğÇ)
        substitutions.add(new SuffixSubstitution("Çíóíõ","ÇíóÇ"));// EX: (åĞÇ ÇáãÊÍÇíÇ¡)
        substitutions.add(new SuffixSubstitution("Çíóíó","ÇíóÇ"));// EX: (ÑÃíÊõ ÇáãÊÍÇíÇ ¡  )
        substitutions.add(new SuffixSubstitution("Çíóíö","ÇíóÇ"));// EX: (ãÑÑÊõ Úáì ÇáãÊÍÇíÇ ¡ )
        substitutions.add(new InfixSubstitution("úíóíñ","úíğÇ"));// EX: (åĞÇ ãõÓÊÍíğÇ)
        substitutions.add(new InfixSubstitution("úíóíğÇ","úíğÇ"));// EX: (ÑÃíÊõ ãõÓÊÍíğÇ)
        substitutions.add(new InfixSubstitution("úíóíò","úíğÇ"));// EX: (ãÑÑÊõ Úáì ãõÓÊÍíğÇ)
        substitutions.add(new SuffixSubstitution("úíóíõ","úíóÇ"));// EX: (åĞÇ ÇáãÓÊÍíÇ¡)
        substitutions.add(new SuffixSubstitution("úíóíó","úíóÇ"));// EX: (ÑÃíÊõ ÇáãÓÊÍíÇ ¡  )
        substitutions.add(new SuffixSubstitution("úíóíö","úíóÇ"));// EX: (ãÑÑÊõ Úáì ÇáãÓÊÍíÇ ¡ )

        substitutions.add(new InfixSubstitution("óíóíñ", "óíğÇ")); // EX: (åĞÇ ãõÒÏóíğÇ)
        substitutions.add(new InfixSubstitution("óíóíğÇ", "óíğÇ")); // EX: (ÑÃíÊõ ãõÒÏóíğÇ)
        substitutions.add(new InfixSubstitution("óíóíò", "óíğÇ")); // EX: (ãÑÑÊõ Úáì ãõÒÏóíğÇ)
        substitutions.add(new InfixSubstitution("óíøóíñ", "óíøğÇ")); // EX: (åĞÇ ãõÍóíøğÇ)
        substitutions.add(new InfixSubstitution("óíøóíğÇ", "óíøğÇ")); // EX: (ÑÃíÊõ ãõÍóíøğÇ)
        substitutions.add(new InfixSubstitution("óíøóíò", "óíøğÇ")); // EX: (ãÑÑÊõ Úáì ãõÍóíøğÇ)
        substitutions.add(new SuffixSubstitution("óíóíõ", "óíóÇ")); // EX: (åĞÇ ÇáãõÒÏóíÇ¡)
        substitutions.add(new SuffixSubstitution("óíóíó", "óíóÇ")); // EX: (ÑÃíÊõ ÇáãõÒÏóíÇ ¡  )
        substitutions.add(new SuffixSubstitution("óíóíö", "óíóÇ")); // EX: (ãÑÑÊõ Úáì ÇáãõÒÏóíÇ ¡ )
        substitutions.add(new SuffixSubstitution("óíøóíõ", "óíøóÇ")); // EX: (åĞÇ ÇáãõÍíøóÇ¡)
        substitutions.add(new SuffixSubstitution("óíøóíó", "óíøóÇ")); // EX: (ÑÃíÊõ ÇáãõÍíøóÇ ¡  )
        substitutions.add(new SuffixSubstitution("óíøóíö", "óíøóÇ")); // EX: (ãÑÑÊõ Úáì ÇáãõÍíøóÇ ¡ )
        substitutions.add(new InfixSubstitution("óíóÉ", "óÇÉ")); // EX: (ãõåúÏóÇÉñ¡)
        substitutions.add(new InfixSubstitution("óíóÊ", "óÇÊ")); // EX: (ãõåúÏÇÊÇäö¡ ãõåÏÇÊóíúäö)
        substitutions.add(new InfixSubstitution("óíõæ", "óæú")); // EX: (ãõåúÏóæäó)
        substitutions.add(new InfixSubstitution("óíöí", "óíú")); // EX: (ãõåúÏóíúäó)
        substitutions.add(new SuffixSubstitution("óíõ", "óì")); // EX: (åĞÇ ÇáãõåúÏóì¡)
        substitutions.add(new SuffixSubstitution("óíó", "óì")); // EX: (ÑÃíÊõ ÇáãõåúÏóì ¡  )
        substitutions.add(new SuffixSubstitution("óíö", "óì")); // EX: (ãÑÑÊõ Úáì ÇáãõåúÏóì ¡ )
        substitutions.add(new InfixSubstitution("óíñ", "ğì")); // EX: (åĞÇ ãõåúÏğì)
        substitutions.add(new InfixSubstitution("óíğÇ", "ğì")); // EX: (ÑÃíÊõ ãõåúÏğì)
        substitutions.add(new InfixSubstitution("óíò", "ğì")); // EX: (ãÑÑÊõ Úáì ãõåúÏğì)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'í') {
            return false;
        }

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
