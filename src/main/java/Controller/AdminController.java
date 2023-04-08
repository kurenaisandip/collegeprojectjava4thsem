package Controller;

import Hashing.HashPassword;
import Model.Student;
import Service.AdminService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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

        if (action.equalsIgnoreCase("sorting")) {
            List<Student> students = AdminService.getAllStudents();
            // Check if the "sort" parameter is present in the request
            String sortBy = request.getParameter("sort");
            if (sortBy != null) {
                // Sort the list of students based on the given field
                AdminService.sort(students, sortBy);
            }

            // Set the sorted list of students as a request attribute
            // Forward the request to the JSP view
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin/view.jsp");
            dispatcher.forward(request, response);
        }



    }

}
