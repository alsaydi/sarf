package sarf.verb.trilateral.unaugmented;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.digester3.*;
import org.xml.sax.SAXException;
import sarf.*;
import sarf.util.ConjugationConverter;

/**
 * <p>Title: تحويل ملف المعطيات إلى قائمة الجذور الثلاثية المجردة       </p>
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
public class UnaugmentedTrilateralRootTreeCreator {

    public static UnaugmentedTrilateralRootTree buildXmlVerbTree(InputStream inputStream) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating( false );

        digester.addObjectCreate("roots", UnaugmentedTrilateralRootTree.class );

        digester.addObjectCreate("roots/root", UnaugmentedTrilateralRoot.class );
        digester.addSetProperties("roots/root", "c1","c1" );
        digester.addSetProperties( "roots/root", "c2","c2" );
        digester.addSetProperties( "roots/root", "c3", "c3" );
        digester.addSetProperties( "roots/root", "conjugation","conjugation");
        digester.addSetProperties( "roots/root", "transitive","transitive" );

        digester.addObjectCreate("roots/root/gerund", Gerund.class );
        digester.addSetProperties( "roots/root/gerund", "symbol","symbol" );
        digester.addSetProperties( "roots/root/gerund", "value","value" );
        digester.addSetNext( "roots/root/gerund" , "addGerund" );

        digester.addSetNext( "roots/root" , "addRoot" );

        ConvertUtils.register(new ConjugationConverter(), Conjugation.class);
        return (UnaugmentedTrilateralRootTree)digester.parse(inputStream);
    }

    public static void main(String[] args) {
        try {
            char c1 = 'غ';
            String path = "./db/trilateral/unaugmented/"+c1+".xml";
            var inputStream = new FileInputStream(path);
            UnaugmentedTrilateralRootTree rootTree = buildXmlVerbTree(inputStream);
            List<?> roots = rootTree.getRoots();
            for (Object obj : roots) {
            	UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) obj;
            	System.out.printf("%c %c %c\n",root.getC1(),root.getC2(),root.getC3());
			}
            System.out.println("==انتهى.==");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
