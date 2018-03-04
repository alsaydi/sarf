package sarf.verb.trilateral.augmented;


import java.io.File;
import org.apache.commons.digester.Digester;
import sarf.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class AugmentedTrilateralRootTreeCreator {
    private AugmentedTrilateralRootTreeCreator() {
    }

    public static AugmentedTrilateralRootTree buildXmlVerbTree(File xmlDiagramFile) throws Exception{
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("roots", AugmentedTrilateralRootTree.class );

        digester.addObjectCreate("roots/root", AugmentedTrilateralRoot.class );
        digester.addSetProperties("roots/root", "c1","c1" );
        digester.addSetProperties( "roots/root", "c2","c2" );
        digester.addSetProperties( "roots/root", "c3", "c3" );

        digester.addObjectCreate("roots/root/augmentationFormula", AugmentationFormula.class );
        digester.addSetProperties( "roots/root/augmentationFormula", "formulaNo","formulaNo" );
        digester.addSetProperties( "roots/root/augmentationFormula", "transitive","transitive" );
        digester.addSetNext( "roots/root/augmentationFormula" , "addAugmentationFormula" );

        digester.addSetNext( "roots/root" , "addRoot" );

        return (AugmentedTrilateralRootTree)digester.parse(xmlDiagramFile);
    }

}
