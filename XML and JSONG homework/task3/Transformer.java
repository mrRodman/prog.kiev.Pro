package task3;

import task3.xmlComponents.Query;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Transformer {
    public static Query getFromXML(String path) {
        try {
            URL url = new URL(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Query query = (Query) unmarshaller.unmarshal(url);

            return query;
        } catch (MalformedURLException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
