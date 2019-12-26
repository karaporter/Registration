/**
 * Tests for class Time.
 *
 * All tests in the folder "test" are executed
 * when the "Test" action is invoked.
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;


public class TimeTest {
    private Time midnight;
    private Time oneThirty;
    private Time twoOClockPM;
    private Time threeFortyFivePM;

    @Before
    public final void setUp() {
        midnight            = new Time();
        oneThirty           = new Time("130");
        twoOClockPM         = new Time(14, 0);
        threeFortyFivePM    = new Time("1545");
    }

    @Test
    public final void testGetsSets() {
        assertEquals("Test get hour of 0000", 0, midnight.getHour());
        assertEquals("Test get minutes of 0000", 0, midnight.getMinute());
        assertEquals("Test get hour of 0130", 1, oneThirty.getHour());
        assertEquals("Test get minutes of 0130", 30, oneThirty.getMinute());
        assertEquals("Test get hour of 1400", 14, twoOClockPM.getHour());
        assertEquals("Test get minutes of 1400", 0, twoOClockPM.getMinute());
        assertEquals("Test get hour of 1545", 15, threeFortyFivePM.getHour());
        assertEquals("Test get minutes of 1545", 45, threeFortyFivePM.getMinute());
    }

    @Test
    public final void testBefore() {
        assertTrue("Test 0000 is before 0130", midnight.before(oneThirty));
        assertTrue("Test 0130 is before 1400", oneThirty.before(twoOClockPM));
        assertTrue("Test 1400 is not before 0000", !twoOClockPM.before(midnight));
        assertTrue("Test 0130 is not before 0130", !oneThirty.before(oneThirty));
    }

    @Test
    public final void testAfter() {
        assertTrue("Test 0130 is after 0000", oneThirty.after(midnight));
        assertTrue("Test 1400 is after 0130", twoOClockPM.after(oneThirty));
        assertTrue("Test 0000 is not after 1400", !midnight.after(twoOClockPM));
        assertTrue("Test 0130 is not after 0130", !oneThirty.after(oneThirty));
    }

    @Test
    public final void testEquals() {
        assertTrue("Test 0000 not equal to 0130", !midnight.equals(oneThirty));
        assertTrue("Test 0130 not equal to 1400", !oneThirty.equals(twoOClockPM));
        assertTrue("Test 1400 equal to 1400", twoOClockPM.equals(twoOClockPM));
    }

    @Test
    public final void testToString() {
        assertEquals("Test 0130 is '0130'", "0130", oneThirty.toString());
        assertEquals("Test 1400 is '1400'", "1400", twoOClockPM.toString());
    }
}
