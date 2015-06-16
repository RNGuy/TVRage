package tvRage;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDate;

/**
 * <p>Conversion of XML String to LocalDate object. Logic included in unmarshal is to
 * deal with the inconsistencies of the TVRage API returning dates in different formats.</p>
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String object) throws Exception {
        if (!object.contains("/"))
            return new LocalDate(object);
        
        String m = null;
        String[] date = object.split("/");
        switch(date[0]) {
        case "Jan":
            m = "01";
            break;
        case "Feb":
            m = "02";
            break;
        case "Mar":
            m = "03";
            break;
        case "Apr":
            m = "04";
            break;
        case "May":
            m = "05";
            break;
        case "Jun":
            m = "06";
            break;
        case "Jul":
            m = "07";
            break;
        case "Aug":
            m = "08";
            break;
        case "Sep":
            m = "09";
            break;
        case "Oct":
            m = "10";
            break;
        case "Nov":
            m = "11";
            break;
        case "Dec":
            m = "12";
        }
        return new LocalDate(String.format("%s-%s-%s",date[2],m,date[1]));
    }

    @Override
    public String marshal(LocalDate object) throws Exception {
        return object.toString();
    }
}
