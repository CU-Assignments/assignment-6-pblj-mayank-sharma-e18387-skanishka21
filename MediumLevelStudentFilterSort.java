
import java.util.*;
import java.util.stream.Collectors;

public class MediumLevelStudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kanishka", 85));
        students.add(new Student("Dinky", 60));
        students.add(new Student("Baishnavi", 90));
        students.add(new Student("Prachi", 70));
        students.add(new Student("Eve", 95));

        List<Student> filteredAndSortedStudents = students.stream()
                .filter(student -> student.getMarks() > 75) 
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed()) 
                .collect(Collectors.toList());

        System.out.println("Students scoring above 75%, sorted by marks:");
        filteredAndSortedStudents.forEach(student -> System.out.println(student.getName()));
    }
}
