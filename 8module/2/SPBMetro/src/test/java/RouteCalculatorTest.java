import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Metro scheme that used in tests:
 * <pre>{@code
 *           (First line)(Third line)
 *                1           7
 *                v           ^
 * (Second line) 2/3 -> 4 -> 5/6
 * }</pre>
 */

public class RouteCalculatorTest extends TestCase {

    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @BeforeClass
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

    @Test                                       //нужно ли писать аннотацию? если да, то один раз или перед каждым тестом?
    public void testCalculateDuration()
    {

        double actual = RouteCalculator.calculateDuration(routeCalculator.getShortestRoute(getStationForTest("First"),
                getStationForTest("Fourth")));
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnTheLine()
    {
        List<Station> actual = routeCalculator.getShortestRoute(getStationForTest("Third"),
                getStationForTest("Fifth"));
        List<Station> expected = buildRoute("Third", "Fourth", "Fifth");

        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnTheTwoLines()
    {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("First",1),
                stationIndex.getStation("Fifth",2));
        List<Station> expected = buildRoute("First", "Second", "Third", "Fourth", "Fifth");
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnTheThreeLines()
    {
        List<Station> actual = routeCalculator.getShortestRoute(getStationForTest("First"),
                getStationForTest("Seventh"));
        List<Station> expected = buildRoute("First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh");

        assertEquals(expected, actual);
    }

    public void testOnConnectedStations()
    {
        List<Station> actual = routeCalculator.getShortestRoute(getStationForTest("Second"),
                getStationForTest("Third"));
        List<Station> expected = buildRoute("Second", "Third");

        assertEquals(expected, actual);
    }

    public void testReverseDirection()
    {
        List<Station> actual = routeCalculator.getShortestRoute(getStationForTest("Seventh"),
                getStationForTest("Fourth"));
        List<Station> expected = buildRoute("Seventh", "Sixth", "Fifth", "Fourth");

        assertEquals(expected, actual);
    }

    public void testSameStations()
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

    @AfterClass
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
