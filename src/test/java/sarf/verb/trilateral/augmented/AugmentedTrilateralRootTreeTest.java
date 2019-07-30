package sarf.verb.trilateral.augmented;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AugmentedTrilateralRootTreeTest {

	@Test
	void addRoot_rootAdded() throws Exception {
		AugmentedTrilateralRoot root = new AugmentedTrilateralRoot();
		AugmentedTrilateralRootTree sut = new AugmentedTrilateralRootTree();
		sut.addRoot(root);
		assertEquals(1, sut.getRoots().size());
		assertSame(root, sut.getRoots().get(0));
	}
}
