package tvrage.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import tvrage.TVRageAPI;

import tvrage.model.Episode;
import tvrage.model.Show;

/**
 * <p>This is a quick and dirty class to demonstrate the 3 API calls.</p>
 * 
 * @author Aaron Hannah
 */
public class apiDemo {
    public apiDemo() {
        beginDemo();
    }
    
    private void beginDemo() {
        TVRageAPI api = new TVRageAPI();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        
        do {
            System.out.print("Search for show (\"exit\" to quit): ");
            try {
                input = reader.readLine();
                if (input.equalsIgnoreCase("exit"))
                    break;
                
                int count = 1;
                for(Show s : api.searchForShow(input)) {
                    System.out.println(s.getId() + " : " + s.getShowName());
                    if (count++ == 3) 
                        break;
                }
                
                System.out.print("\nEnter Show ID (\"exit\" to quit): ");
                input = reader.readLine();
                if (input.equalsIgnoreCase("exit"))
                    break;
                
                Show show = api.getShow(Integer.parseInt(input));
                System.out.println(show.getShowName() + " (" + show.getStartDate().getYear() + ") : " + show.getStatus());
                System.out.println(show.getClassification() + " : " + show.getNetwork() + " : " + show.getRuntime() + " mins");
                for(String s : show.getGenres())
                    System.out.print(s + "  ");
                System.out.println();
                
                for(Episode e : api.getEpisodesForShow(show)) {
                    System.out.println(e.getEpisodeIdentifier() + " : " + e.getAirDate() + " : " + e.getTitle());
                }
                System.out.print("\n\n\n");
            } catch (Exception e) {
                { }
            }
        }while(!input.equalsIgnoreCase("exit"));
    }
    
    public static void main(String[] args) {
        new apiDemo();
    }
}
