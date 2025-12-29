import java.util.Scanner;
public class SearchTeacher
{
    public static void searchTeacher()
    {
        Scanner sc = new Scanner(System.in);
        TeacherDAO dao = new TeacherDAO();
        System.out.print("Enter Teacher ID: ");
        int id = sc.nextInt();
        dao.searchTeacher(id);
    }
}
