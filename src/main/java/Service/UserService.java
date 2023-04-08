package Service;

import DBConnection.DBConnection;
import Model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public void insertUser(Student student) {
        String query = "insert into login_users(username, email, password)" + "values(?,?,?)"; // same as database

        PreparedStatement preparedStatements = new DBConnection().getStatement(query);  // execute parametrized query

        try {
            preparedStatements.setString(1, student.getUserName());
            preparedStatements.setString(2, student.getEmail());
            preparedStatements.setString(3, student.getPassword());

            preparedStatements.execute();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getUser(String email, String password) {
        Student student = null;

        String query = "select * from login_users where email=? and password=?";
        PreparedStatement ps = new DBConnection().getStatement(query);

        try {
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                student = new Student();

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

    public Student insertPolicy(Student student) {

        String query = "insert into details (EMAIL,Gender,Occupation,fullname,DOB,idtype,idnumber,authority,state,date,plateno,manufacturer,motordmg,plan,vperiod, mobilenumber, evalue) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try {
            ps.setString(1, student.getEmail());
            ps.setString(2, student.getGender());
            ps.setString(3, student.getOccupation());
            ps.setString(4, student.getUserName());
            ps.setString(5, student.getDOB());
            ps.setString(6, student.getId_Type());
            ps.setString(7, student.getId_number());
            ps.setString(8, student.getAuthority());
            ps.setString(9, student.getState());
            ps.setString(10, student.getDate());
            ps.setString(11, student.getPlate_No());
            ps.setString(12, student.getManufacturer());
            ps.setString(13, student.getMotor_Dmg());
            ps.setString(14, student.getPlanType());
            ps.setString(15, student.getValidityPeriod());
            ps.setString(16, student.getMobile_Number());
            ps.setInt(17, student.getEvalue());
            System.out.println("OB : " + student.getDOB());
            System.out.printf("" +ps);
            ps.execute();

//            ResultSet rs = ps.executeQuery();
////            int rowsAffected = ps.executeUpdate();
//
//
//            while (rs.next()) {
//                student = new Student();
//
//                student.setEmail("uemail");
//                student.setGender("gender");
//                student.setOccupation("occupation");
//                student.setUserName("uname");
//                student.setDOB("dob");
//                student.setId_Type("ID");
//                student.setId_number("IDno");
//                student.setAuthority("Auth");
//                student.setState("Istate");
//                student.setDate("Idate");
//                student.setPlate_No("Pno");
//                student.setManufacturer("Man");
//                student.setMotor_Dmg("Mdmg");
//                student.setPlanType("Plan");
//                student.setValidityPeriod("Vperiod");
//                student.setMobile_Number("mobilenumber");
//                student.setEvalue(Integer.parseInt("Evalue"));
//
//                // calculate the covergae
////                if ("basic".equals(planType)) {
////                    coverage = propertyValue * 0.5;
////                } else if ("standard".equals(planType)) {
////                    coverage = propertyValue * 0.75;
////                } else if ("premium".equals(planType)) {
////                    coverage = propertyValue * 0.9;
////                } else {
////                    // handle unknown plan type
////                }
////
//////                calculate the premium
////                if ("basic".equals(planType)) {
////                    premium = propertyValue * 0.01 * validityPeriod;
////                } else if ("standard".equals(planType)) {
////                    premium = propertyValue * 0.02 * validityPeriod;
////                } else if ("premium".equals(planType)) {
////                    premium = propertyValue * 0.03 * validityPeriod;
////                }
//
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


//    For storing the premium in database

    public void insertPremium(Student student) {
        String query = "insert into Premium (Name, PhoneNumber, Evalue, Premium) values (?,?,?,?)";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try {
            ps.setString(1, student.getUserName());
            ps.setString(2, student.getMobile_Number());
            ps.setInt(3, student.getEvalue());
            ps.setDouble(4, student.getPremium());
            System.out.println(ps);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        return student;
    }


//    helper of getPolicyList in the Manage policy

    public List<Student> getPolicyList() {
        System.out.println("getPolicyList");
        List<Student> userList = new ArrayList<>();
        String query = "select * from details";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setEmail(rs.getString("EMAIL"));
                student.setGender(rs.getString("Gender"));
                student.setOccupation(rs.getString("Occupation"));
                student.setUserName(rs.getString("fullname"));
                student.setDOB(rs.getString("DOB"));
                student.setId_Type(rs.getString("idtype"));
                student.setId_number(rs.getString("idnumber"));
                student.setAuthority(rs.getString("authority"));
                student.setState(rs.getString("state"));
                student.setDate(rs.getString("date"));
                student.setPlate_No(rs.getString("plateno"));
                student.setManufacturer(rs.getString("manufacturer"));
                student.setMotor_Dmg(rs.getString("motordmg"));
                student.setPlan(rs.getString("plan"));
                student.setValidityPeriod(rs.getString("vperiod"));
                student.setMobile_Number(rs.getString("mobilenumber"));
                student.setEvalue(rs.getInt("evalue"));

                userList.add(student);
            }
//            rs.close();
//            pstm.close();
//            System.out.println("policyList.size()"+userList.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

//    public ArrayList<Student> getPolicyListt() {
//        System.out.println("getPolicyList");
//        ArrayList<Student> policyList = new ArrayList<>();
//        String query = "select * from details";
//        System.out.println(query);
//        PreparedStatement pstm = new DBConnection().getStatement(query);
//        try {
//            ResultSet rs = pstm.executeQuery();
//            while (rs.next()) {
//                Student student = new Student();
//                student.setId(rs.getInt("id"));
//                student.setUserName(rs.getString("fullname"));
//                student.setEmail(rs.getString("EMAIL"));
//                student.setMobile_Number(rs.getString("mobilenumber"));
//                student.setValidityPeriod(rs.getString("vperiod"));
//                student.setEvalue(rs.getInt("evalue"));
//                policyList.add(student);
//            }
//            rs.close();
//            pstm.close();
//            System.out.println("policyList.size()"+policyList.size());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return policyList;
//    }


    //    For getting details of individual detail of policy that user has bought
    public Student getUserRow(int id) {
        Student student = new Student();
        String query = "select * from details where id = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                student.setId(rs.getInt("id"));
                student.setEmail(rs.getString("EMAIL"));
                student.setGender(rs.getString("Gender"));
                student.setOccupation(rs.getString("Occupation"));
                student.setUserName(rs.getString("fullname"));
                student.setDOB(rs.getString("DOB"));
                student.setId_Type(rs.getString("idtype"));
                student.setId_number(rs.getString("idnumber"));
                student.setAuthority(rs.getString("authority"));
                student.setState(rs.getString("state"));
                student.setDate(rs.getString("date"));
                student.setPlate_No(rs.getString("plateno"));
                student.setManufacturer(rs.getString("manufacturer"));
                student.setMotor_Dmg(rs.getString("motordmg"));
                student.setPlan(rs.getString("plan"));
                student.setValidityPeriod(("vperiod"));
                student.setMobile_Number(rs.getString("mobilenumber"));
                student.setEvalue(rs.getInt("evalue"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    // to change password
    public Student changePassword(Student student, String email) {
        String query = "UPDATE login_users SET password = ? WHERE email = ?";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try {
            ps.setString(2, email);
            ps.setString(1, student.getNewpassword());
            ps.executeUpdate();
            System.out.println(ps);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }



// This code is related to delete User

    public void deleteUser(int id) {
        String query = "delete from details where id = ?";
        PreparedStatement ps = new DBConnection().getStatement(query);

        try {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    This will work after user press the edit button
    public void editUser(int id, Student student) throws SQLException {

        String query = "update details set EMAIL=?, Gender=?, Occupation=?, DOB=?, fullName=?, idtype=?, idnumber=?, authority=?, state=?, date=?, plateno=?, manufacturer=?, motordmg=?, plan=?, vperiod=?,  mobilenumber=?, evalue=? where id=?";

        try (PreparedStatement pstm = new DBConnection().getStatement(query)) {
            pstm.setString(1, student.getEmail());
            pstm.setString(2, student.getGender());
            pstm.setString(3, student.getOccupation());
            pstm.setString(4, student.getUserName());
            pstm.setString(5, student.getDOB());
            pstm.setString(6, student.getId_Type());
            pstm.setString(7, student.getId_number());
            pstm.setString(8, student.getAuthority());
            pstm.setString(9, student.getState());
            pstm.setString(10, student.getDate());
            pstm.setString(11, student.getPlate_No());
            pstm.setString(12, student.getManufacturer());
            pstm.setString(13, student.getMotor_Dmg());
            pstm.setString(14, student.getPlan());
            pstm.setString(15, student.getValidityPeriod());
            pstm.setString(16, student.getMobile_Number());
            pstm.setInt(17, student.getEvalue());
            pstm.setInt(18, id);
            pstm.executeUpdate();

            System.out.println(pstm);
        }

    }


//    this will work when user make final change in the update details




    //    For registering the claim of their insurance
    public void Claim(Student student) {
        String query = "insert into claim (name, policy, address, email, number, info, file ) values (?,?,?,?,?,?, ?)";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try {
            ps.setString(1, student.getUserName());
            ps.setString(2, student.getPlan());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getMobile_Number());
            ps.setString(6, student.getInformation());
            ps.setString(7, student.getImages());
            ps.executeUpdate();
            System.out.println(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert User Error : " + e);

        }

    }

        // For searching the users
        public static List<Student> searchUsers(String query) {
            List<Student> search = new ArrayList< >();
            String sql = "SELECT * FROM details WHERE fullname LIKE ? OR EMAIL LIKE ?";
            try (PreparedStatement ps = new DBConnection().getStatement(sql);) {
                ps.setString(1, "%" + query + "%");
                ps.setString(2, "%" + query + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Student student = new Student();
                        student.setId(rs.getInt("id"));
                        student.setEmail(rs.getString("EMAIL"));
                        student.setGender(rs.getString("Gender"));
                        student.setOccupation(rs.getString("Occupation"));
                        student.setUserName(rs.getString("fullname"));
                        student.setDOB(rs.getString("DOB"));
                        student.setId_Type(rs.getString("idtype"));
                        student.setId_number(rs.getString("idnumber"));
                        student.setAuthority(rs.getString("authority"));
                        student.setState(rs.getString("state"));
                        student.setDate(rs.getString("date"));
                        student.setPlate_No(rs.getString("plateno"));
                        student.setManufacturer(rs.getString("manufacturer"));
                        student.setMotor_Dmg(rs.getString("motordmg"));
                        student.setPlan(rs.getString("plan"));
                        student.setValidityPeriod(("vperiod"));
                        student.setMobile_Number(rs.getString("mobilenumber"));
                        student.setEvalue(rs.getInt("evalue"));

                        search.add(student);
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            return search;
        }


    public static void main(String[] args) {
        UserService us = new UserService();
        us.getPolicyList();
    }

    }

