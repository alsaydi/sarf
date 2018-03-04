package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.passive;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class PresentVocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PresentVocalizer() {
        substitutions.add(new SuffixSubstitution("óíõ","óì"));// EX: (íõåúÏóì¡ íõÑóŞøóì¡ íõÌÇÑóì¡ íõäËäóì¡ íõßÊİì¡ íõÊäÇÓì¡ íõÊÑŞøóì¡ íõÓÊÛäì¡ íõÚÑæÑì¡ íõÌúÃæøóì)
        substitutions.add(new SuffixSubstitution("íó", "ì")); // EX: (áä íõåúÏóì¡ íõÑóŞøóì¡ íõÌÇÑóì¡ íõäËäóì¡ íõßÊİì¡ íõÊäÇÓì¡ íõÊÑŞøóì¡ íõÓÊÛäì¡ íõÚÑæÑì¡ íõÌúÃæøóì)
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (áã íõåúÏó¡ íõÑóŞøó¡ íõÌÇÑó¡ íõäËäó¡ íõßÊİ¡ íõÊäÇÓ¡ íõÊÑŞøó¡ íõÓÊÛä¡ íõÚÑæÑ¡ íõÌúÃæøó)
        substitutions.add(new InfixSubstitution("íöí", "íú")); // EX: (ÃäÊö ÊõåúÏóíúäó¡ ÊõÑóŞøóíúäó¡ ÊõÌÇÑóíúäó¡ ÊõäËäóíúäó¡ ÊõßÊİíúäó¡ ÊõÊäÇÓóíúäó¡ ÊõÊÑŞøóíúäó¡ ÊõÓÊÛäóíúäó¡ ÊõÚÑæÑóíúäó¡ ÊõÌúÃæøóíúäó)
        substitutions.add(new InfixSubstitution("íõæ", "æú")); // EX: (ÃäÊã ÊõåúÏóæúäó¡ ÊõÑóŞøóæúäó¡ ÊõÌÇÑóæúäó¡ ÊõäËäóæúäó¡ ÊõßÊİæúäó¡ ÊõÊäÇÓóæúäó¡ ÊõÊÑŞøóæúäó¡ ÊõÓÊÛäóæúäó¡ ÊõÚÑæÑóæúäó¡ ÊõÌúÃæøóæúäó)
        substitutions.add(new InfixSubstitution("íõäøó","æõäøó"));// EX: (ÃäÊä ÊõåúÏóæõäøó¡ ÊõÑóŞøóæõäøó¡ ÊõÌÇÑóæõäøó¡ ÊõäËäóæõäøó¡ ÊõßÊİæõäøó¡ ÊõÊäÇÓóæõäøó¡ ÊõÊÑŞøóæõäøó¡ ÊõÓÊÛäóæõäøó¡ ÊõÚÑæÑóæõäøó¡ ÊõÌúÃæøóæõäøó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        switch (kov) {
        case 24:
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

        }
        return false;
    }
}
