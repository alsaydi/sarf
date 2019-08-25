package sarf.verb.quadriliteral.augmented;


import org.apache.commons.digester3.Digester;
import sarf.*;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Title: </p>
 *
  * <p>Title: تحويل ملف المعطيات إلى قائمة الجذور الرباعية المزيدة       </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class AugmentedQuadrilateralRootTreeCreator {
    public AugmentedQuadrilateralRootTreeCreator() {
    }

    public static AugmentedQuadriliteralRootTree buildXmlVerbTree(InputStream inputStream) throws SAXException, IOException {
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("roots", AugmentedQuadriliteralRootTree.class );

        digester.addObjectCreate("roots/root", AugmentedQuadrilateralRoot.class );
        digester.addSetProperties("roots/root", "c1","c1" );
        digester.addSetProperties( "roots/root", "c2","c2" );
        digester.addSetProperties( "roots/root", "c3", "c3" );
        digester.addSetProperties( "roots/root", "c4", "c4" );

        digester.addObjectCreate("roots/root/augmentationFormula", AugmentationFormula.class );
        digester.addSetProperties( "roots/root/augmentationFormula", "formulaNo","formulaNo" );
        digester.addSetProperties( "roots/root/augmentationFormula", "transitive","transitive" );
        digester.addSetNext( "roots/root/augmentationFormula" , "addAugmentationFormula" );

        digester.addSetNext( "roots/root" , "addRoot" );

        return (AugmentedQuadriliteralRootTree)digester.parse(inputStream);
    }



}
