package tvRage;

import java.net.SocketTimeoutException;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

/**
 * @author Aaron Hannah
 * @version 1.0
 * 
 * <p>This provides access to the TVRage public API for television shows. At this time,
 * it only provides 3 functions: Searching for a show, getting show information, and
 * getting a list of episodes for a show.</p>
 */
public class TVRageAPI {
    /**
     * <p>Search for shows using the provided search string.</p>
     *
     * @param   The searchstring used to get a list of matching shows.
     * @return  A List of Shows found using the search string.
     */
    public List<Show> searchForShow(String search) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("http://services.tvrage.com/feeds");
        
        Response response = target.path("search.php").queryParam("show", search).request().accept(MediaType.APPLICATION_XML).get(Response.class);
        SearchResult results = response.readEntity(SearchResult.class);
        return results.getResults();
    }
    
    /**
     * <p>Get detailed show information.</p>
     * 
     * @param   Show ID of show.
     * @return  Show object with detailed information.
     */
    public Show getShow(int showId) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("http://services.tvrage.com/feeds");
        
        Response response = target.path("showinfo.php").queryParam("sid", showId).request().accept(MediaType.APPLICATION_XML).get(Response.class);
        Show show = response.readEntity(Show.class);
        return show;
    }
    
    /**
     * <p>Get a list of episodes for a show.</p>
     *
     * @param   Show object.
     * @return  List of episodes.
     */
    public List<Episode> getEpisodesForShow(Show show) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("http://services.tvrage.com/feeds");
        
        Response response = target.path("full_show_info.php").queryParam("sid", show.getId()).request().accept(MediaType.APPLICATION_XML).get(Response.class);
        EpisodeListHelper episodeHelper = response.readEntity(EpisodeListHelper.class);
        return episodeHelper.getEpisodeList();
    }
}
