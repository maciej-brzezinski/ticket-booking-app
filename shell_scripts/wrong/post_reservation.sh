curl -X POST localhost:8080/reservations -H 'Content-type:application/json' -d '{"screeningId": 1, "firstName": "Ja", "lastName": "kowalskiNowak", "ticketId": 1, "seatIds": []}' | json_pp
