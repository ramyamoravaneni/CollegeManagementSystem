import java.util.Scanner;
public class MainApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("\n--- College Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Add Teacher");
            System.out.println("6. View Teachers");
            System.out.println("7. Search Teacher");
            System.out.println("8. Delete Teacher");
            System.out.println("9. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    AddStudent.addStudent();
                    break;
                case 2:
                    new StudentDAO().viewStudents();
                    break;
                case 3:
                    SearchStudent.searchStudent();
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    new StudentDAO().deleteStudent(sc.nextInt());
                    break;
                case 5:
                    AddTeacher.addTeacher();
                    break;
                case 6:
                    new TeacherDAO().viewTeachers();
                    break;
                case 7:
                    SearchTeacher.searchTeacher();
                    break;
                case 8:
                    System.out.print("Enter Teacher ID: ");
                    new TeacherDAO().deleteTeacher(sc.nextInt());
                    break;
                case 9:
                    System.out.println("Exit");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
