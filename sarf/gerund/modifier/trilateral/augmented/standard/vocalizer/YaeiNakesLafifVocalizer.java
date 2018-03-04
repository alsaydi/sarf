package sarf.gerund.modifier.trilateral.augmented.standard.vocalizer;

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
        substitutions.add(new InfixSubstitution("óÇÏóíóÇÊ","óÇÏóíóÇÊ"));// EX: (ãíÇÏÇÉ)
        substitutions.add(new InfixSubstitution("óÇÏóíó","óÇÏóÇ"));// EX: (ãíÇÏÇÉ)
        substitutions.add(new InfixSubstitution("óíóÇÊ","óíóÇÊ"));// EX: (ãÌÇÑíÇÊ)
        substitutions.add(new InfixSubstitution("óÇíóíó","óÇíóÇ"));// EX: (ãõÍÇíÇÉ)
        substitutions.add(new SuffixSubstitution("õíõ","öí"));// EX: (åĞÇ ÇáÊäÇÓí¡ ÇáÊÑŞøöí)
        substitutions.add(new SuffixSubstitution("õíó","öíó"));// EX: (ÑÃíÊõ ÇáÊäÇÓíó ¡ ÇáÊÑŞøöíó)
        substitutions.add(new SuffixSubstitution("õíö","öí"));// EX: (ÈÇáÊäÇÓí ¡ ÈÇáÊÑŞøöí)
        substitutions.add(new InfixSubstitution("õíñ","ò"));// EX: (åĞÇ ÊäÇÓò¡ ÊÑŞøò)
        substitutions.add(new InfixSubstitution("õíò","ò"));// EX: (ÈöÊäÇÓò¡ ÈÊÑŞøò)
        substitutions.add(new InfixSubstitution("õíğ","öíğ"));// EX: (ÊäÇÓöíğÇ¡ ÊÑŞøöíğÇ)
        substitutions.add(new InfixSubstitution("õíó","öíó"));// EX: (ÊäÇÓíÇä¡ ÊÑŞøöíÇä)
        substitutions.add(new InfixSubstitution("óÇíğÇ","óÇÁğ"));// EX: (ÅÓÇÁğ)
        substitutions.add(new InfixSubstitution("óÇí","óÇÁ"));// EX: (ÅåÏÇÁ¡ ÌÑÇÁ¡ ÇäËäÇÁ¡ ÇßÊİÇÁ¡ ÇÓÊÛäÇÁ¡ ÇÚÑíÑÇÁ)
        substitutions.add(new InfixSubstitution("óíó","óÇ"));// EX: (ãÌÇÑÇÉ)
        substitutions.add(new InfixSubstitution("öíí","öí"));// EX: (ÊÑŞíÉ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
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
