package sarfwebservice.sarf.bridges.tri;
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
import sarf.KindOfVerb;
import sarf.WordPresenter;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

import java.util.List;

public interface TrilateralUnaugmentedBridge {
    //active and passive verbs
    List<WordPresenter> retrievePastConjugations(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active);
    List<WordPresenter> retrieveNominativePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active);
    List<WordPresenter> retrieveAccusativePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active);
    List<WordPresenter> retrieveJussivePresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active, boolean applyGemination);
    List<WordPresenter> retrieveEmphasizedPresent(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean active);
    List<WordPresenter> retrieveImperative(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean applyGemination);
    List<WordPresenter> retrieveEmphasizedImperative(UnaugmentedTrilateralRoot root, KindOfVerb kov, boolean applyGemination);
}
