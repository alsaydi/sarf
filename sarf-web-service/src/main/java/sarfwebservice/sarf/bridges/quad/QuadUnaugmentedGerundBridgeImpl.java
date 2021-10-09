package sarfwebservice.sarf.bridges.quad;/*
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarf.KindOfVerb;
import sarf.WordPresenter;
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedGerundConjugator;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedNomenGerundConjugator;
import sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;
import sarfwebservice.models.DerivedNounConjugation;
import sarfwebservice.sarf.factories.SuffixContainerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuadUnaugmentedGerundBridgeImpl implements QuadUnaugmentedGerundBridge {

    private static final String فعللة = "فَـعْـلَـلَـة";
    private static final String فعلال = "فِـعْـلال";
    private final QuadrilateralUnaugmentedGerundConjugator quadrilateralUnaugmentedGerundConjugator;
    private final QuadrilateralStandardModifier quadrilateralStandardModifier;
    private final UnaugmentedQuadrilateralPassiveParticipleConjugator quadrilateralPassiveParticipleConjugator;
    private final QuadrilateralUnaugmentedNomenGerundConjugator nomenGerundConjugator;
    private final SuffixContainerFactory suffixContainerFactory;
    private final PassiveParticipleModifier passiveParticipleModifier;

    @Autowired
    public QuadUnaugmentedGerundBridgeImpl(QuadrilateralUnaugmentedGerundConjugator quadrilateralUnaugmentedGerundConjugator
            , QuadrilateralStandardModifier quadrilateralStandardModifier
            , UnaugmentedQuadrilateralPassiveParticipleConjugator quadrilateralPassiveParticipleConjugator
            , QuadrilateralUnaugmentedNomenGerundConjugator nomenGerundConjugator
            , SuffixContainerFactory suffixContainerFactory
            , PassiveParticipleModifier passiveParticipleModifier)
    {
        this.quadrilateralUnaugmentedGerundConjugator = quadrilateralUnaugmentedGerundConjugator;
        this.quadrilateralStandardModifier = quadrilateralStandardModifier;
        this.quadrilateralPassiveParticipleConjugator = quadrilateralPassiveParticipleConjugator;
        this.nomenGerundConjugator = nomenGerundConjugator;
        this.suffixContainerFactory = suffixContainerFactory;
        this.passiveParticipleModifier = passiveParticipleModifier;
    }

    private boolean isQuadrilateralMudaaf(UnaugmentedQuadrilateralRoot root) {
        return root.getC1() == root.getC3() && root.getC2() == root.getC4();
    }

    @Override
    public List<DerivedNounConjugation> getStandardGerunds(UnaugmentedQuadrilateralRoot root, KindOfVerb kov) {
        var derivedNounConjugations = new ArrayList<DerivedNounConjugation>();
        if (isQuadrilateralMudaaf(root)) {
            derivedNounConjugations.add(getStandardGerund(root, فعلال, kov, true));
        }
        derivedNounConjugations.add(getStandardGerund(root, فعللة, kov, false));
        return derivedNounConjugations;
    }

    private DerivedNounConjugation getStandardGerund(UnaugmentedQuadrilateralRoot root, String key, KindOfVerb kov, boolean applyForm2) {
        var derivedNounConjugation = new DerivedNounConjugation();
        var nounSuffixContainer = suffixContainerFactory.create();
        derivedNounConjugation.setKey(key);

        nounSuffixContainer.selectInDefiniteMode();
        var conjugatedGerunds = quadrilateralUnaugmentedGerundConjugator.createGerundList(root, nounSuffixContainer, applyForm2);
        var indefinite = quadrilateralStandardModifier.build(root, 0, kov, conjugatedGerunds);
        derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectAnnexedMode();
        conjugatedGerunds = quadrilateralUnaugmentedGerundConjugator.createGerundList(root, nounSuffixContainer, applyForm2);
        var annexed = quadrilateralStandardModifier.build(root, 0, kov, conjugatedGerunds);
        derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectDefiniteMode();
        conjugatedGerunds = quadrilateralUnaugmentedGerundConjugator.createGerundList(root, nounSuffixContainer, applyForm2);
        var definite = quadrilateralStandardModifier.build(root, 0, kov, conjugatedGerunds);
        derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());
        return derivedNounConjugation;
    }

    @Override
    public List<DerivedNounConjugation> getMeemGerunds(UnaugmentedQuadrilateralRoot root, KindOfVerb kov) {
        var derivedNounConjugation = new DerivedNounConjugation();
        var nounSuffixContainer = suffixContainerFactory.create();
        derivedNounConjugation.setKey("");

        nounSuffixContainer.selectInDefiniteMode();
        var conjugatedGerunds = quadrilateralPassiveParticipleConjugator.createMeemGerundNounList(root, nounSuffixContainer);
        var indefinite = passiveParticipleModifier.build(root, 0, kov, conjugatedGerunds);
        derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectAnnexedMode();
        conjugatedGerunds = quadrilateralPassiveParticipleConjugator.createMeemGerundNounList(root, nounSuffixContainer);
        var annexed = passiveParticipleModifier.build(root, 0, kov, conjugatedGerunds);
        derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectDefiniteMode();
        conjugatedGerunds = quadrilateralPassiveParticipleConjugator.createMeemGerundNounList(root, nounSuffixContainer);
        var definite = passiveParticipleModifier.build(root, 0, kov, conjugatedGerunds);
        derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());

        return List.of(derivedNounConjugation);
    }
    @Override
    public List<DerivedNounConjugation> getNomenGerunds(UnaugmentedQuadrilateralRoot root, KindOfVerb kov) {
        var derivedNounConjugation = new DerivedNounConjugation();
        var nounSuffixContainer = suffixContainerFactory.create();
        derivedNounConjugation.setKey("");

        nounSuffixContainer.selectInDefiniteMode();
        var conjugatedGerunds = nomenGerundConjugator.createGerundList(root, nounSuffixContainer);
        var indefinite = quadrilateralStandardModifier.build(root, 0, kov, conjugatedGerunds);
        derivedNounConjugation.setIndefiniteNouns(indefinite.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectAnnexedMode();
        conjugatedGerunds = nomenGerundConjugator.createGerundList(root, nounSuffixContainer);
        var annexed = quadrilateralStandardModifier.build(root, 0, kov, conjugatedGerunds);
        derivedNounConjugation.setAnnexedNouns(annexed.getFinalResult().stream().map(WordPresenter::toString).toList());

        nounSuffixContainer.selectDefiniteMode();
        conjugatedGerunds = nomenGerundConjugator.createGerundList(root, nounSuffixContainer);
        var definite = quadrilateralStandardModifier.build(root, 0, kov, conjugatedGerunds);
        derivedNounConjugation.setDefiniteNouns(definite.getFinalResult().stream().map(WordPresenter::toString).toList());
        return List.of(derivedNounConjugation);
    }
}
