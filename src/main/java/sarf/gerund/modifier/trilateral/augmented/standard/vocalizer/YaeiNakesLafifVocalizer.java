package sarf.gerund.modifier.trilateral.augmented.standard.vocalizer;

import java.util.*;

import sarf.ConjugationResult;
import sarf.KindOfVerb;
import sarf.noun.*;
import sarf.substitution.InfixSubstitution;
import sarf.substitution.Substitution;
import sarf.substitution.SuffixSubstitution;



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
public class YaeiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier{
    private final List<Substitution> substitutions = new ArrayList<>();

    public YaeiNakesLafifVocalizer() {
        substitutions.add(new InfixSubstitution("َادَيَات", "َادَيَات"));// EX: (مياداة)
        substitutions.add(new InfixSubstitution("َادَيَ", "َادَا"));// EX: (مياداة)
        substitutions.add(new InfixSubstitution("َيَات", "َيَات"));// EX: (مجاريات)
        substitutions.add(new InfixSubstitution("َايَيَ", "َايَا"));// EX: (مُحاياة)
        substitutions.add(new SuffixSubstitution("ُيُ", "ِي"));// EX: (هذا التناسي، الترقِّي)
        substitutions.add(new SuffixSubstitution("ُيَ", "ِيَ"));// EX: (رأيتُ التناسيَ ، الترقِّيَ)
        substitutions.add(new SuffixSubstitution("ُيِ", "ِي"));// EX: (بالتناسي ، بالترقِّي)
        substitutions.add(new InfixSubstitution("ُيٌ", "ٍ"));// EX: (هذا تناسٍ، ترقٍّ)
        substitutions.add(new InfixSubstitution("ُيٍ", "ٍ"));// EX: (بِتناسٍ، بترقٍّ)
        substitutions.add(new InfixSubstitution("ُيً", "ِيً"));// EX: (تناسِيًا، ترقِّيًا)
        substitutions.add(new InfixSubstitution("ُيَ", "ِيَ"));// EX: (تناسيان، ترقِّيان)
        substitutions.add(new InfixSubstitution("َايًا", "َاءً"));// EX: (إساءً)
        substitutions.add(new InfixSubstitution("َاي", "َاء"));// EX: (إهداء، جراء، انثناء، اكتفاء، استغناء، اعريراء)
        substitutions.add(new InfixSubstitution("َيَ", "َا"));// EX: (مجاراة)
        substitutions.add(new InfixSubstitution("ِيي", "ِي"));// EX: (ترقية)
    }

    public boolean isApplied(ConjugationResult triAugmentedConjugationResult) {
        KindOfVerb kov = triAugmentedConjugationResult.getKov();
        int formulaNo = triAugmentedConjugationResult.getFormulaNo();

        if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Faa || kov == KindOfVerb.Lafeef_Mafrooq) {
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


            switch (formulaNo) {
                case 4:
                case 11:
                    return true;
            }


            return formulaNo == 10;


        } else if (kov == KindOfVerb.Naqis_Yaee_Mahmouz_Ain) {
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


            return formulaNo == 10;


        } else if (kov == KindOfVerb.Naqis_Yaee) {
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


        } else if (kov == KindOfVerb.Lafeef_Maqroon_Mahmouz_Faa) {
            switch (formulaNo) {
                case 1:
                case 2:
                case 5:
                case 7:
                case 8:
                case 9:
                    return true;
            }


            switch (formulaNo) {
                case 3:
                case 4:
                    return true;
            }


        } else if (kov == KindOfVerb.Lafeef_Maqroon) {
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


        } else if (kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain) {
            switch (formulaNo) {
                case 5:
                case 7:
                case 9:
                    return true;
            }
        }
        return false;
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }
}
