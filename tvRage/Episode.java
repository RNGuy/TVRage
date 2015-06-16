package tvRage;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.LocalDate;

/**
 * <p>Basic POJO to encapsulate episode information.</p>
 * 
 * <p>getEpisodeIdentifier and getAlternateEpisodeIdentifier are provided to generate Strings
 * representing the episode such as S01E01 or 1x01.</p>
 */
@XmlRootElement(name="episode")
@XmlAccessorType(XmlAccessType.FIELD)
public class Episode implements Serializable, Comparable<Episode> {
    @SuppressWarnings("compatibility:-7381538038552630840")
    private static final long serialVersionUID = 1L;
    
    @XmlElement(name="epnum")
    private int episodeNumber;
    
    @XmlElement(name="seasonnum")
    private int episodeInSeasonNumber;
    
    private int seasonNumber;
    
    @XmlElement(name="prodnum")
    private String productionNumber;
    
    @XmlElement(name="airdate")
    private LocalDate airDate;
    
    @XmlElement(name="link")
    private String url;
    
    private String title;
    private int showID;
    
    public String getAlternateEpisodeIdentifier() {
        return String.format("%dx%02d", seasonNumber, episodeInSeasonNumber);
    }
    
    public void setEpisodeInSeasonNumber(int episodeInSeasonNumber) {
        this.episodeInSeasonNumber = episodeInSeasonNumber;
    }

    public int getEpisodeInSeasonNumber() {
        return episodeInSeasonNumber;
    }

    public String getEpisodeIdentifier() {
        return String.format("S%02dE%02d", seasonNumber, episodeInSeasonNumber);
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setProductionNumber(String productionNumber) {
        this.productionNumber = productionNumber;
    }

    public String getProductionNumber() {
        return productionNumber;
    }

    public void setAirDate(LocalDate airDate) {
        this.airDate = airDate;
    }

    public LocalDate getAirDate() {
        return airDate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public int getShowID() {
        return showID;
    }
    

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Episode)) {
            return false;
        }
        final Episode other = (Episode) object;
        if (episodeNumber != other.episodeNumber) {
            return false;
        }
        if (showID != other.showID) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + episodeNumber;
        result = PRIME * result + showID;
        return result;
    }

    @Override
    public int compareTo(Episode episode) {
        if (episode.showID != showID) {
            return Integer.compare(showID, episode.showID);
        }
        return Integer.compare(episodeNumber, episode.getEpisodeNumber());
    }
}
