package tvRage;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>Helper class to assist in de-serializing XML format.</p>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SeasonHelper {
    @XmlElement(name="episode")
    private List<Episode> list;
    
    @XmlAttribute(name="no")
    private int seasonNumber;

    public List<Episode> getList() {
        return list;
    }
    
    public int getSeasonNumber() {
        return seasonNumber;
    }
}
