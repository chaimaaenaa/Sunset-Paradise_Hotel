<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sunset Paradise Hotel</title>
</head>
<body>

<table border="1">
        <tr>
            <th>Id</th>
            <th>Type</th>
            <th>Prix</th>
             <th>Equipement</th>
             <th>Disponibilite</th>

        </tr>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td>${room.getId()}</td>
                <td>${room.getType()}</td>
                <td>${room.getPrix()}</td>
                <td>${room.getEquipements()}</td>
                <td>${room.isDisponibilite()}</td>

            </tr>
        </c:forEach>
    </table>


     <h1>les Chambres Reservées</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>room id</th>
            <th>start date</th>
            <th>end date</th>
            <th>num guests</th>

        </tr>
        <c:forEach var="reserve" items="${reservation}">
            <tr>
                <td>${reserve.getId()}</td>
                <td>${reserve.getR_id()}</td>
                <td>${reserve.getStart_date()}</td>
                <td>${reserve.getEnd_date()}</td>
                <td>${reserve.getNum_guests()}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>