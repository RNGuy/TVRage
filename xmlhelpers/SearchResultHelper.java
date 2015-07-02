package tvrage.xmlhelpers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import tvrage.model.Show;

/**
 * <p>Helper class to assist in de-serializing XML format.</p>
 */
@XmlRootElement(name="Results")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResultHelper {
    @XmlElement(name="show")
    private List<Show> results;
    
    public List<Show> getResults() {
        return results;
    }
}
