import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testGetCount() {
        assertEquals(6, Main.getCount(2_000));
        assertEquals(42, Main.getCount(100_000));
        assertEquals(282, Main.getCount(500_000));
    }
}
