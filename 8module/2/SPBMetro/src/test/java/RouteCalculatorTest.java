import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @Override
    protected void setUp() throws Exception {  // можно ли это заменить на BeforeClass?

        stationIndex = new StationIndex();
        Line line1 = new Line(1, "First Line");
        Line line2 = new Line(2, "Second Line");
        Line line3 = new Line(3, "Third Line");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        Station station1 = new Station("First", line1);
        Station station2 = new Station("Second", line1);
        Station station3 = new Station("Third", line2);
        Station station4 = new Station("Fourth", line2);
        Station station5 = new Station("Fifth", line2);
        Station station6 = new Station("Sixth", line3);
        Station station7 = new Station("Seventh", line3);

        stationIndex.addStation(station1);  //чот не сообразил, можно ли их добавить через цикл
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addStation(station7);

        line1.addStation(station1);
        line1.addStation(station2);
        line2.addStation(station3);
        line2.addStation(station4);
        line2.addStation(station5);
        line3.addStation(station6);
        line3.addStation(station7);

        List<Station> firstConnection = new ArrayList<>();
        List<Station> secondConnection = new ArrayList<>();

        firstConnection.add(station2);
        firstConnection.add(station3);
        secondConnection.add(station5);
        secondConnection.add(station6);

        stationIndex.addConnection(firstConnection);
        stationIndex.addConnection(secondConnection);

        routeCalculator = new RouteCalculator(stationIndex);
    }

    @Test                                       //нужно ли писать аннотацию? если да, то один раз или перед каждым тестом?
/*    public void testCalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }
*/
    public void testGetShortestRouteOnTheLine()
    {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Third",2),
                stationIndex.getStation("Fifth",2));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Third",2));
        expected.add(stationIndex.getStation("Fourth",2));
        expected.add(stationIndex.getStation("Fifth",2));

        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnTheTwoLines()
    {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("First",1),
                stationIndex.getStation("Fifth",2));
        List<Station> expected = new ArrayList<>();

        expected.add(stationIndex.getStation("First",1));
        expected.add(stationIndex.getStation("Second",1));
        expected.add(stationIndex.getStation("Third",2));
        expected.add(stationIndex.getStation("Fourth",2));
        expected.add(stationIndex.getStation("Fifth",2));

        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnTheThreeLines()
    {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("First",1),
                stationIndex.getStation("Seventh",3));
        List<Station> expected = new ArrayList<>();

        expected.add(stationIndex.getStation("First",1));
        expected.add(stationIndex.getStation("Second",1));
        expected.add(stationIndex.getStation("Third",2));
        expected.add(stationIndex.getStation("Fourth",2));
        expected.add(stationIndex.getStation("Fifth",2));
        expected.add(stationIndex.getStation("Sixth",3));
        expected.add(stationIndex.getStation("Seventh",3));

        assertEquals(expected, actual);
    }

    public void testOnConnectedStations()
    {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Second",1),
                stationIndex.getStation("Third",2));
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Second",1));
        expected.add(stationIndex.getStation("Third",2));

        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
