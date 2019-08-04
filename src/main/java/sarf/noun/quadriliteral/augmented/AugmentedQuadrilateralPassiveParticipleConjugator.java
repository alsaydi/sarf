package sarf.noun.quadriliteral.augmented;

import com.google.inject.Inject;
import sarf.SystemConstants;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;

import java.util.ArrayList;
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
public class AugmentedQuadrilateralPassiveParticipleConjugator {
    private final GenericNounSuffixContainer genericNounSuffixContainer;

    @Inject
    public AugmentedQuadrilateralPassiveParticipleConjugator(GenericNounSuffixContainer genericNounSuffixContainer){
        this.genericNounSuffixContainer = genericNounSuffixContainer;
    }

    private AugmentedQuadrilateralNoun createNoun(AugmentedQuadrilateralRoot root, int suffixIndex, int formulaNo) {
        String suffix = genericNounSuffixContainer.get(suffixIndex);
        String formulaClassName = getClass().getPackage().getName()+".passiveparticiple."+"NounFormula"+formulaNo;
        Object [] parameters = {root, suffix, genericNounSuffixContainer};

        try {
            return (AugmentedQuadrilateralNoun) Class.forName(formulaClassName)
                    .getConstructor(root.getClass(), suffix.getClass(), genericNounSuffixContainer.getClass())
                    .newInstance(parameters);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<AugmentedQuadrilateralNoun> createNounList(AugmentedQuadrilateralRoot root, int formulaNo) {
        List<AugmentedQuadrilateralNoun> result = new ArrayList<>();
        for (int i = 0; i < SystemConstants.NOUN_POSSIBLE_STATES; i++) {
            AugmentedQuadrilateralNoun noun = createNoun(root, i, formulaNo);
            result.add(noun);
        }
        return result;
    }

    //تستعمل في اسم الزمان والمكان والمصدر الميمي
    private List createNounList(AugmentedQuadrilateralRoot root, int formulaNo, List indecies) {
        List result = new ArrayList<>();
        for (int i=0; i<SystemConstants.NOUN_POSSIBLE_STATES; i++) { //TODO: strong typing needed here
            result.add("");
        }

        for (int i = 0; i < indecies.size(); i++) {
            int index = Integer.parseInt(indecies.get(i).toString());
            AugmentedQuadrilateralNoun noun = createNoun(root, index, formulaNo);
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

    public List createTimeAndPlaceNounList(AugmentedQuadrilateralRoot root, int formulaNo) {
        return createNounList(root, formulaNo, timeAndPlaceIndeciesList);
    }


    static final List meemGerundIndeciesList = new LinkedList();
    static {
        //المذكر المفرد
        meemGerundIndeciesList.add("0");
        meemGerundIndeciesList.add("6");
        meemGerundIndeciesList.add("12");
    }

    public List createMeemGerundNounList(AugmentedQuadrilateralRoot root, int formulaNo) {
        return createNounList(root, formulaNo, meemGerundIndeciesList);
    }
}
