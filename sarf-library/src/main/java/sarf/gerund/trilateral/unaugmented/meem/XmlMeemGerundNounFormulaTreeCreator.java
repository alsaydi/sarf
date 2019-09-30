package sarf.gerund.trilateral.unaugmented.meem;

import org.apache.commons.digester3.*;
import org.xml.sax.SAXException;

import java.io.*;

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
public class XmlMeemGerundNounFormulaTreeCreator {
    private XmlMeemGerundNounFormulaTreeCreator() {
    }

    public static XmlMeemGerundNounFormulaTree buildNounFormulaTree(InputStream inputStream) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("formulas", XmlMeemGerundNounFormulaTree.class );

        digester.addObjectCreate("formulas/formula", XmlMeemGerundNounFormula.class );
        digester.addSetProperties("formulas/formula", "c1","c1" );
        digester.addSetProperties("formulas/formula", "c2","c2" );
        digester.addSetProperties("formulas/formula", "c3", "c3" );
        digester.addSetProperties("formulas/formula", "symbol1", "symbol1" );
        digester.addSetProperties("formulas/formula", "gerund1", "gerund1" );
        digester.addSetProperties("formulas/formula", "symbol2", "symbol2" );
        digester.addSetProperties("formulas/formula", "gerund2", "gerund2" );

        digester.addSetNext( "formulas/formula" , "addFormula" );

        return (XmlMeemGerundNounFormulaTree)digester.parse(inputStream);
    }

}
