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
public class WawiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public WawiNakesLafifVocalizer() {
        substitutions.add(new InfixSubstitution("óæóÇÊ","óíóÇÊ"));// EX: (ãõÍÇÈóíÇÊ)
        substitutions.add(new InfixSubstitution("óÇæóæó","óÇæóÇ"));// EX: (ãõÓÇæÇÉ)
        substitutions.add(new SuffixSubstitution("õæõ","öí"));// EX: (åĞÇ ÇáÊÓÇãí¡ ÇáÊÒßøöí)
        substitutions.add(new SuffixSubstitution("õæó","öíó"));// EX: (ÑÃíÊõ ÇáÊÓÇãíó¡ ÇáÊÒßøöíó)
        substitutions.add(new SuffixSubstitution("õæö","öí"));// EX: (ÈÇáÊÓÇãöí ¡ ÈÇáÊÒßøöí)
        substitutions.add(new InfixSubstitution("õæñ","ò"));// EX: (åĞÇ ÊÓÇãò¡ ÊóÒóßøò)
        substitutions.add(new InfixSubstitution("õæò","ò"));// EX: (ÈöÊóÓÇãò¡ ÊóÒóßøò)
        substitutions.add(new InfixSubstitution("õæğ","öíğ"));// EX: (ÊÓÇãöíğÇ¡ ÊóÒóßøöíğÇ)
        substitutions.add(new InfixSubstitution("õæó","öíó"));// EX: (ÊÓÇãöíÇä¡ ÊóÒóßøöíóÇä)
        substitutions.add(new InfixSubstitution("óÇæğÇ","óÇÁğ"));// EX: (ÅÎÇÁğ)
        substitutions.add(new InfixSubstitution("óÇæ","óÇÁ"));// EX: (ÅÏäÇÁ¡ ÍöÈÇÁ¡ ÇäÌáÇÁ¡ ÇÑÊÖÇÁ¡ ÇÑÚæÇÁ¡ ÇÓÊÑÖÇÁ¡ ÇÍáíáÇÁ)
        substitutions.add(new InfixSubstitution("óæó","óÇ"));// EX: (ãõÍÇÈÇÉ)
        substitutions.add(new InfixSubstitution("öíæ","öí"));// EX: (ÊÓãíÉ)
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'æ')
            return false;

        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 21:
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

        case 22:
            switch (formulaNo) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                return true;
            }

        case 23:
            switch (formulaNo) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
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
            case 11:
                return true;
            }
        }
        return false;
    }

    public List getSubstitutions() {
        return substitutions;
    }
}
