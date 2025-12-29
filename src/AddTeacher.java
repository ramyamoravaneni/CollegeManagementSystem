import java.util.Scanner;
public class AddTeacher
{
    public static void addTeacher()
    {
        Scanner sc = new Scanner(System.in);
        TeacherDAO dao = new TeacherDAO();
        System.out.print("Teacher ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Subject: ");
        String subject = sc.nextLine();
        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        if (dao.addTeacher(id, name, subject, salary))
        {
            System.out.println("Teacher added successfully");
        }
        else
        {
            System.out.println("Failed to add teacher");
        }
    }
}
