package sarf.noun.quadriliteral.augmented;

import sarf.PastConjugationDataContainer;
import java.util.Map;
import java.util.HashMap;
import sarf.verb.quadriliteral.augmented.AugmentedPastVerb;
import sarf.verb.quadriliteral.augmented.AugmentedQuadriliteralRoot;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import sarf.AugmentationFormula;
import sarf.noun.quadriliteral.*;
import sarf.noun.GenericNounSuffixContainer;

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
public class AugmentedQuadriliteralPassiveParticipleConjugator {
    private AugmentedQuadriliteralPassiveParticipleConjugator() {
    }

    private static AugmentedQuadriliteralPassiveParticipleConjugator instance = new AugmentedQuadriliteralPassiveParticipleConjugator();

    public static AugmentedQuadriliteralPassiveParticipleConjugator getInstance() {
        return instance;
    }

    public AugmentedQuadriliteralNoun createNoun(AugmentedQuadriliteralRoot root, int suffixIndex, int formulaNo) {
        String suffix = GenericNounSuffixContainer.getInstance().get(suffixIndex);
        String formulaClassName = getClass().getPackage().getName()+".passiveparticiple."+"NounFormula"+formulaNo;
        Object [] parameters = {root, suffix};

        try {
            AugmentedQuadriliteralNoun noun = (AugmentedQuadriliteralNoun) Class.forName(formulaClassName).getConstructors()[0].newInstance(parameters);
            return noun;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List createNounList(AugmentedQuadriliteralRoot root, int formulaNo) {
        List result = new LinkedList();
        for (int i = 0; i < 18; i++) {
            AugmentedQuadriliteralNoun noun = createNoun(root, i, formulaNo);
            result.add(noun);
        }

        return result;
    }

    //ÊÓÊÚãá Ýí ÇÓã ÇáÒãÇä æÇáãßÇä æÇáãÕÏÑ Çáãíãí
    private List createNounList(AugmentedQuadriliteralRoot root, int formulaNo, List indecies) {
        List result = new LinkedList();

        for (int i=0; i<18; i++) {
            result.add("");
        }

        for (int i = 0; i < indecies.size(); i++) {
            int index = Integer.parseInt(indecies.get(i).toString());
            AugmentedQuadriliteralNoun noun = createNoun(root, index, formulaNo);
            result.set(index, noun);
        }

        return result;

    }

    static List timeAndPlaceIndeciesList = new LinkedList();
    static {
        //ÍÐÝ ÇáãÄäË æÇáÌãÚ
        timeAndPlaceIndeciesList.add("0");
        timeAndPlaceIndeciesList.add("2");
        timeAndPlaceIndeciesList.add("6");
        timeAndPlaceIndeciesList.add("8");
        timeAndPlaceIndeciesList.add("12");
        timeAndPlaceIndeciesList.add("14");

    }

    public List createTimeAndPlaceNounList(AugmentedQuadriliteralRoot root, int formulaNo) {
        return createNounList(root, formulaNo, timeAndPlaceIndeciesList);
    }


    static List meemGerundIndeciesList = new LinkedList();
    static {
        //ÇáãÐßÑ ÇáãÝÑÏ
        meemGerundIndeciesList.add("0");
        meemGerundIndeciesList.add("6");
        meemGerundIndeciesList.add("12");
    }

    public List createMeemGerundNounList(AugmentedQuadriliteralRoot root, int formulaNo) {
        return createNounList(root, formulaNo, meemGerundIndeciesList);
    }



}
