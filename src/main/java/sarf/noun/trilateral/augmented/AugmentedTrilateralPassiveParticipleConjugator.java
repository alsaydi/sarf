package sarf.noun.trilateral.augmented;

import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

import java.util.LinkedList;
import java.util.List;

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
public class AugmentedTrilateralPassiveParticipleConjugator {
    private AugmentedTrilateralPassiveParticipleConjugator() {
    }

    private static final AugmentedTrilateralPassiveParticipleConjugator instance = new AugmentedTrilateralPassiveParticipleConjugator();

    public static AugmentedTrilateralPassiveParticipleConjugator getInstance() {
        return instance;
    }

    public AugmentedTrilateralNoun createNoun(AugmentedTrilateralRoot root, int suffixIndex, int formulaNo) {
        String suffix = GenericNounSuffixContainer.getInstance().get(suffixIndex);
        String formulaClassName = getClass().getPackage().getName()+".passiveparticiple."+"NounFormula"+formulaNo;
        Object [] parameters = {root, suffix};

        try {
            return (AugmentedTrilateralNoun) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createNounList(AugmentedTrilateralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            AugmentedTrilateralNoun noun = createNoun(root, i, formulaNo);
            result.add(noun);
        }

        return result;

    }

    //تستعمل في اسم الزمان والمكان والمصدر الميمي
    private List createNounList(AugmentedTrilateralRoot root, int formulaNo, List indecies) {
        List result = new LinkedList();

        for (int i=0; i<18; i++) {
            result.add("");
        }

        for (int i = 0; i < indecies.size(); i++) {
            int index = Integer.parseInt(indecies.get(i).toString());
            AugmentedTrilateralNoun noun = createNoun(root, index, formulaNo);
            result.set(index, noun);
        }


        return result;

    }

    static final List timeAndPlaceIndeciesList = new LinkedList();
    static {
        //حذف المؤنث والجمع
        timeAndPlaceIndeciesList.add("0");
        timeAndPlaceIndeciesList.add("2");
        timeAndPlaceIndeciesList.add("6");
        timeAndPlaceIndeciesList.add("8");
        timeAndPlaceIndeciesList.add("12");
        timeAndPlaceIndeciesList.add("14");

    }

    public List createTimeAndPlaceNounList(AugmentedTrilateralRoot root, int formulaNo) {
        return createNounList(root, formulaNo, timeAndPlaceIndeciesList);
    }

    static final List meemGerundIndeciesList = new LinkedList();
    static {
        //المذكر المفرد
        meemGerundIndeciesList.add("0");
        meemGerundIndeciesList.add("6");
        meemGerundIndeciesList.add("12");
    }

    public List createMeemGerundNounList(AugmentedTrilateralRoot root, int formulaNo) {
        return createNounList(root, formulaNo, meemGerundIndeciesList);
    }

}
