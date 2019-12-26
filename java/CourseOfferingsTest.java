/**
 * Tests for class CourseOfferings.
 *
 * All tests in the folder "test" are executed
 * when the "Test" action is invoked.
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;


public class CourseOfferingsTest {
    private Course newCourse;
    private CourseOfferings o;

    @Before
    public final void setUp() {
        newCourse   = new Course("CS", "310", 1);
        o           = new CourseOfferings("./res/input.txt");
    }

    @Test
    public final void testGetNumCourses() {
        assertEquals(13, o.getNumCourses());
    }

    @Test
    public final void testGetCourse() {
        Course c = o.getCourse(3);
        assertEquals("230", c.getNumber());
        assertEquals(4, c.getSection());
        assertEquals("DaParma", c.getFaculty());
        boolean b = true;
        try { c = o.getCourse(13); }
        catch(ArrayIndexOutOfBoundsException e) { b = false; }
        assertTrue(!b);
    }

    @Test
    public final void testSetCourse() {
        o.setCourse(3, newCourse);
        Course c = o.getCourse(3);
        assertEquals("310", c.getNumber());
        boolean b = true;
        try { o.setCourse(13, c); }
        catch(ArrayIndexOutOfBoundsException e) { b = false; }
        assertTrue(!b);
    }

    @Test
    public final void testAddCourse() {
        boolean added = o.addCourse(newCourse);
        assertTrue(added);
        assertEquals(14, o.getNumCourses());
        assertEquals("310", o.getCourse(13).getNumber());
    }
}