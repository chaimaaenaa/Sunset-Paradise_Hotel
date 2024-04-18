package servletroom_reservation;

import dao.ReservationDAO;
import dao.ReservationDAOImpl;
import beans.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper; // Import de la bibliothèque pour convertir les objets en JSON
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class reservationServlet extends HttpServlet {
    private ReservationDAO reservationDAO = new reservationDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Reservation> reservations = reservationDAO.getReservationsByUserId(userId);

        // Convertir la liste de réservations en JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String reservationsJson = objectMapper.writeValueAsString(reservations);

        // Définir le type de contenu de la réponse et envoyer la réponse
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(reservationsJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données de la requête
        String roomIdStr = request.getParameter("roomId");
        int roomId = Integer.parseInt(roomIdStr);
        int userId = Integer.parseInt(request.getParameter("userId"));
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        
        // Convertir les dates de chaînes de caractères à java.util.Date
        // Ceci est une étape simplifiée, vous devriez utiliser un SimpleDateFormat pour une conversion plus précise
        // Date startDate = ...;
        // Date endDate = ...;

        // Créer une nouvelle réservation
        Reservation newReservation = new Reservation();
        newReservation.setRoomId(roomId);
        newReservation.setUserId(userId);
        // newReservation.setStartDate(startDate);
        // newReservation.setEndDate(endDate);

        // Ajouter la nouvelle réservation à la base de données
        boolean success = reservationDAO.addReservation(newReservation);

        // Envoyer la réponse
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(success ? "Réservation ajoutée avec succès" : "Échec de l'ajout de la réservation");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données de la requête
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        
        // Convertir les dates de chaînes de caractères à java.util.Date
        // Date startDate = ...;
        // Date endDate = ...;

        // Mettre à jour la réservation correspondante dans la base de données
        boolean success = reservationDAO.updateReservation(reservationId, startDateStr, endDateStr);

        // Envoyer la réponse
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(success ? "Réservation mise à jour avec succès" : "Échec de la mise à jour de la réservation");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID de la réservation à supprimer
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));

        // Supprimer la réservation correspondante de la base de données
        boolean success = reservationDAO.deleteReservation(reservationId);

        // Envoyer la réponse
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(success ? "Réservation supprimée avec succès" : "Échec de la suppression de la réservation");
    }
}
