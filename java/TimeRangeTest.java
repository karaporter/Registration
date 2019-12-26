/**
 * Tests for class TimeRange.
 *
 * All tests in the folder "test" are executed 
 * when the "Test" action is invoked.
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;


public class TimeRangeTest {
    private TimeRange r1000to1130;
    private TimeRange r1100to1400;
    private TimeRange r1400to1500;
    private Time nineFiftyNine;
    private Time tenOClock;
    private Time elevenOClock;
    private Time elevenThirty;
    private Time elevenThirtyOne;
    private Time twoOClockPM;
    private Time threeOClockPM;

    @Before
    public final void setUp() {
        nineFiftyNine   = new Time("0959");
        tenOClock       = new Time("1000");
        elevenOClock    = new Time(11, 0);
        elevenThirty    = new Time("1130");
        elevenThirtyOne = new Time("1131");
        twoOClockPM     = new Time(14, 0);
        threeOClockPM   = new Time(15, 0);
        r1000to1130     = new TimeRange(elevenThirty, tenOClock);
        r1100to1400     = new TimeRange(elevenOClock, twoOClockPM);
        r1400to1500     = new TimeRange(twoOClockPM, threeOClockPM);
    }

    @Test
    public final void testGets() {
        assertEquals("Test getting the start time of (1000, 1130)",
                "1000", r1000to1130.getStartTime().toString());
        assertEquals("Test getting the end time of (1000, 1130)",
                "1130", r1000to1130.getEndTime().toString());
        assertEquals("Test getting the start time of (1100, 1400)",
                "1100", r1100to1400.getStartTime().toString());
        assertEquals("Test getting the end time of (1100, 1400)",
                "1400", r1100to1400.getEndTime().toString());
    }

    @Test
    public final void testGetDuration() {
        assertEquals("Test duration of (1000, 1130)",
                90, r1000to1130.getDuration());
        assertEquals("Test duration of (1100, 1400)",
                180, r1100to1400.getDuration());
    }

    @Test
    public final void testContains() {
        assertTrue("Test (1000, 1130) contains 1100",
                r1000to1130.contains(elevenOClock));
        assertTrue("Test (1000, 1130) contains 1000",
                r1000to1130.contains(tenOClock));
        assertTrue("Test (1000, 1130) does not contain 0959",
                !r1000to1130.contains(nineFiftyNine));
        assertTrue("Test (1000, 1130) does not contain 1131",
                !r1000to1130.contains(elevenThirtyOne));
    }

    @Test
    public final void testOverlaps() {
        assertTrue("Test (1000, 1130) overlaps (1100, 1400)",
                r1000to1130.overlaps(r1100to1400));
        assertTrue("Test (1000, 1130) does not overlap (1400, 1500)",
                !r1000to1130.overlaps(r1400to1500));
    }
}