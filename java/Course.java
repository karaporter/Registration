/**
 * This class represents most of the relevant course information for scheduling
 * purposes. (Prerequisites, in particular, are not included for simplicity.)
 * This class should allow programmers to determine whether a Course object is
 * full (meaning that its enrollment is at capacity), if it meets on a
 * particular day, and if it conflicts with another course (meaning that its
 * day and time conflict with the other course's day and time).
 */

public class Course {
    /**
     * This enumeration represents the days of the week that can be
     * used to determine whether the course meets on a particular day.
     * Legitimate values are SUN, MON, TUE, WED, THU, FRI, SAT.
     */
    public enum Day {SUN, MON, TUE, WED, THU, FRI, SAT};

    /**
     * A two- or three-letter designation for a department. For example,
     * "CS" represents "computer science."
     */
    protected String department;

    /**
     * An alphanumeric string representing the course number. For example,
     * "232" or "110M."
     */
    protected String number;

    /**
     * A positive integer representing the section number.
     */
    protected int section;

    /**
     * A string representing the days of the week on which the course meets,
     * where each day is represented by a single character. The days of the
     * week from Sunday through Saturday would be represented as "NMTWRFS".
     * These designations should be capital letters.
     */
    protected String days;

    /**
     * The range of time for the class (e.g., 10am to 11am).
     */
    protected TimeRange time;

    /**
     * The abbreviation for the building (e.g., "AH" for "Ayers Hall").
     */
    protected String building;

    /**
     * The alphanumeric room number (e.g., "214" or "105C").
     */
    protected String room;

    /**
     * The last name of the faculty member teaching the course (e.g., "Garrett").
     */
    protected String faculty;

    /**
     * The maximum capacity for the course.
     */
    protected int capacity;

    /**
     * The current number of students enrolled in the course.
     */
    protected int enrolled;

    /**
     * This constructor requires the department, course number, and section.
     */
    public Course(String department, String number, int section) {
        this.department = department;
        this.number = number;
        this.section = section;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSection() {
        return section;
    }

    /**
     * The section must be greater than 0.
     */
    public void setSection(int section) {
        if (section > 0) {
            this.section = section;
        }
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days.toUpperCase();
    }

    public TimeRange getTime() {
        return time;
    }

    public void setTime(TimeRange time) {
        this.time = time;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * The capacity must be greater than or equal to 0.
     */
    public void setCapacity(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
        }
    }

    public int getEnrolled() {
        return enrolled;
    }

    /**
     * The enrolled must be greater than or equal to 0.
     */
    public void setEnrolled(int enrolled) {
        if (enrolled >= 0) {
            this.enrolled = enrolled;
        }
    }

    /**
     * This method returns true if the enrollment is greater than or equal
     * to the capacity.
     *
     * @return whether the course is full
     */
    public boolean isFull() {
        return getEnrolled() >= getCapacity();

    }

    /**
     * This method returns true if the course meets on the given day.
     *
     * @param day the day of the week
     * @return whether the course meets on the given day
     */
    public boolean meetsOn(Day day) {
        if (day == Day.MON) {
            return getDays().indexOf('M') >= 0;
        } else if (day == Day.TUE) {
            return getDays().indexOf('T') >= 0;
        } else if (day == Day.WED) {
            return getDays().indexOf('W') >= 0;
        } else if (day == Day.THU) {
            return getDays().indexOf('R') >= 0;
        } else if (day == Day.FRI) {
            return getDays().indexOf('F') >= 0;
        } else if (day == Day.SAT) {
            return getDays().indexOf('S') >= 0;
        } else {
            return getDays().indexOf('N') >= 0;
        }

    }

    /**
     * This method returns true if the current course conflicts with the
     * course that is passed in. A course conflicts with another if both
     * meet on the same day and the time ranges overlap.
     *
     * @param course the course in question
     * @return whether the current course conflicts with the course parameter
     */
    public boolean conflictsWith(Course course) {
        String daysOf = course.getDays();
        for (int i = 0; i < daysOf.length(); i++) {
            if (this.days.indexOf(daysOf.charAt(i)) >= 0 && course.time.overlaps(this.time)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method returns the string representation of the course. For example,
     * a string representation of a course would look like the following:
     *
     * CS 232 1 MWF 1230 1400 AH 363 Garrett 15 14
     *
     * @return the string representation of the course
     */
    public String toString() {
        return this.department + " " + this.number + " " + this.section + " " + this.days + " " + this.time.startTime
                + " " + this.time.endTime + " " + this.building + " " + this.room + " " + this.faculty + " "
                + this.capacity + " " + this.enrolled;
    }
}