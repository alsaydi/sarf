package sarf;

import java.util.*;

import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.unaugmented.*;

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
public class SarfDictionary {
    private static final SarfDictionary instance = new SarfDictionary();

    public static SarfDictionary getInstance() {
        return instance;
    }

    public AugmentedTrilateralRoot getAugmentedTrilateralRoot(String rootText) throws Exception {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);

        AugmentedTrilateralRootTree augmentedRootsTree = DatabaseManager.getInstance().getAugmentedTrilateralRootTree(c1);
        List<AugmentedTrilateralRoot> roots = augmentedRootsTree.getRoots();
        for (AugmentedTrilateralRoot aRoot : roots) {
            if (aRoot.getC1() == c1 && aRoot.getC2() == c2 && aRoot.getC3() == c3) {
                return aRoot;
            }
        }
        return null;
    }

    public List<UnaugmentedTrilateralRoot> getUnaugmentedTrilateralRoots(String rootText) throws Exception {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);

        UnaugmentedTrilateralRootTree unaugmentedRootsTree = DatabaseManager.getInstance().getUnaugmentedTrilateralRootTree(c1);
        List<UnaugmentedTrilateralRoot> roots = unaugmentedRootsTree.getRoots();
        java.util.List<UnaugmentedTrilateralRoot> result = new LinkedList<>();
        for (UnaugmentedTrilateralRoot root : roots) {
            if (root.getC1() == c1 && root.getC2() == c2 && root.getC3() == c3) {
                result.add(root);
            }
        }
        return result;
    }

    public AugmentedQuadrilateralRoot getAugmentedQuadrilateralRoot(String rootText) {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);
        char c4 = rootText.charAt(3);

        AugmentedQuadriliteralRootTree augmentedRootsTree = null;
        try {
            augmentedRootsTree = DatabaseManager.getInstance().getAugmentedQuadriliteralRootTree(c1);
        }
        catch (Exception ex) {
            //الملف غير موجود
            return null;
        }
        List roots = augmentedRootsTree.getRoots();
        Iterator iter = roots.iterator();
        while (iter.hasNext()) {
            AugmentedQuadrilateralRoot aRoot = (AugmentedQuadrilateralRoot) iter.next();
            if (aRoot.getC1() == c1 && aRoot.getC2() == c2 && aRoot.getC3() == c3 && aRoot.getC4() == c4) {
                return aRoot;
            }
        }
        return null;
    }

    public UnaugmentedQuadrilateralRoot getUnaugmentedQuadrilateralRoot(String rootText) throws Exception {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);
        char c4 = rootText.charAt(3);

        UnaugmentedQuadriliteralRootTree rootsTree = null;
        rootsTree = DatabaseManager.getInstance().getUnaugmentedQuadriliteralRootTree(c1);

        java.util.List roots = rootsTree.getRoots();

        Iterator iter = roots.iterator();
        while (iter.hasNext()) {
            UnaugmentedQuadrilateralRoot aRoot = (UnaugmentedQuadrilateralRoot) iter.next();
            if (aRoot.getC1() == c1 && aRoot.getC2() == c2 && aRoot.getC3() == c3 && aRoot.getC4() == c4) {
                return aRoot;
            }
        }

        return null;
    }


}
