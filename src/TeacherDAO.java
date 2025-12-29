import java.sql.*;

public class TeacherDAO
{
    public boolean addTeacher(int id, String name, String subject, double salary)
    {
        String sql = "INSERT INTO teachers VALUES (?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, subject);
            ps.setDouble(4, salary);
            ps.executeUpdate();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Add Teacher Error: " + e.getMessage());
            return false;
        }
    }

    public void viewTeachers()
    {
        String sql = "SELECT * FROM teachers";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            System.out.println("\nID  Name       Subject       Salary");
            System.out.println("-------------------------------------");
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

    public void searchTeacher(int id)
    {
        String sql = "SELECT * FROM teachers WHERE teacher_id=?";
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
                System.out.println("Teacher not found");
            }
        }
        catch (Exception e)
        {
            System.out.println("Search Error: " + e.getMessage());
        }
    }

    public boolean deleteTeacher(int id)
    {
        String sql = "DELETE FROM teachers WHERE teacher_id=?";
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
