package sarf;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.verb.trilateral.TrilateralRoot;
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

    public List<UnaugmentedTrilateralRoot> getUnaugmentedTrilateralRoots(String rootText) throws Exception {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);

        var unaugmentedRootsTree = DatabaseManager.getInstance().getUnaugmentedTrilateralRootTree(c1);
        var roots = unaugmentedRootsTree.getRoots();
        return roots.stream()
                .filter(root -> match(root, c1, c2, c3))
                .collect(Collectors.toList());
    }

    public AugmentedTrilateralRoot getAugmentedTrilateralRoot(String rootText) throws Exception {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);

        var augmentedRootsTree = DatabaseManager.getInstance().getAugmentedTrilateralRootTree(c1);
        var roots = augmentedRootsTree.getRoots();
        return roots.stream()
                .filter(root -> match(root, c1, c2, c3))
                .findFirst()
                .orElse(null);
    }

    public AugmentedQuadrilateralRoot getAugmentedQuadrilateralRoot(String rootText) {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);
        char c4 = rootText.charAt(3);

        AugmentedQuadriliteralRootTree augmentedRootsTree;
        try {
            augmentedRootsTree = DatabaseManager.getInstance().getAugmentedQuadrilateralRootTree(c1);
        } catch (Exception ex) {
            //الملف غير موجود
            return null;
        }
        var roots = augmentedRootsTree.getRoots();
        return roots.stream()
                .filter(root -> match(root, c1, c2, c3, c4))
                .findFirst()
                .orElse(null);
    }

    public UnaugmentedQuadrilateralRoot getUnaugmentedQuadrilateralRoot(String rootText) throws Exception {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);
        char c4 = rootText.charAt(3);

        var rootsTree = DatabaseManager.getInstance().getUnaugmentedQuadrilateralRootTree(c1);
        var roots = rootsTree.getRoots();

        return roots.stream()
                .filter(root -> match(root, c1, c2, c3, c4))
                .findFirst()
                .orElse(null);
    }

    private static boolean match(TrilateralRoot aRoot, char c1, char c2, char c3) {
        return aRoot.getC1() == c1 && aRoot.getC2() == c2 && aRoot.getC3() == c3;
    }

    private static boolean match(QuadrilateralRoot root, char c1, char c2, char c3, char c4) {
        return root.getC1() == c1
                && root.getC2() == c2
                && root.getC3() == c3
                && root.getC4() == c4;
    }
}
