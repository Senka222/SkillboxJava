import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        Airport airport = Airport.getInstance();

        airport.getTerminals().stream()
                .map(terminal -> Arrays.toString(terminal.getFlights().stream()
                .filter(flight -> dateToInstant(flight.getDate()).isAfter(Instant.now()) && dateToInstant(flight.getDate()).isBefore(Instant.now().plusMillis(7200000)))
                .toArray(Flight[]::new))).forEach(System.out::println);

    }
    private static Instant dateToInstant (Date date)
    {
        return date.toInstant();
    }
}
