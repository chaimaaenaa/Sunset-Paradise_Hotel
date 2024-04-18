package servlets;

import dao.RoomDAO;
import dao.RoomDAOImpl;
import beans.Room;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoomServlet extends HttpServlet {
    private RoomDAO roomDAO = new RoomDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> rooms = roomDAO.getAllRooms();
        // Convertir la liste de chambres en JSON et envoyer la réponse
    }

    // Ajoutez d'autres méthodes pour gérer les requêtes POST, PUT, DELETE
}
