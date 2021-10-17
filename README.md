# Flight  Search Applicatiom

This application is to display features and performance benefits of spring webflux module with business implementation of flight search, it is integrated with 5 downstream systems (out of which 1 is DB) each of them having delay of 500 or 600 millis using `Thread.sleep(500)`.

Response time is approximate `600-700 ms` 


## Application Configuration

All DB and URI properties can be managed in **`application.properties`**

DB can be disabled by adding below property to `application.properties` file.
> _app.isDBDisabled=**true**_

## curls

Below is curl to GET flights

curl --location --request GET 'http://localhost:8080/flights?depAirport=DXB&arrAirport=CDG&date=20Nov2021'
