package sarf.noun.quadriliteral.unaugmented;

import sarf.verb.quadriliteral.unaugmented.*;
import sarf.noun.*;
import java.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: إنشاء اسم المفعول الرباعي المجرد    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class UnaugmentedQuadriliteralPassiveParticipleConjugator {
    private UnaugmentedQuadriliteralPassiveParticipleConjugator() {
    }

    private static UnaugmentedQuadriliteralPassiveParticipleConjugator instance = new UnaugmentedQuadriliteralPassiveParticipleConjugator();

    public static UnaugmentedQuadriliteralPassiveParticipleConjugator getInstance() {
        return instance;
    }

    public UnaugmentedQuadriliteralPassiveParticiple createNoun(UnaugmentedQuadrilateralRoot root, int suffixIndex) {
        String suffix = GenericNounSuffixContainer.getInstance().get(suffixIndex);
        return new UnaugmentedQuadriliteralPassiveParticiple(root, suffix);
    }

    public List createNounList(UnaugmentedQuadrilateralRoot root) {
        List result = new ArrayList(18);
        for (int i=0; i<18; i++)
            result.add(createNoun(root, i));
        return result;
    }

    //تستعمل في اسم الزمان والمكان والمصدر الميمي
    private List createNounList(UnaugmentedQuadrilateralRoot root, List indecies) {
        List result = new LinkedList();

        for (int i=0; i<18; i++) {
            result.add("");
        }

        for (int i = 0; i < indecies.size(); i++) {
            int index = Integer.parseInt(indecies.get(i).toString());
            UnaugmentedQuadriliteralPassiveParticiple noun = createNoun(root, index);
            result.set(index, noun);
        }

        return result;

    }

    static List timeAndPlaceIndeciesList = new LinkedList();
    static {
        //حذف المؤنث والجمع
        timeAndPlaceIndeciesList.add("0");
        timeAndPlaceIndeciesList.add("2");
        timeAndPlaceIndeciesList.add("6");
        timeAndPlaceIndeciesList.add("8");
        timeAndPlaceIndeciesList.add("12");
        timeAndPlaceIndeciesList.add("14");
    }

    public List createTimeAndPlaceNounList(UnaugmentedQuadrilateralRoot root) {
        return createNounList(root, timeAndPlaceIndeciesList);
    }

    static List meemGerundIndeciesList = new LinkedList();
    static {
        //المذكر المفرد
        meemGerundIndeciesList.add("0");
        meemGerundIndeciesList.add("6");
        meemGerundIndeciesList.add("12");
    }

    public List createMeemGerundNounList(UnaugmentedQuadrilateralRoot root) {
        return createNounList(root, meemGerundIndeciesList);
    }



}
