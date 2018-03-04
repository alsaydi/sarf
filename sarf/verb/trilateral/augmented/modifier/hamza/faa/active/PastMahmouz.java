package sarf.verb.trilateral.augmented.modifier.hamza.faa.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.hamza.faa.*;

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
public class PastMahmouz extends AbstractFaaMahmouz {

    private List substitutions = new LinkedList();

    public PastMahmouz() {
        substitutions.add(new InfixSubstitution("√уЅъ","¬"));// EX: (¬Ћу—у° ¬ ум° ¬ќум° ¬жум° )
        substitutions.add(new InfixSubstitution("Ѕу«","¬"));// EX: (¬÷шу°  у¬ћшу° ¬ћу—у°  ¬яубу° ¬жу»у° «дъ¬ѕу°  ¬жу»у° ¬ну”у° ¬нуѕу° ¬”ум°  ¬ќум° ¬”м°  ¬Ћум°  ¬жум° )
        substitutions.add(new InfixSubstitution("Ѕу","√у"));// EX: (√гшугу°  √гшугу° «”ъ √гшу° √Ћшу—° «д√Ўу—у°  √яшуѕу° √жшу»°  √жшу»у° √ншуѕу°  √ншуѕу° √»шум°  √”шум° √ѕшум°  √ шум° √жшум°  √жшум° )
        substitutions.add(new InfixSubstitution("«Ѕъ","«∆ъ"));// EX: («∆ъ угшу° «∆ъ уЋу√у° «∆ъ угу—у° «∆ъ у«бу° «∆ъ «гу° «∆ъ у”ум° «∆ъ у—ум° «∆ъ ужум° )
        substitutions.add(new InfixSubstitution("уЅъ","у√ъ"));// EX: («”ъ у√ъгу—у° «”ъ у√ъжу—у° «” √нуяу° «”ъ у√гум° «” √дум° «”ъ у√ъжум° )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
