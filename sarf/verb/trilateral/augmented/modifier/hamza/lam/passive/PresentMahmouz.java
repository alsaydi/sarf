package sarf.verb.trilateral.augmented.modifier.hamza.lam.passive;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.hamza.lam.*;

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
public class PresentMahmouz extends AbstractLamMahmouz {

    private List substitutions = new LinkedList();

    public PresentMahmouz() {
        substitutions.add(new SuffixSubstitution("«Ѕх","«Ѕх"));// EX: (нх”ъ у«Ѕх° нх”«Ѕх)
        substitutions.add(new SuffixSubstitution("уЅх","у√х"));// EX: (нхћъ“у√х° нхя«Ёу√х° нхдъЁуёу√х° нх»ъ уѕу√х° нх уѕ«—у√х° нх”ъ уеъ“у√х° нхЌъ“ужъ“у√х° )
        substitutions.add(new SuffixSubstitution("шуЅх","шу√х"));// EX: (нхћу“шу√х° нхќу»шу√х° )
        substitutions.add(new InfixSubstitution("«Ѕх","«ƒх"));// EX: (нх”ъ у«ƒхжду° нх”«ƒхжду)
        substitutions.add(new InfixSubstitution("«Ѕц","«∆ц"));// EX: ( х”ъ у«∆цнду°   х”«∆цнду)
        substitutions.add(new InfixSubstitution("уЅъ","у√ъ"));// EX: (нхћъ“у√ъду° бг нхћъ“у√ъ° нхя«Ёу√ъду° нхдъЁуёу√ъду° нх»ъ уѕу√ъду° нх уѕу«—у√ъду° нх”ъ уеъ“у√ъду° нхЌъ“ужъ“у√ъду)
        substitutions.add(new InfixSubstitution("уЅу","у√у"));// EX: ( нхћъ“у√у«дц° бд нхћъ“у√у° нхя«Ёу√у«дц° нхдъЁуёу√у«дц° нх»ъ уѕу√у«дц° нх уѕу«—у√у«дц° нх”ъ уеъ“у√у«дц° нхЌъ“ужъ“у√у«дц° )
        substitutions.add(new InfixSubstitution("уЅх","уƒх"));// EX: (нхћъ“уƒхжду° нхя«Ёуƒхжду° нхдъЁуёуƒхжду° нх»ъ уѕуƒхжду° нх уѕу«—уƒхжду° нх”ъ уеъ“уƒхжду° нхЌъ“ужъ“уƒхжду° )
        substitutions.add(new InfixSubstitution("шуЅъ","шу√ъ"));// EX: (нхћу“шу√ъду° бг нхћу“шу√ъ° нхќу»шу√ъду° )
        substitutions.add(new InfixSubstitution("шуЅу","шу√у"));// EX: ( нхћу“шу√у«дц° бд нхћу“шу√у° нхќу»шу√у«дц° )
        substitutions.add(new InfixSubstitution("шуЅх","шуƒх"));// EX: (нхћу“шуƒхжду° нхќу»шуƒхжду° )
        substitutions.add(new InfixSubstitution("Ѕц","∆ц"));// EX: ( хћъ“у∆цнду°  хћу“шу∆цнду°  хя«Ёу∆цнду°  хдъЁуёу∆цнду°  х»ъ уѕу∆цнду°  х уѕ«—у∆цнду°  хќу»шу∆цнду°  х”ъ уеъ“у∆цнду°  хЌъ“ужъ“у∆цнду° )
    }


    public List getSubstitutions() {
        return substitutions;
    }
}
