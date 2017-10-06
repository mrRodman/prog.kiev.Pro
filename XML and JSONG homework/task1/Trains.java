package task1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "trains")
public class Trains {

    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<>();

    public Trains() {
    }

    public void add(Train train) {
        trains.add(train);
    }

    public List<Train> getTrains() {
        return trains;
    }

    @Override
    public String toString() {
        return "Trains{" +
                "trains=" + trains +
                '}';
    }
}
