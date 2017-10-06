package task1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "train")
public class Train {

    private int id;
    private String from;
    private String to;
    private String date;
    private String departure;

    public Train(int id, String from, String to, String date, String departure) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    public Train() {
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                ", departure='" + departure + '\'' +
                '}' + "\n";
    }
}
