package sarf.ui;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import sarf.AugmentationFormula;
import sarf.SarfDictionary;
import sarf.Validator;
import sarf.kov.KovRulesManager;
import sarf.kov.TrilateralKovRule;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;

public class ConsoleApp {
	public static void main(String[] args) {
		try {
			(new ConsoleApp()).Run();
		} catch (Exception ex) {
			System.err.println(ex.getStackTrace());
			System.exit(1);
		}
	}

	void Run() throws Exception {
		Scanner scanner = new Scanner(System.in);
		String root = scanner.nextLine();
		System.out.println(root);

		if (root.length() == 3) {
			processTrilateral(root);
		} else if (root.length() == 4) {
			// processQuadrilateral(root);
		} else {
			System.err.printf("%s ليس جذراً مقبولاً", root);
		}
	}

	private void processTrilateral(String root) throws Exception {
		AugmentedTrilateralRoot augmentedRoot = SarfDictionary.getInstance().getAugmentedTrilateralRoot(root);
		List unaugmentedList = SarfDictionary.getInstance().getUnaugmentedTrilateralRoots(root);
		if (augmentedRoot == null && unaugmentedList.isEmpty()) {
			displayErrorMessage(root + ": لم يرد هذا الجذر في قاعدة المعطيات");
		} else {
			displayTrilateral(root, augmentedRoot, unaugmentedList);
		}
	}

	private void displayTrilateral(String rootText, AugmentedTrilateralRoot augmentedRoot, List unaugmentedList) {
		char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);

        TrilateralKovRule rule = KovRulesManager.getInstance().getTrilateralKovRule(c1, c2, c3);
        String kovText = rule.getDesc();
        int kov = rule.getKov();
        
        System.out.println("نوع الفعل: " + kovText);
//        if(augmentedRoot != null) {
//        	Iterator itr = augmentedRoot.getAugmentationList();
//        	while(itr.hasNext()) {
//        		AugmentationFormula forumla = itr.next();
//        		System.out.println(forumla.getFormulaNo());
//        	}
//        }
	}

	private static void displayErrorMessage(String message) {
		System.err.printf("%s - %s\n", LocalDateTime.now().toString(), message);
	}
}
