package Service;

import DBConnection.DBConnection;
import Model.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AdminService {
    public Student getUser(String email, String password) {
        Student student = null;

        String query = "select * from admin where email=? and passsword=?";
        PreparedStatement ps = new DBConnection().getStatement(query);

        try {
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                student = new Student();

                student.setId(rs.getInt("id"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("passsword"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }


    //    This is related to list user page
    public static List<Student> getUserList() {
        List<Student> userList = new ArrayList<>();
        String query = "select * from login_users";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();

                student.setId(rs.getInt("uid"));
                student.setUserName(rs.getString("username"));
                student.setEmail(rs.getString("email"));
                student.setStatus(rs.getString("status"));
                student.setPassword(rs.getString("password"));


                userList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    //    For getting user details in user list
    public static Student getUserRow(int id) {
        Student student = new Student();
        String query = "select * from login_users where uid = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                student.setId(rs.getInt("uid"));
                student.setUserName(rs.getString("username"));
                student.setEmail(rs.getString("email"));

                student.setPassword(rs.getString("password"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    // Delete User
    public void deleteUser(int id) {
        String query = "delete from login_users where uid = ?";
        PreparedStatement ps = new DBConnection().getStatement(query);

        try {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    For editing users
    public void editUser(int id, Student student) throws SQLException {

        String query = "update login_users set email=?, username=?, password=? where uid=?";

        try (PreparedStatement pstm = new DBConnection().getStatement(query)) {
            pstm.setString(1, student.getEmail());
            pstm.setString(2, student.getUserName());
            pstm.setString(3, student.getPassword());
            pstm.setInt(4, id);
            pstm.executeUpdate();
        }

    }

//This is the method for sorting by username
    public static List<Student> getAllStudents() {
        List<Student> name =  getUserList();
        Collections.sort(name, Comparator.comparing(Student::getUserName));
        return name;
    }


    // to enable the account
    public void enableaccount(int id, String status) {
        String query = "UPDATE login_users SET status = ? WHERE uid = ?";
        PreparedStatement ps = new DBConnection().getStatement(query);

        try {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // to disaable the account
    public void disableaccount(int id, String status) {
        String query = "UPDATE login_users SET status = ? WHERE uid = ?";
        PreparedStatement ps = new DBConnection().getStatement(query);

        try {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //so This is method for seeclaims which join table which admin can see
    public static List<Student> claimlist() throws SQLException {
        List<Student> claimlist = new ArrayList<>();
        String query = "SELECT * FROM claim";

        PreparedStatement stmt = new DBConnection().getStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setUserName(rs.getString("name"));
            student.setPlan(rs.getString("policy"));
            student.setAddress(rs.getString("address"));
            student.setEmail(rs.getString("email"));
            student.setMobile_Number(rs.getString("number"));
            student.setInformation(rs.getString("info"));
            student.setImages(rs.getString("file"));
//            student.se(rs.getInt("uid"));
            student.setBuydate(rs.getString("buydate"));
            student.setStatus(rs.getString("status"));
            student.setLastdate(rs.getString("lastdate"));
            claimlist.add(student);
        }

        return claimlist;
    }

    // to dislay image and deatils of claim in seecliam page
    public HashMap<String, Object> showclaim(Student student) throws SQLException {
        HashMap<String, Object> details = new HashMap<>();
        String base64Image = "";

        // Retrieve the image data and student details from the database
        String query = "SELECT file, name, number, policy, email, info, address, id " + "FROM claim " + "WHERE id = ?";
        PreparedStatement ps = new DBConnection().getStatement(query);
        ps.setInt(1, student.getId());

        System.out.println(ps);

        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Read the image file into a byte array
                String filePath = rs.getString("file");
                File file = new File(filePath);
                byte[] fileContent = Files.readAllBytes(file.toPath());
                System.out.println(filePath);

                // Convert the byte array to a base64 string
                base64Image = Base64.getEncoder().encodeToString(fileContent);

                // Add the student details and image to the HashMap
                String name = rs.getString("name");
                String phoneNumber = rs.getString("number");
                String policy = rs.getString("policy");
                String email = rs.getString("email");
                String info = rs.getString("info");
                String images = rs.getString("file");
                String address = rs.getString("address");
                String id = rs.getString("id");



                details.put("name", name);
                details.put("phone_number", phoneNumber);
                details.put("policy", policy);
                details.put("email", email);
                details.put("info", info);
                details.put("image", base64Image);
                details.put("images", images);
                details.put("address", address);
                details.put("id", id);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return details;
    }


} // admin service



