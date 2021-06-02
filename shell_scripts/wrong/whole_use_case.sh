curl -v "localhost:8080/screenings/find-by-start-time-between?dateTimeFrom=2021-05-30T21:00:15&dateTimeTo=2021-05-30T23:23:23" | json_pp

curl -v localhost:8080/screenings/123 | json_pp

curl -X POST localhost:8080/reservations -H 'Content-type:application/json' -d '{"screeningId": 1, "firstName": "Ja", "lastName": "kowalskiNowak", "ticketId": 1, "seatIds": []}' | json_pp

curl -v localhost:8080/reservations/123 | json_pp

