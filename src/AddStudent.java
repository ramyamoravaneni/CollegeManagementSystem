import java.util.Scanner;
public class AddStudent
{
    public static void addStudent()
    {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        System.out.print("Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Department: ");
        String dept = sc.nextLine();
        System.out.print("Fees: ");
        double fees = sc.nextDouble();
        if (dao.addStudent(id, name, dept, fees))
        {
            System.out.println("Student added successfully");
        }
        else
        {
            System.out.println("Failed to add student");
        }
    }
}
