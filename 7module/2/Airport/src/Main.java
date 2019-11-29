import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        Airport airport = Airport.getInstance();

        airport.getTerminals().stream()
                .map(terminal -> Arrays.toString(terminal.getFlights().stream()
                        .filter(flight -> flight.getDate().after(Time.valueOf(LocalTime.now())) && flight.getDate().before(Time.valueOf(LocalTime.now().plusHours(2))))
                        .toArray(Flight[]::new))).forEach(System.out::println);

 /*       Aircraft aircraft = new Aircraft("sfsd");
        Flight flight = new Flight("sdf", Flight.Type.ARRIVAL, Time.valueOf(LocalTime.now().plusHours(1)), aircraft);
        System.out.println();
        if (flight.getDate().after(Time.valueOf(LocalTime.now())) &&  flight.getDate().before(Time.valueOf(LocalTime.now().plusHours(2))))
        {
            System.out.println("влазит");
        }
        else System.out.println("не влазит");

        System.out.println(Time.valueOf(LocalTime.now()));
        System.out.println(flight.getDate());
        System.out.println(Time.valueOf(LocalTime.now().plusHours(2)));
*/
    }
}
