package servletroom_reservation;
import dao.RoomDAOImpl;
import dao.RoomDAO;
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RoomServlet")
public class Roomservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Roomservlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RoomDAO roompl =new RoomDAOImpl();
       
            try {
                request.setAttribute("rooms", roompl.displayRoom());
               
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.getServletContext().getRequestDispatcher("/WEB-INF/Hotel.jsp").forward(request, response);

        }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request,response);
       }

}