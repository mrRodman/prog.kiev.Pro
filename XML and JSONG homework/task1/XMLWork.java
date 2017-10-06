package task1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLWork {

    public static Trains getFromXML(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Trains trains = (Trains) unmarshaller.unmarshal(file);
            return trains;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
