package tvRage;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>Helper class to assist in de-serializing XML format.</p>
 */
@XmlRootElement(name="Results")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResult {
    @XmlElement(name="show")
    private List<Show> results;
    
    public List<Show> getResults() {
        return results;
    }
}
