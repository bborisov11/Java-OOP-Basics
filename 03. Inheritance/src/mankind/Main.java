package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentInfo = reader.readLine().split(" ");
        String[] workerInfo = reader.readLine().split(" ");

        String studentsFirstName = studentInfo[0];
        String studentsLastName = studentInfo[1];
        String studentsFacultyNumber = studentInfo[2];

        String workersFirstName = workerInfo[0];
        String workersLastName = workerInfo[1];
        double weekSalary = Double.parseDouble(workerInfo[2]);
        double workingHours = Double.parseDouble(workerInfo[3]);

        try {
            Human student = new Student(studentsFirstName,studentsLastName,studentsFacultyNumber);
            Human worker = new Worker(workersFirstName,workersLastName,weekSalary,workingHours);
            System.out.println(student.toString());
            System.out.println(worker.toString());
        }
        catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

    }
}
