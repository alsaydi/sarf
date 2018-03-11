package sarf.verb.trilateral.unaugmented;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnaugmentedTrilateralRootTreeTest {
	
	@Test
	public void getRoots_ReturnsEmptyListByDefault() {
		UnaugmentedTrilateralRootTree sut = new UnaugmentedTrilateralRootTree();
		List<UnaugmentedTrilateralRoot> roots = sut.getRoots();
		assertNotNull(roots);
		assertEquals(0, roots.size());
	}
	
	@Test
	public void root_addRoot_RootAdded() {
		UnaugmentedTrilateralRootTree sut = new UnaugmentedTrilateralRootTree();
		UnaugmentedTrilateralRoot root = new UnaugmentedTrilateralRoot();
		sut.addRoot(root);
		assertEquals(1, sut.getRoots().size());
		assertSame(root, sut.getRoots().get(0));
	}
}
