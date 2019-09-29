package sarf.verb.trilateral.augmented.modifier;

import java.util.*;

import sarf.ConjugationResult;
import sarf.substitution.SubstitutionsApplier;


/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: تطبيق الابدال </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class Substituter {

    //حسب التحليل فإن الماضي والمضارع والأمر تشترك في الابدال للمعلوم
    //ولكن للمجهول يختلف فقط الماضي أما المضارع فهو نفسه في المعلوم
    private final List<SubstitutionsApplier> activeList = new LinkedList<>();
    private final List<SubstitutionsApplier> passiveList = new LinkedList<>();


    Substituter() {
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter1());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter2());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter3());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter4());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter5());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter6());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter7());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.GenericSubstituter8());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.SpecialSubstituter1());
        activeList.add(new sarf.verb.trilateral.augmented.modifier.substituter.active.SpecialSubstituter2());

        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter1());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter2());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter3());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter4());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter5());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter6());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter7());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.GenericSubstituter8());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.SpecialSubstituter1());
        passiveList.add(new sarf.verb.trilateral.augmented.modifier.substituter.passive.SpecialSubstituter2());

    }

    public void apply(String tense, boolean active, ConjugationResult conjResult) {
        List<SubstitutionsApplier> modifiers;
        modifiers = active ? activeList : passiveList;

        for (SubstitutionsApplier o : modifiers) {
            if (o.isApplied(conjResult)) {
                o.apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }
    }
}
