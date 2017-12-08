
package wepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wepa.domain.Uutinen;

public interface UutisRepository extends JpaRepository<Uutinen, Long> {

    public Uutinen findByOtsikko(String otsikko);
    
}
