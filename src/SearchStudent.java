import java.util.Scanner;
public class SearchStudent
{
    public static void searchStudent()
    {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        dao.searchStudent(id);
    }
}
