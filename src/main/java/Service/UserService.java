package Service;

import DBConnection.DBConnection;
import Model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Files;
import java.sql.*;
import java.util.*;

public class UserService {

    public void insertUser(Student student) {
        String query = "insert into login_users(username, email, password, status)" + "values(?,?,?,?)"; // same as database

        PreparedStatement preparedStatements = new DBConnection().getStatement(query);  // execute parametrized query

        try {
            preparedStatements.setString(1, student.getUserName());
            preparedStatements.setString(2, student.getEmail());
            preparedStatements.setString(3, student.getPassword());
            preparedStatements.setString(4, student.getStatus());

            preparedStatements.execute();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getUser(String email, String password) {
        Student student = null;

        String query = "select * from login_users where email=? and password=? AND status='active'";
        PreparedStatement ps = new DBConnection().getStatement(query);

        try {
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            System.out.println(ps);

            while (rs.next()) {
                student = new Student();

                student.setId(rs.getInt("uid"));
                student.setUserName(rs.getString("username"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }


    // this is for inserting the policy plan
    public Student insertPolicy(int userID, Student student) {

        String query = "insert into details (EMAIL,Gender,Occupation,fullname,DOB,idtype,idnumber,authority,state,date,plateno,manufacturer,motordmg,plan,vperiod, mobilenumber, evalue, buydate, lastdate, uid) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try {
            System.out.println("i am inside the insert policy");
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
            ps.setString(18, student.getBuydate());
            ps.setString(19, student.getLastdate());
            ps.setString(20, String.valueOf(userID));
//            System.out.println("uid : " + userID);
            System.out.printf("" + ps);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }


//    For storing the premium in database

    public void insertPremium(int userID ,Student student) {
        String query = "insert into premium (Name, PhoneNumber, Evalue, Premium, uid) values (?,?,?,?,?)";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try {
            ps.setString(1, student.getUserName());
            ps.setString(2, student.getMobile_Number());
            ps.setInt(3, student.getEvalue());
            ps.setDouble(4, student.getPremium());
            ps.setString(5, String.valueOf(userID));
            System.out.println(ps);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        return student;
    }


//    helper of getPolicyList in the Manage policy

    public List<Student> getPolicyList(int userID) {
        System.out.println("getPolicyList");
        List<Student> userList = new ArrayList<>();
        String query = "SELECT * FROM details WHERE uid = ?";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, Integer.parseInt(String.valueOf(userID)));
            System.out.println(userID);
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

    public void deleteUser(int id, int userID) {
        String query = "DELETE FROM details WHERE uid = ? AND id = ?";
        PreparedStatement ps = new DBConnection().getStatement(query);
        System.out.println(ps);

        try {
            ps.setInt(2, id);
            ps.setInt(1, userID);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //    This will work after user press the edit button
    public void editUser(int id, Student student) throws SQLException {

        System.out.println("hello edit user ");
        String query = "UPDATE details SET EMAIL=?, Gender=?, Occupation=?, fullName=?, DOB=?, idtype=?, idnumber=?, authority=?, state=?, date=?, plateno=?, manufacturer=?, motordmg=?, plan=?, vperiod=?, mobilenumber=?, evalue=? WHERE id=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            System.out.println("inside the edit user or final edit ");
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
        }catch (SQLException e){
            System.out.println(e);
        }
    }



//    this will work when user make final change in the update details


    //    For registering the claim of their insurance
    public void Claim(int userID, Student student) {
        String query = "insert into claim (name, policy, address, email, number, info, file, buydate,  uid, status, lastdate ) values (?,?,?,?,?,?,?,?,?, ?, ?)";
        PreparedStatement ps = new DBConnection().getStatement(query);
        try {
            ps.setString(1, student.getUserName());
            ps.setString(2, student.getPlan());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getMobile_Number());
            ps.setString(6, student.getInformation());
            ps.setString(7, student.getImages());
            ps.setString(8, student.getBuydate());
            ps.setString(9, String.valueOf(userID));
            ps.setString(10, student.getStatus());
            ps.setString(11, student.getLastdate());

            ps.executeUpdate();
            System.out.println(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Insert User Error : " + e);

        }

    }

    // For searching the users
    public static List<Student> searchUsers(String query) {
        List<Student> search = new ArrayList<>();
        String sql = "SELECT * FROM details WHERE fullname LIKE ? OR EMAIL LIKE ? OR plateno LIKE ? OR mobilenumber LIKE ? OR plan LIKE ? OR vperiod LIKE ? OR evalue LIKE ? OR buydate LIKE ? OR lastdate LIKE ?";
        try (PreparedStatement ps = new DBConnection().getStatement(sql);) {
            ps.setString(1, "%" + query + "%");
            ps.setString(2, "%" + query + "%");
            ps.setString(3, "%" + query + "%");
            ps.setString(4, "%" + query + "%");
            ps.setString(5, "%" + query + "%");
            ps.setString(6, "%" + query + "%");
            ps.setString(7, "%" + query + "%");
            ps.setString(8, "%" + query + "%");
            ps.setString(9, "%" + query + "%");
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
                    student.setValidityPeriod(rs.getString("vperiod"));
                    student.setMobile_Number(rs.getString("mobilenumber"));
                    student.setEvalue(rs.getInt("evalue"));
                    student.setBuydate(rs.getString("buydate"));
                    student.setLastdate(rs.getString("lastdate"));

                    search.add(student);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return search;
    }





//    public static void main(String[] args) {
//        UserService us = new UserService();
//        us.getPolicyList();
//    }

    //    for showing image in the browser
    public String showimage(Student student) throws SQLException {
        String base64Image = "";

        // Retrieve the image data from the database
        String query = "SELECT file FROM claim WHERE id = ?";
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
                System.out.println(file);

                // Convert the byte array to a base64 string
                base64Image = Base64.getEncoder().encodeToString(fileContent);
                System.out.println(base64Image);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return base64Image;
    }

    public HashMap<String, Object> showDetails(Student student) throws SQLException {
        HashMap<String, Object> details = new HashMap<>();
        String base64Image = "";

        // Retrieve the image data and student details from the database
        String query = "SELECT file, name, number, policy, email, info " + "FROM claim " + "WHERE id = ?";
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
                String buydate = rs.getString("buydate");



                details.put("name", name);
                details.put("phone_number", phoneNumber);
                details.put("policy", policy);
                details.put("email", email);
                details.put("info", info);
                details.put("image", base64Image);
                details.put("images", images);
                details.put("buydate", buydate);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return details;
    }

    public static List<Student> getPremiumList() {
        System.out.println("getPremiumList");
        List<Student> premiumlist1 = new ArrayList<>();
        String query = "SELECT premium.id, premium.Name, premium.PhoneNumber, premium.Evalue, premium.Premium, details.buydate, details.lastdate " +
                "FROM premium " +
                "JOIN details " +
                "ON premium.uid = details.uid";

        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setUserName(rs.getString("Name"));
                student.setMobile_Number(rs.getString("PhoneNumber"));
                student.setEvalue(rs.getInt("Evalue"));
                student.setPremium(rs.getInt("Premium"));
                student.setBuydate(rs.getString("buydate"));
                student.setLastdate(rs.getString("lastdate"));

                premiumlist1.add(student);

                System.out.println(pstm);
                System.out.println(student.getLastdate());
                System.out.println(student.getBuydate());
                System.out.println(student.getPremium());
                System.out.println(student.getMobile_Number());
                System.out.println(student.getEvalue());
                System.out.println(student.getUserName());
                System.out.println(student.getId());
            }

            // Sort the premium list by buy date
            Collections.sort(premiumlist1, Comparator.comparing(Student::getBuydate));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return premiumlist1;
    }

    public static List<Student> getclaimlist(int userID) {
        List<Student> claimlist = new ArrayList<>();
        String query = "SELECT  id,name, number, policy, email, info, buydate, status, lastdate " + "FROM claim " + "WHERE uid = ?";


        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, Integer.parseInt(String.valueOf(userID)));
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setUserName(rs.getString("name"));
                student.setMobile_Number(rs.getString("number"));
                student.setPlanType(rs.getString("policy"));
                student.setEmail(rs.getString("email"));
                student.setInformation(rs.getString("info"));
                student.setBuydate(rs.getString("buydate"));
                student.setStatus(rs.getString("status"));
                student.setLastdate(rs.getString("lastdate"));

                claimlist.add(student);

                System.out.println(pstm);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claimlist;
    }









}


