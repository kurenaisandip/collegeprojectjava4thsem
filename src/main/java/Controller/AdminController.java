package Controller;

import Hashing.HashPassword;
import Model.Student;
import Service.AdminService;
import Service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "AdminController", value = "/admin")
public class AdminController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();


        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("login") ){

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            System.out.println(email + " " + password + " ");

            Student student = new AdminService().getUser(email, password);
//            System.out.println(user.getUsername()+" "+user.getPassword());
            if (student != null) {
                HttpSession session = request.getSession();
                session.setAttribute("uid", student.getId());
                session.setAttribute("full", student.getEmail());
                session.setAttribute("user", email);
                //                    System.out.println(session.getAttribute("user"));
                request.setAttribute("msg", "Login Successful!");
                System.out.println(request.getAttribute("msg"));

                RequestDispatcher rd = request.getRequestDispatcher("admin/adDashboard.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }

        }

        // send to admin page
        if (action.equalsIgnoreCase("adminlogin"))

        {
            RequestDispatcher rd = request.getRequestDispatcher("admin/adlogin.jsp");
            rd.forward(request, response);
        }

//        Show the user list in list user page
        if (action.equalsIgnoreCase("listuser") ){

            Student student = new Student();
            List<Student> studentList = new AdminService().getUserList();

            request.setAttribute("student", student);
            request.setAttribute("studentlist", studentList);
            RequestDispatcher rd = request.getRequestDispatcher("admin/listuser.jsp");
            rd.forward(request, response);


        }

//        For user_details
        if (action.equalsIgnoreCase("userDetails"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = new AdminService().getUserRow(id);
            request.setAttribute("id", id);
            request.setAttribute("student", student);  //Why this

            RequestDispatcher rd = request.getRequestDispatcher("admin/user_details.jsp");
            rd.forward(request, response);
        }

        // for deleting users in user_details page
        if (action.equalsIgnoreCase("deleteUser"))

        {
            int id = Integer.parseInt(request.getParameter("id"));
            AdminService userService = new AdminService();
            userService.deleteUser(id);
            List<Student> userList = new AdminService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("admin/listuser.jsp");
            rd.forward(request, response);
        }


        // for editing users
        if (action.equalsIgnoreCase("userEdit"))

        {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            Student student = new AdminService().getUserRow(id);
            request.setAttribute("id", id);
            request.setAttribute("student", student);
            RequestDispatcher rd = request.getRequestDispatcher("admin/update_user.jsp");
            rd.forward(request, response);
        }

        if (action.equalsIgnoreCase("editUser"))

        {
            Student student = new Student();
            int id = Integer.parseInt(request.getParameter("id"));
            student.setUserName(request.getParameter("userName"));
            student.setEmail(request.getParameter("email"));

            student.setPassword(request.getParameter("password"));

            try {
                new AdminService().editUser(id, student);
            } catch ( SQLException e) {
                e.printStackTrace();
            }
            List<Student> userList = new AdminService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("admin/list_user.jsp");
            rd.forward(request, response);
        }

        if(action.equalsIgnoreCase("logout")){
            HttpSession session = request.getSession(false);
            session.invalidate();

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }


//        For Sorting Part 2
        if (action != null && action.equalsIgnoreCase("sorting")) {
            List<Student> sortedNames = AdminService.getAllStudents();
            request.setAttribute("names", sortedNames);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/view.jsp");
            dispatcher.forward(request, response);
        }

//        for showing the join table and claim made by user
//        if (action != null && action.equalsIgnoreCase("seeclaim")) {
//            List<Student> seeclaim = null;
//            try {
//                seeclaim = AdminService.seeclaims();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            request.setAttribute("seeclaim", seeclaim);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/view.jsp");
//            dispatcher.forward(request, response);
//        }

//    TODO: make user enable
        if (action.equalsIgnoreCase("enable")){
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

           new AdminService().enableaccount(id, status);
            RequestDispatcher rd = request.getRequestDispatcher("admin/listuser.jsp");
            rd.forward(request, response);

        }
        //    TODO: make user disable
        if (action.equalsIgnoreCase("disable")){
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

           new AdminService().disableaccount(id, status);
            RequestDispatcher rd = request.getRequestDispatcher("admin/listuser.jsp");
            rd.forward(request, response);

        }
//        to see people who have filed for claim
        if (action.equalsIgnoreCase("claimlist")) {

            List<Student> list;
            try {
                list = new AdminService().claimlist();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            request.setAttribute("list", list);
            RequestDispatcher rd = request.getRequestDispatcher("admin/claimlist.jsp");
            rd.forward(request, response);

        }

        // to show the claim details
        if (action.equalsIgnoreCase("ClaimDetail")) {

            Student student = new Student();
            student.setId(Integer.parseInt(request.getParameter("id")));
            HashMap<String, Object> details = null;
            try {
                details = new AdminService().showclaim(student);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            request.setAttribute("details", details);

            RequestDispatcher rd = request.getRequestDispatcher("admin/seeclaim.jsp");
            rd.forward(request, response);

        }




    }

}
