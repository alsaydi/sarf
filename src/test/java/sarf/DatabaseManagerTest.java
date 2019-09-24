package sarf;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DatabaseManagerTest {

	@Test
	void getInstance_ReturnsInstance() throws Exception {
		assertNotNull(new DatabaseManager().getUnaugmentedTrilateralRootTree('ب'));
	}
}
