package tvRage;

import java.io.Serializable;

import java.net.URL;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.LocalDate;

/**
 * <p>Basic POJO for a show.</p>
 * 
 * <p>XmlElement annotations with multiple names is to deal with naming discrepancies in the TVRage API
 * between searching for shows and getting show details.</p>
 * 
 * <p>The last update date is tracked for show information and the episode list to help manaage data
 * accuracy. TVRage information tends to be only a couple of weeks to a month ahead of airdates
 * (anecdotal observation).</p>
 */
@XmlRootElement(name="Showinfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Show implements Serializable, Comparable<Show> {
    private static final long serialVersionUID = 2015061100;
    
    @XmlElement(name="showid")
    protected int id;

    @XmlElements({
    @XmlElement(name="showname"),
    @XmlElement(name="name")})
    protected String showName;
    
    @XmlElements({
    @XmlElement(name="showlink"),
    @XmlElement(name="link")})
    protected URL url;
    
    protected int seasons;
    
    @XmlElements({
    @XmlElement(name="origin_country"),
    @XmlElement(name="country")})
    protected String originCountry;
    
    protected String status;
    
    @XmlElements({
    @XmlElement(name="startdate"),
    @XmlElement(name="started")})
    protected LocalDate startDate;
    
    @XmlElement(name="ended")
    protected LocalDate endDate;
    
    @XmlElement
    protected String classification;
    
    @XmlElementWrapper(name="genres")
    @XmlElement(name="genre")
    protected List<String> genres;
    
    @XmlElement
    protected int runtime;
    
    @XmlElement
    protected String network;
    
    protected List<Episode> episodeList;
    protected LocalDate lastUpdated = new LocalDate("1900-01-01");
    protected LocalDate episodeLastUpdate = new LocalDate("1900-01-01");

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setShowName(String showName) {
        this.showName = showName;
        update();
    }

    public String getShowName() {
        return showName;
    }

    public void setUrl(URL url) {
        this.url = url;
        update();
    }

    public URL getUrl() {
        return url;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
        update();
    }

    public int getSeasons() {
        return seasons;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
        update();
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setStatus(String status) {
        this.status = status;
        update();
    }

    public String getStatus() {
        return status;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        update();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        update();
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
        episodeLastUpdate = new LocalDate();
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
        update();
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setClassification(String classification) {
        this.classification = classification;
        update();
    }

    public String getClassification() {
        return classification;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
        update();
    }

    public int getRuntime() {
        return runtime;
    }

    public void setNetwork(String network) {
        this.network = network;
        update();
    }

    public String getNetwork() {
        return network;
    }
    
    public LocalDate getLastUpdated() {
        return lastUpdated;
    }
    
    public LocalDate getEpisodeLastUpdate() {
        return episodeLastUpdate;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Show)) {
            return false;
        }
        final Show other = (Show) object;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + id;
        return result;
    }

    @Override
    public int compareTo(Show show) {
        return showName.replaceAll("^(?i)The\\s", "").compareTo(show.showName.replaceAll("^(?i)The\\s", ""));
    }
    
    private void update() {
        lastUpdated = new LocalDate();
    }
}
