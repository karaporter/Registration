public class Main {
    public enum Result { SUCCESS, INVALID, FULL, OVERLOAD, DUPLICATE, CONFLICT };

    public static Result selectCourse(Student student,
                                      CourseOfferings offerings,
                                      int courseIndex) {
        // TODO
        // Try to add the specified course (by index) to the student's
        // schedule. If successful, increase its enrollment by 1. Return
        // the appropriate result in each case.
        // SUCCESS - no errors
        // INVALID - course index is invalid
        // FULL - course is full
        // OVERLOAD - student schedule is full
        // DUPLICATE - student schedule already contains the course
        // CONFLICT - course conflicts with another on student schedule

        if (courseIndex >= offerings.numCourses) {
            return Result.INVALID;
        }
        Course c = offerings.getCourse(courseIndex);
        if (c.isFull()){
            return Result.FULL;
        }
        switch (student.addCourse(c)) {

            case SUCCESS:
                return Result.SUCCESS;
            case OVERLOAD:
                return Result.OVERLOAD;
            case DUPLICATE:
                return Result.DUPLICATE;
            case CONFLICT:
                return Result.CONFLICT;
        }


        return Result.SUCCESS;
    }

    public static void main(String[] args) {
        // TODO
        // For each index in the set [1, 3, 0, 6, 5, 7, 8, 9, 10, 11, 12]
        //    Display the offerings
        //    Choose the index
        //    Display the result
        //
        // The results should be
        // FULL, SUCCESS, DUPLICATE, FULL, SUCCESS, CONFLICT,
        // SUCCESS, SUCCESS, SUCCESS, OVERLOAD, OVERLOAD
        //
        // The input file with the course offerings is located
        // at the path "./Root/res/input.txt".
        int[] courseChoices = {1, 3, 0, 6, 5, 7, 8, 9, 10, 11, 12};

    }
}
