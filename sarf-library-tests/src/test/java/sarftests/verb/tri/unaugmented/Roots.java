package sarftests.verb.tri.unaugmented;
/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sarf.KindOfVerb;
import sarf.SarfDictionary;
import sarf.SystemConstants;
import sarf.Word;
import sarf.kov.KovRulesManager;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Roots {
    private final SarfDictionary sarfDictionary;
    private final KovRulesManager kovRulesManager;
    private final ActivePastConjugator activePastConjugator;
    private final ActivePresentConjugator activePresentConjugator;
    private final UnaugmentedTrilateralModifier modifier;

    @Inject
    public Roots(SarfDictionary sarfDictionary
            , KovRulesManager kovRulesManager
            , ActivePastConjugator activePastConjugator
            , ActivePresentConjugator activePresentConjugator
            , UnaugmentedTrilateralModifier modifier){
        this.sarfDictionary = sarfDictionary;
        this.kovRulesManager = kovRulesManager;
        this.activePastConjugator = activePastConjugator;
        this.activePresentConjugator = activePresentConjugator;
        this.modifier = modifier;
    }

    @When("I request all roots")
    public void iRequestAllRoots() {
    }

    @Then("for a verb {string} all tasareef {string} are returned")
    public void forAVerbAllTasareefAreReturned(String root, String csvTasareef) throws Exception {
        List<UnaugmentedTrilateralRoot> unaugmentedList = sarfDictionary.getUnaugmentedTrilateralRoots(root);

        var tasareefGroups = csvTasareef.split(",");
        assertThat(unaugmentedList).isNotNull();
        assertThat(unaugmentedList.size()).isEqualTo(tasareefGroups.length);

        for (var i = 0; i < tasareefGroups.length; i++){
            var tasreef = tasareefGroups[i].split(" ");
            var expectedPast = tasreef[0];
            var expectedPresent = tasreef[1];
            var transitivity = tasreef[2];
            var kov = getKindOfVerb(root);

            var currentRoot = unaugmentedList.get(i);
            var actualPast = getPastRootText(currentRoot, kov);
            assertThat(actualPast).isEqualTo(expectedPast);

            var actualPresent = getPresentRootText(currentRoot, kov);
            assertThat(actualPresent).isEqualTo(expectedPresent);

            var actualTransitivityValue = getTransitiveDescription(currentRoot.getTransitive());
            assertThat(actualTransitivityValue).isEqualTo(transitivity);
        }
    }

    private KindOfVerb getKindOfVerb(String root){
        var rule = kovRulesManager.getTrilateralKovRule(root.charAt(0), root.charAt(1), root.charAt(2));
        return rule.getKov();
    };

    private static String getTransitiveDescription(String type) {
        if (type.equals("م")) return "متعد";
        if (type.equals("ل")) return "لازم";
        if (type.equals("ك")) return "كلاهما";
        throw new IllegalArgumentException("نوع رمز اللزوم و التعدي غير معروف");
    }

    private String getPastRootText(UnaugmentedTrilateralRoot root, KindOfVerb kov) {
        String pastRootText = activePastConjugator.createVerb(7, root).toString();
        List<Word> conjugations = createEmptyList();
        conjugations.set(7, Word.fromString(pastRootText));
        var conjResult = modifier.build(root, kov, conjugations, SystemConstants.PAST_TENSE, true);
        return conjResult.getFinalResult().get(7).toString();
    }

    private String getPresentRootText(UnaugmentedTrilateralRoot root, KindOfVerb kov){
        //present text formatting
        String presentRootText = activePresentConjugator.createNominativeVerb(7, root).toString();
        var conjugations = createEmptyList();
        conjugations.set(7, Word.fromString(presentRootText));
        var conjResult = modifier.build(root, kov, conjugations, SystemConstants.PRESENT_TENSE, true);
        return conjResult.getFinalResult().get(7).toString();
    }

    private static List<Word> createEmptyList() {
        return IntStream.range(0,13)
                .mapToObj(a -> Word.empty())
                .collect(Collectors.toList());
    }
}
