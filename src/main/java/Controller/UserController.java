package Controller;

import java.io.*;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.*;

import Hashing.HashPassword;
import Model.Student;
import Service.AdminService;
import Service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@MultipartConfig
@WebServlet(name = "UserController", value = "/User")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String action = request.getParameter("page");
        out.print(action);

//        to redirect from landing page to login
        if (action.equalsIgnoreCase("userlogin")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/login.jsp"); // this code is not working
            rd.forward(request, response);
        }

        if (action.equalsIgnoreCase("login")) {
            String email =request.getParameter("email");
            String password = HashPassword.hashPassword(request.getParameter("password"));
            System.out.printf(email + " " + password + "");

            Student student = new UserService().getUser(email, password);

            if (student != null) {
                HttpSession session = request.getSession();
                session.setAttribute("uid", student.getId());
                session.setAttribute("email", student.getEmail());
                session.setAttribute("user", student.getUserName());

                request.setAttribute("msg", "Login Successful!");
                System.out.println(request.getAttribute("msg"));

                RequestDispatcher rd = request.getRequestDispatcher("user/dashboard.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }

        }
        //To redirect in claim  Page
        if (action.equalsIgnoreCase("claiminsurance")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/Claim.jsp"); // this code is not working
            rd.forward(request, response);
        }

//            To redirect to Change Password
        if (action.equalsIgnoreCase("changepassword")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/changepassword.jsp"); // this code is not working
            rd.forward(request, response);
        }
        //            To redirect to  policy plan
        if (action.equalsIgnoreCase("policyplan")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/policyplan.jsp"); // this code is not working
            rd.forward(request, response);
        }

        //        To register a new account
        if (action.equalsIgnoreCase("register")) {
            Student student = new Student();

            student.setUserName(request.getParameter("username"));
            student.setEmail(request.getParameter("email"));
            student.setStatus(request.getParameter("status"));
            student.setPassword(HashPassword.hashPassword(request.getParameter("password")));

            new UserService().insertUser(student);

            System.out.printf("Data Inserted");

            RequestDispatcher rd = request.getRequestDispatcher("user/login.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }

//        For storing the data of policy

        if (action != null && action.equalsIgnoreCase("Policy")) {
            Student student = new Student();
            int userID = (int) request.getSession().getAttribute("uid");
            System.out.println(userID);

            student.setUserName(request.getParameter("uname"));
            student.setDOB(request.getParameter("dob"));
            student.setEmail(request.getParameter("uemail"));
            student.setMobile_Number(request.getParameter("mobilenumber"));
            student.setGender(request.getParameter("gender"));
            student.setOccupation(request.getParameter("occupation"));
            student.setId_Type(request.getParameter("ID"));
            student.setId_number(request.getParameter("IDno"));
            student.setAuthority(request.getParameter("Auth"));
            student.setState(request.getParameter("Istate"));
            student.setDate(request.getParameter("Idate"));
            student.setPlate_No(request.getParameter("Pno"));
            student.setManufacturer(request.getParameter("Man"));
            student.setEvalue(Integer.parseInt(request.getParameter("Evalue")));
            student.setMotor_Dmg(request.getParameter("Mdmg"));
            student.setPlanType(request.getParameter("Plan"));
            student.setValidityPeriod(request.getParameter("Vperiod"));
            student.setBuydate(request.getParameter("buydate"));
            student.setLastdate(request.getParameter("lastdate"));

            System.out.printf("Student model: " + student.getEmail());

            new UserService().insertPolicy(userID, student);

            // Calculate the premium
            try {
                int evalue = student.getEvalue();
                String planType = student.getPlanType();
//                int vperiod = student.getValidityPeriod();
                double premium;
                if (planType.equalsIgnoreCase("All Risk")) {
                    if (evalue >= 0 && evalue <= 1500000) {
                        premium = 0.02 * evalue;
                    } else if (evalue > 1500000 && evalue <= 3000000) {
                        premium = 0.025 * evalue;
                        System.out.printf("" + student.getPremium());
                    } else {
                        premium = 0.03 * evalue;
                    }
                } else {
                    if (evalue >= 0 && evalue <= 1500000) {
                        premium = 0.015 * evalue;
                    } else if (evalue > 1500000 && evalue <= 3000000) {
                        premium = 0.02 * evalue;
                    } else {
                        premium = 0.025 * evalue;
                    }
                }
                out.print(premium);
                out.print("" + student.getPlanType());
//                    out.print("" + student.getEvalue());
//                    out.print("" + student.getPremium());
                // Store the premium in the student object
                student.setPremium(premium);
                out.print("getPremium" + student.getPremium());


                new UserService().insertPremium(userID, student);
            } catch (Exception e) {
                out.print("ERROX :" + e);
            }


            System.out.printf("Data Inserted");

            // Set the student object as an attribute to be displayed in the JSP page
            request.setAttribute("student", student);


        }


//        For Claiming the insurance by form
        if (action.equalsIgnoreCase("claim")) {

            Student student = new Student();
            int userID = (int) request.getSession().getAttribute("uid");

            Part filePart = request.getPart("files");
            String fileName = filePart.getSubmittedFileName();
            String filePathName = "C:\\Users\\Jiwan\\IdeaProjects\\collegeprojectjava4thsem-updating\\src\\main\\webapp\\files\\" + fileName;
            for (Part part : request.getParts()) {
                part.write(filePathName);

//
            }
            System.out.println(filePathName);
            try {
                System.out.println("inside the try ");
                student.setUserName(request.getParameter("name"));
                student.setPlan(request.getParameter("Insurance_policy"));
                student.setAddress(request.getParameter("address"));
                student.setEmail(request.getParameter("email"));
                student.setMobile_Number((request.getParameter("phone_number")));
                student.setInformation(request.getParameter("info"));
                student.setBuydate(request.getParameter("buydate"));

                student.setImages(filePathName);
                System.out.println(student.getUserName());
                System.out.print(student.getPlan());
                System.out.print(student.getImages());
                System.out.print(student.getAddress());
                System.out.print(student.getInformation());
                System.out.print(student.getEmail());
                new UserService().Claim(userID, student);

            }
//                for(SizeCount sc: sclist){
//                    out.print(sc.getSize()+" "+sc.getCount());
//                    new DataService().insertSizeCountForPorduct(sc);
//                }
//                out.print("Data inserted 2<br/><br/>");

            catch (Exception e) {
                out.print("ERROR: " + e);
            }


            RequestDispatcher rd = request.getRequestDispatcher("user/dashboard.jsp");
            try {
                rd.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }

        //            for showing the imgage in managepolicy
//        if (action.equalsIgnoreCase("showimage")) {
//
//            Student student = new Student();
//
//            try {
//                student.setId(Integer.parseInt(request.getParameter("id")));
//                String base64Image = new UserService().showimage(student);
//                request.setAttribute("base64Image", base64Image);
//            } catch (Exception e) {
//                request.setAttribute("errorMessage", "Error retrieving image: " + e.getMessage());
//            }
//
//            RequestDispatcher rd = request.getRequestDispatcher("user/claimdetails.jsp");
//            rd.forward(request, response);
//
//
//        }
        if (action.equalsIgnoreCase("showimage")) {

            System.out.println("here in the show image or view reults");

            Student student = new Student();
            student.setId(Integer.parseInt(request.getParameter("id")));
            HashMap<String, Object> details = null;
            try {
                details = new UserService().showDetails(student);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("details", details);

//            RequestDispatcher rd = request.getRequestDispatcher("user/viewresult.jsp");
//            rd.forward(request, response);

        }

        // For redirecting to forgot password

        if (action.equalsIgnoreCase("forgotpassword")) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("user/forgotpassword.jsp");
            dispatcher.forward(request, response);
        }

//            This shows details of policy is list in webpage
        if (action.equalsIgnoreCase("listpolicies")) {
            out.print("listpolicies");
            Student student = new Student();
//                student.setUserName("kritesh");
            int userID = (int) request.getSession().getAttribute("uid");
            List<Student> policyList = new UserService().getPolicyList(userID);
//                ArrayList<Student> policyList = new UserService().getPolicyListt();
            out.print("policyList" + policyList.size());

            request.setAttribute("student", student);
            request.setAttribute("policyList", policyList);

            RequestDispatcher rd = request.getRequestDispatcher("user/managepolicy.jsp");
            rd.forward(request, response);


        }

//            policyDetails (for getting all the details of policy plan by id )
        if (action.equalsIgnoreCase("policyDetails")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = new UserService().getUserRow(id);
            request.setAttribute("id", id);
            request.setAttribute("student", student);  //Why this

            RequestDispatcher rd = request.getRequestDispatcher("user/user_details.jsp");
            rd.forward(request, response);
        }

//            For userEdit where user can edit the information of the policy
        if (action.equalsIgnoreCase("userEdit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            Student student = new UserService().getUserRow(id);
            request.setAttribute("id", id);
            request.setAttribute("student", student);
            RequestDispatcher rd = request.getRequestDispatcher("user/update_details.jsp");
            rd.forward(request, response);
        }


        // this is invoked when user press the edit button
        if (action.equalsIgnoreCase("finaledit")) {
            Student student = new Student();
            int userID = (int) request.getSession().getAttribute("uid");
            System.out.println("i am inside the final edit");

            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            student.setUserName(request.getParameter("uname"));
            student.setDOB(request.getParameter("dob"));
            student.setEmail(request.getParameter("uemail"));
            student.setMobile_Number(request.getParameter("mobilenumber"));
            student.setGender(request.getParameter("gender"));
            student.setOccupation(request.getParameter("occupation"));
            student.setId_Type(request.getParameter("ID"));
            student.setId_number(request.getParameter("IDno"));
            student.setAuthority(request.getParameter("Auth"));
            student.setState(request.getParameter("Istate"));
            student.setDate(request.getParameter("Idate"));
            student.setPlate_No(request.getParameter("Pno"));
            student.setManufacturer(request.getParameter("Man"));
            student.setMotor_Dmg(request.getParameter("Mdmg"));
            student.setPlan(request.getParameter("Plan"));
            student.setValidityPeriod(request.getParameter("Vperiod"));
            student.setEvalue(Integer.parseInt(request.getParameter("Evalue")));

            try {
                new UserService().editUser(id, student);

                List<Student> policyList = new UserService().getPolicyList(userID);
                request.setAttribute("policyList", policyList);
                RequestDispatcher rd = request.getRequestDispatcher("user/managepolicy.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                // handle the exception
            }
        }


//            For user to delete the policy
        if (action.equalsIgnoreCase("deleteUser")) {
            String userID = (String) request.getSession().getAttribute("uid");
//            int id = Integer.parseInt(request.getParameter("policyId"));
            int id = Integer.parseInt(request.getParameter("id"));

            UserService userService = new UserService();
            userService.deleteUser(id);
            List<Student> userList = new UserService().getPolicyList(Integer.parseInt(userID));
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/managepolicy.jsp");
            rd.forward(request, response);
        }


        // for changing password
        if (action.equalsIgnoreCase("changingpassword")) {
            Student student = new Student();
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            student.setPassword(HashPassword.hashPassword(request.getParameter("oldpassword")));
            student.setNewpassword(HashPassword.hashPassword(request.getParameter("newpassword")));
            new UserService().changePassword(student, email);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);

        }


        //            for logout
        if (action.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(false);
            session.invalidate();

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }



        //To redirect in viewpremium
        if (action.equalsIgnoreCase("viewpremium")) {
            Student student = new Student();

            List<Student> premiumlist = new UserService().getPremiumList();
            request.setAttribute("premiumlist", premiumlist);
            RequestDispatcher rd = request.getRequestDispatcher("user/viewpremium.jsp"); // this code is not working
            rd.forward(request, response);
        }


        // for searching users
        if (action.equalsIgnoreCase("search")) {
            String query = request.getParameter("query");
            List<Student> searchResults = UserService.searchUsers(query);
            request.setAttribute("searchResults", searchResults);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/search-results.jsp");
            dispatcher.forward(request, response);
        }

 // To return to homepage
        if (action.equalsIgnoreCase("return")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/dashboard.jsp");
            dispatcher.forward(request, response);
        }


//to show the result

        if (action.equalsIgnoreCase("viewresult")) {

            System.out.println("here in the show image or view reults");
            Student student = new Student();
            int userID = (int) request.getSession().getAttribute("uid");
            List<Student> viewresult = new UserService().getclaimlist(userID);
//                ArrayList<Student> policyList = new UserService().getPolicyListt();
            out.print("policyList" + viewresult.size());

            request.setAttribute("student", student);
            request.setAttribute("viewresult", viewresult);

            RequestDispatcher rd = request.getRequestDispatcher("user/viewresult.jsp");
            rd.forward(request, response);

        }




    }  // do post
}







