package task3.xmlComponents;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "query")
public class Query {
        private int count;
        private String created;
        private String lang;

        private Results results;

    public Query() {
    }

    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
    @XmlAttribute(namespace = "http://www.yahooapis.com/v1/base.rng")
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @XmlElement
    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Query{");
        sb.append("count=").append(count);
        sb.append(", created='").append(created).append('\'');
        sb.append(", lang='").append(lang).append('\'');
        sb.append(", results=").append(results);
        sb.append('}');
        return sb.toString();
    }
}
