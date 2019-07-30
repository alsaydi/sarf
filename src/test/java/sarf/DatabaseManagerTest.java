package sarf;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DatabaseManagerTest {

	@Test
	public void getInstance_ReturnsInstance() {
		assertNotNull(DatabaseManager.getInstance());
	}
}
