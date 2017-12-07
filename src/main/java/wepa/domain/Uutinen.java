
package wepa.domain;

import java.util.Date;
import javax.persistence.Entity;
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
    private Date aika;
    
}
