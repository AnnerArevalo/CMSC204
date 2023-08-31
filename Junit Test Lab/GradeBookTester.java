import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class GradeBookTester {
	GradeBook first;
	GradeBook second;
	@BeforeEach
	void setUp() throws Exception {
		first = new GradeBook(5);
		second = new GradeBook(5);
		first.addScore(2.5);
		first.addScore(3.0);
		second.addScore(5.0);
		second.addScore(6.5);
	}
	@AfterEach
	void tearDown() throws Exception {
		first = null;
		second = null;
	}
	@Test
	void testAddScore() {
		first.addScore(0.0);
		second.addScore(10.0);
		assertEquals(first.toString(), "2.5 3.0 0.0 ");
		assertEquals(second.toString(), "5.0 6.5 10.0 ");
		assertTrue(first.toString().equals("2.5 3.0 0.0 "));
		assertTrue(second.toString().equals("5.0 6.5 10.0 "));
	}
	@Test
	void testSum() {
		assertEquals(first.sum(), 5.5);
		assertEquals(second.sum(), 11.5);
	}
	@Test
	void testMinimum() {
		assertEquals(first.minimum(), 2.5);
		assertEquals(second.minimum(), 5.0);
	}
	@Test
	void testFinalScore() {
		assertEquals(first.finalScore(), 3.0);
		assertEquals(second.finalScore(), 6.5);
	}
	@Test
	void testGetScoreSize() {
		assertTrue(first.getScoreSize() == 2);
		assertTrue(second.getScoreSize() == 2);
	}
	@Test
	void testToString() {
		assertEquals(first.toString(), "2.5 3.0 ");
		assertEquals(second.toString(), "5.0 6.5 ");
	}
}
