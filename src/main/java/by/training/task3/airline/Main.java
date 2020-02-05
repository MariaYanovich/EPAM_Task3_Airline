package by.training.task3.airline;

import by.training.task3.airline.repository.impl.AirlineRepositoryImpl;
import by.training.task3.airline.service.AirlineService;
import by.training.task3.airline.service.impl.AirlineServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
//        AirlineRepositoryImpl repository = new AirlineRepositoryImpl();
//        repository.initializeRepository();
//        repository.removePlane(new TransportPlane());
//        System.out.println(repository.getPlaneById(2));
//        //System.out.println(repository);

        AirlineServiceImpl airlineServiceImplementation = new AirlineServiceImpl();
        airlineServiceImplementation.sortByPracticalFlightDistanceAndTypeOfPlane();

    }
}
