package by.training.task3.airline.repository.impl;

import by.training.task3.airline.entity.Plane;
import by.training.task3.airline.entity.TransportPlane;

import by.training.task3.airline.factory.PlaneFactory;
import by.training.task3.airline.reader.ReaderOfPlanesFromTxtFile;

import by.training.task3.airline.repository.AirlineRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;


public class AirlineRepositoryImpl implements AirlineRepository {

    private static final Logger LOGGER = LogManager.getLogger(TransportPlane.class.getName());

    private ArrayList<Plane> planeArrayList = new ArrayList<>();

    public AirlineRepositoryImpl() {
        initializeRepository();
    }

    public void addPlane(Plane plane) {
        if (Optional.ofNullable(plane).isPresent()) {
            planeArrayList.add(plane);
            LOGGER.debug("Add to repository: " + plane);
        } else {
            LOGGER.debug("Didn't add this information to repository");
        }
    }

    public void removePlane(Plane plane) {
        if (Optional.ofNullable(plane).isPresent() && searchPlane(plane)) {
            planeArrayList.remove(plane);
            LOGGER.debug("Remove from repository: " + plane);
        } else {
            LOGGER.debug("Didn't remove from repository: " + plane);
        }
    }

    public void updatePlane(Plane oldPlane, Plane newPlane) {
        if (searchPlane(oldPlane) && Optional.ofNullable(oldPlane).isPresent()
                && Optional.ofNullable(newPlane).isPresent()) {
            LOGGER.debug("Update plane with id " + oldPlane.getId() +
                    " to " + newPlane);
            planeArrayList.set(planeArrayList.indexOf(oldPlane), newPlane);
        } else {
            LOGGER.debug("Didn't update plane");
        }
    }

    public boolean searchPlane(Plane plane) {
        if (Optional.ofNullable(plane).isPresent()) {
            if (planeArrayList.contains(plane)) {
                LOGGER.debug("Repository contains: " + plane);
                return true;
            } else {
                LOGGER.debug("Repository doesn't contain plane" + plane);
                return false;
            }
        } else {
            LOGGER.debug("Repository doesn't contain null planes");
            return false;
        }
    }

    public void initializeRepository() {
        ReaderOfPlanesFromTxtFile txtFile = new ReaderOfPlanesFromTxtFile();
        PlaneFactory planeFactory = new PlaneFactory();
        for (int i = 0; i < txtFile.getArrayListOfPlanesParameters().size(); i++) {
            //возможно потребуется преобразование в Optional
            Plane tmpPlane = planeFactory.getPlane(txtFile.getArrayListOfPlanesParameters().get(i));
            addPlane(tmpPlane);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (Plane s : planeArrayList) {
            str = str.concat(s.toString()).concat("\n");
        }
        return "AirlineRepositoryImpl{" +
                " planeArrayList:" + "\n" + str +
                '}';
    }

    public ArrayList<Plane> getAllPlanes() {
        return planeArrayList;
    }

    public Plane getPlaneById(int id) {
        for (Plane plane : planeArrayList) {
            if (plane.getId() == id) {
                LOGGER.debug("Find plane by id is successful");
                return plane;
            }
        }
        LOGGER.debug("Find plane by id isn't successful");
        return null;
    }

    //List query(PlaneSpecification specification);
}
