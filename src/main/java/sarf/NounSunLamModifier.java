package sarf;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.TrilateralRoot;

/**
 * <p>
 * Title: Sarf Program
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 *
 * <p>
 * Company: ALEXO
 * </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class NounSunLamModifier extends SubstitutionsApplier {
	private static List<String> appliedPronounsIndexes = new ArrayList<>(13);
	static {
		for (int i = 0; i < 18; i++) {
			appliedPronounsIndexes.add(i + 1 + "");
		}
	}

	private List<Substitution> substitutions = new LinkedList<>();

	private NounSunLamModifier() {
		List<String> sunLetters = new LinkedList<>();
		sunLetters.add("ت");
		sunLetters.add("ث");
		sunLetters.add("د");
		sunLetters.add("ذ");
		sunLetters.add("ر");
		sunLetters.add("ز");
		sunLetters.add("س");
		sunLetters.add("ش");
		sunLetters.add("ص");
		sunLetters.add("ض");
		sunLetters.add("ط");
		sunLetters.add("ظ");
		sunLetters.add("ل");
		sunLetters.add("ن");

		substitutions.add(new ListedInfixSubstitution(sunLetters, "الSLَ", "الSLَّ"));
		substitutions.add(new ListedInfixSubstitution(sunLetters, "الSLُ", "الSLُّ"));
		substitutions.add(new ListedInfixSubstitution(sunLetters, "الSLِ", "الSLِّ"));
	}

	private static NounSunLamModifier instance = new NounSunLamModifier();

	public static NounSunLamModifier getInstance() {
		return instance;
	}

	public void apply(sarf.verb.trilateral.unaugmented.ConjugationResult conjResult) {
		apply(conjResult.getFinalResult(), null);
	}

	public void apply(sarf.verb.trilateral.augmented.ConjugationResult conjResult) {
		apply(conjResult.getFinalResult(), null);
	}

	public void apply(sarf.verb.quadriliteral.ConjugationResult conjResult) {
		apply(conjResult.getFinalResult(), null);
	}

	public List<Substitution> getSubstitutions() {
		return substitutions;
	}

	protected List<String> getAppliedPronounsIndecies() {
		return appliedPronounsIndexes;
	}

	class ListedInfixSubstitution extends Substitution {
		private List<String> probableChars;

		ListedInfixSubstitution(List<String> probableChars, String segment, String result) {
			super(segment, result);
			this.probableChars = probableChars;
		}

		/**
		 *
		 * @param word
		 *            String
		 * @return String
		 */
		public String apply(String word, TrilateralRoot root) {
			for (String sl : probableChars) {
				String appliedResult = apply(word, sl);
				if (appliedResult != null) {
					return appliedResult;
				}
			}
			return null;
		}

		private String apply(String word, String sl) {
			String wordSegment = segment.replaceAll("SL", sl);

			if (!word.contains(wordSegment)) {
				return null;
			}

			String replacedResult = result.replaceAll("SL", sl);
			return word.replaceAll(wordSegment, replacedResult);
		}
	}
}
