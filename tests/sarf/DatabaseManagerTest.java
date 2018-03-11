package sarf;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;

public class DatabaseManagerTest {

	@Test
	public void getInstance_ReturnsInstance() {
		assertNotNull(DatabaseManager.getInstance());
	}
}
