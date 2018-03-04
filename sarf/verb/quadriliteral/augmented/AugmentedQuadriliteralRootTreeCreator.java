package sarf.verb.quadriliteral.augmented;


import java.io.File;
import org.apache.commons.digester.Digester;
import sarf.*;
import org.xml.sax.SAXException;
import java.io.IOException;

/**
 * <p>Title: </p>
 *
  * <p>Title:  ÕÊÌ· „·› «·„⁄ÿÌ«  ≈·Ï ﬁ«∆„… «·Ã–Ê— «·—»«⁄Ì… «·„“Ìœ…       </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class AugmentedQuadriliteralRootTreeCreator {
    public AugmentedQuadriliteralRootTreeCreator() {
    }

    public static AugmentedQuadriliteralRootTree buildXmlVerbTree(File xmlDiagramFile) throws SAXException, IOException {
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("roots", AugmentedQuadriliteralRootTree.class );

        digester.addObjectCreate("roots/root", AugmentedQuadriliteralRoot.class );
        digester.addSetProperties("roots/root", "c1","c1" );
        digester.addSetProperties( "roots/root", "c2","c2" );
        digester.addSetProperties( "roots/root", "c3", "c3" );
        digester.addSetProperties( "roots/root", "c4", "c4" );

        digester.addObjectCreate("roots/root/augmentationFormula", AugmentationFormula.class );
        digester.addSetProperties( "roots/root/augmentationFormula", "formulaNo","formulaNo" );
        digester.addSetProperties( "roots/root/augmentationFormula", "transitive","transitive" );
        digester.addSetNext( "roots/root/augmentationFormula" , "addAugmentationFormula" );

        digester.addSetNext( "roots/root" , "addRoot" );

        return (AugmentedQuadriliteralRootTree)digester.parse(xmlDiagramFile);
    }



}
