package Service;

import DBConnection.DBConnection;
import Model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

                student.setId(rs.getInt("id"));
                student.setUserName(rs.getString("username"));
                student.setEmail(rs.getString("email"));

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
        String query = "select * from login_users where id = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                student.setId(rs.getInt("id"));
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
        String query = "delete from login_users where id = ?";
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

        String query = "update login_users set email=?, username=?, password=? where id=?";

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


//so This is method for seeclaims which join table which admin can see
    public List<Student> seeclaims() throws SQLException {
        List<Student> SeeClaims = new ArrayList<>();
        String query = "SELECT students.id, students.name, classes.class_name " +
                "FROM students " +
                "JOIN classes ON students.class_id = classes.id";
        PreparedStatement stmt = new DBConnection().getStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String className = rs.getString("class_name");
            SeeClaims.add(new Student());
        }
        return SeeClaims;
    }



} // admin service



