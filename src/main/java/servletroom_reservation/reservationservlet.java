package servlets;

import dao.ReservationDAO;
import dao.ReservationDAOImpl;
import beans.Reservation;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReservationServlet extends HttpServlet {
    private ReservationDAO reservationDAO = new ReservationDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Reservation> reservations = reservationDAO.getReservationsByUserId(userId);
        // Convertir la liste de réservations en JSON et envoyer la réponse
    }

    // Ajoutez d'autres méthodes pour gérer les requêtes POST, PUT, DELETE
}
