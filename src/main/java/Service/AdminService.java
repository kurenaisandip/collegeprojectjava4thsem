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
    public List<Student> getUserList() {
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
    public Student getUserRow(int id) {
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


    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
            String sql = "SELECT * FROM login_users";
        PreparedStatement pstm = new DBConnection().getStatement(sql);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setUserName(rs.getString("username"));
                student.setEmail(rs.getString("email"));

                student.setPassword(rs.getString("password"));
                students.add(student);
            }
        }catch (SQLException e) {
                e.printStackTrace();
            }
        return students;
    }


    public static void sort(List<Student> students, String sortBy) {
        switch (sortBy) {
            case "name":
                Collections.sort(students, Comparator.comparing(Student::getUserName));
                break;
            case "email":
                Collections.sort(students, Comparator.comparing(Student::getEmail));
                break;
            case "password":
                Collections.sort(students, Comparator.comparing(Student::getPassword));
                break;
            default:
                // Do nothing if sortBy parameter is not recognized
                break;
        }
    }


    } // admin service



