package tvrage.xmlhelpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import tvrage.model.Episode;

/**
 * <p>Helper class to assist in de-serializing XML format.</p>
 */
@XmlRootElement(name="Show")
@XmlAccessorType(XmlAccessType.FIELD)
public class EpisodeListHelper {
    @XmlElement(name="showid")
    private int showID;
    
    @XmlElementWrapper(name="Episodelist")
    @XmlElement(name="Season")
    private List<SeasonHelper> seasonList;

    public List<Episode> getEpisodeList() {
        List<Episode> temp = new ArrayList<Episode>();
        
        for(SeasonHelper s : seasonList) {
            for(Episode e : s.getList()) {
                e.setShowID(showID);
                e.setSeasonNumber(s.getSeasonNumber());
                temp.add(e);
            }
        }
        
        Collections.sort(temp);
        return temp;
    }
}
