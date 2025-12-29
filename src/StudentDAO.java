import java.sql.*;
public class StudentDAO
{
    public boolean addStudent(int id, String name, String dept, double fees)
    {
        String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);
            ps.setDouble(4, fees);
            ps.executeUpdate();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Add Error: " + e.getMessage());
            return false;
        }
    }

   public void viewStudents()
    {
        String sql = "SELECT * FROM students";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            System.out.println("\nID  Name       Department     Fees");
            System.out.println("------------------------------------");
            while (rs.next())
            {
                System.out.println(
                    rs.getInt(1) + "  " +
                    rs.getString(2) + "  " +
                    rs.getString(3) + "  " +
                    rs.getDouble(4)
                );
            }
        }
        catch (Exception e)
        {
            System.out.println("View Error: " + e.getMessage());
        }
    }

    public void searchStudent(int id)
    {
        String sql = "SELECT * FROM students WHERE student_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3) + " " +
                    rs.getDouble(4)
                );
            }
            else
            {
                System.out.println("Student not found");
            }
        }
        catch (Exception e)
        {
            System.out.println("Search Error: " + e.getMessage());
        }
    }

    public boolean deleteStudent(int id)
    {
        String sql = "DELETE FROM students WHERE student_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Delete Error: " + e.getMessage());
            return false;
        }
    }
}
