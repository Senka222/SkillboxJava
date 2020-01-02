import core.Line;
import core.Station;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Metro scheme that used in tests:
 * <pre>{@code
 *           (First line)(Third line)
 *                1           7
 *                v           ^
 * (Second line) 2/3 -> 4 -> 5/6
 * }</pre>
 */

public class RouteCalculatorTest{

    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @BeforeEach
    protected void setUp() throws Exception {

        stationIndex = new StationIndex();

        addLineToIndexInTest("First line", 1);
        addLineToIndexInTest("Second line", 2);
        addLineToIndexInTest("Third line", 3);

        addStationToIndexInTest("First", 1);
        addStationToIndexInTest("Second", 1);
        addStationToIndexInTest("Third", 2);
        addStationToIndexInTest("Fourth", 2);
        addStationToIndexInTest("Fifth", 2);
        addStationToIndexInTest("Sixth", 3);
        addStationToIndexInTest("Seventh", 3);

        addConnectionToIndexInTest("Second", "Third");
        addConnectionToIndexInTest("Fifth", "Sixth");

        routeCalculator = new RouteCalculator(stationIndex);
    }

    protected void addLineToIndexInTest(String name, int number)
    {
        Line line = new Line(number, name);
        stationIndex.addLine(line);
    }

    private void addStationToIndexInTest(String name, int lineNumber)
    {
        Station station = new Station(name, stationIndex.getLine(lineNumber));
        stationIndex.getLine(lineNumber).addStation(station);
        stationIndex.addStation(station);
    }

    private void addConnectionToIndexInTest(String... stationName)
    {
        List<Station> connection = new ArrayList<>();
        for (String s : stationName) {
            connection.add(stationIndex.getStation(s));
        }
        stationIndex.addConnection(connection);
    }

    @Test
    public void CalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(routeCalculator.getShortestRoute(getStationForTest("First"),
                getStationForTest("Fourth")));
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    @Test
    public void GetShortestRouteOnTheLine()
    {
        List<Station> actual = routeCalculator.getShortestRoute(getStationForTest("Third"),
                getStationForTest("Fifth"));
        List<Station> expected = buildRoute("Third", "Fourth", "Fifth");

        assertEquals(expected, actual);
    }

    @Test
    public void GetShortestRouteOnTheTwoLines()
    {
        List<Station> actual = routeCalculator.getShortestRoute(getStationForTest("First"),
                getStationForTest("Fifth"));
        List<Station> expected = buildRoute("First", "Second", "Third", "Fourth", "Fifth");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetShortestRouteOnTheThreeLines()
    {
        List<Station> actual = routeCalculator.getShortestRoute(getStationForTest("First"),
                getStationForTest("Seventh"));
        List<Station> expected = buildRoute("First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh");

        assertEquals(expected, actual);
    }

    @Test
    public void OnConnectedStations()
    {
        List<Station> actual = routeCalculator.getShortestRoute(getStationForTest("Second"),
                getStationForTest("Third"));
        List<Station> expected = buildRoute("Second", "Third");

        assertEquals(expected, actual);
    }

    @Test
    public void ReverseDirection()
    {
        List<Station> actual = routeCalculator.getShortestRoute(getStationForTest("Seventh"),
                getStationForTest("Fourth"));
        List<Station> expected = buildRoute("Seventh", "Sixth", "Fifth", "Fourth");

        assertEquals(expected, actual);
    }

    @Test
    public void SameStations()
    {
        List<Station> actual = routeCalculator.getShortestRoute(getStationForTest("First"),
                getStationForTest("First"));
        List<Station> expected = buildRoute("First");
        assertEquals(expected,actual);
    }

    private Station getStationForTest (String stationName)
    {
        return stationIndex.getStation(stationName);
    }

    private List<Station> buildRoute(String... stationName)
    {
        List<Station> route = new ArrayList<>();
        for (String s: stationName)
        {
            route.add(stationIndex.getStation(s));
        }
        return route;
    }

    @AfterEach
    protected void tearDown() throws Exception {
    }
}
