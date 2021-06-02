curl -v "localhost:8080/screenings/find-by-start-time-between?dateTimeFrom=2021-05-30T21:00:15&dateTimeTo=2021-06-15T23:23:23" | json_pp

curl -v localhost:8080/screenings/1 | json_pp

curl -X POST localhost:8080/reservations -H 'Content-type:application/json' -d '{"screeningId": 1, "firstName": "Jan", "lastName": "Kowalski-Nowak", "ticketId": 1, "seatIds": [1, 2, 35, 36]}' | json_pp

curl -v localhost:8080/reservations/1 | json_pp