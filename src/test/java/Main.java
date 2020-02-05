import by.training.task3.airline.service.impl.AirlineServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        AirlineServiceImpl airlineServiceImplementation = new AirlineServiceImpl();
//        for (Plane plane : airlineServiceImplementation.sortByFlightDistance()) {
//            System.out.println(plane);
//        }
//        System.out.println(airlineServiceImplementation.findPlaneWithMaxSpeed());

        System.out.println(airlineServiceImplementation.sumAllTakeoffWeight());
        System.out.println(airlineServiceImplementation.getPlaneById(9));
        airlineServiceImplementation.sortByFlightDistance();
    }
}
