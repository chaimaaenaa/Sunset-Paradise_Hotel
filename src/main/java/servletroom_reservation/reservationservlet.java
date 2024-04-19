
package servletroom_reservation;

import java.io.IOException;
import java.util.List;

import dao.ReservationDAO;
import dao.ReservationDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import les_classes.Reservation;

public class ReservationServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5049771460748395530L;
	private ReservationDAO reservationDAO = new ReservationDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

      
    }

}
