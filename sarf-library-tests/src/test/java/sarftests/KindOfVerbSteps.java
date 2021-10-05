package sarftests;
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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sarftests.verb.tri.Common;

import static org.junit.Assert.*;

@SuppressWarnings("EmptyMethod")
public class KindOfVerbSteps {
    private final Common common;

    @Inject
    public KindOfVerbSteps(Common common){
        this.common = common;
    }
    @Given("a trilateral unaugmented verb")
    public void aTrilateralUnaugmentedVerb() {
    }

    @When("the kind of verb is request")
    public void theKindOfVerbIsRequest() {
    }

    @Then("the verb <verb> kind is <kind>")
    public void theVerbVerbKindIsKind() {
    }

    @Then("the verb {string} kind is {string}")
    public void theVerbKindIs(String verb, String kind) {
        var kov = common.getKindOfVerb(verb);
        assertEquals(kind, kov.name());
    }
}
