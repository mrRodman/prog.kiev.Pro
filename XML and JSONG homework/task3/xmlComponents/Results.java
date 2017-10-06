package task3.xmlComponents;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "results")
public class Results {
    private Rate[] rate;

    public Results() {
    }

    @XmlElement
    public Rate[] getRate() {
        return rate;
    }

    public void setRate(Rate[] rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Results{");
        sb.append("rate=").append(Arrays.toString(rate));
        sb.append('}');
        return sb.toString();
    }
}
