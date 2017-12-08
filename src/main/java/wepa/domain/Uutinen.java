
package wepa.domain;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Uutinen extends AbstractPersistable<Long> {
    
    private String otsikko;
    private String ingressi;
    private byte[] kuva;
    private String teksti;
    
    @CreationTimestamp
    private LocalDate aika;
    
    @ManyToMany()
    private List<Kirjoittaja> kirjoittajat;
    
}
