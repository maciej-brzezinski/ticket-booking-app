# ticket-booking-app

all shell scripts to run the application are in the shell_scripts directory

the application is started with "app_run.sh" 

there are two shell folders, one with correct queries the other with wrong parameters to show error handling

user sends request for available screenings from "get_screenings" shell script 
and gets a response with list of screenings

user can choose a screening as in script "get_screening_details.sh"
response show free seats (based on seat->reservation being null or not)
 
user chooses a screening and makes a request for creating a reservation for the particular screening as in "post_reservation.sh"

the system returns a reservation entity, user can access the reservation from "get_reservation_details.sh"

whole use case can be accessed through "whole_use_case.sh"

