@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(type=LocalDate.class, value=LocalDateAdapter.class)
})

package tvRage;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import org.joda.time.LocalDate;
