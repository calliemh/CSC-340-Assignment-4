package csc34002.demo.skateboard;

import java.util.List;

import csc34002.demo.skateboard.Skateboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Callie Hampton
 *
 */
public interface SkateboardRepo extends JpaRepository<Skateboard, Long> {
    public List<Skateboard> findByType(String type);
    public Skateboard findOneByType(String type);

    @Query("SELECT s FROM Skateboard s WHERE CONCAT(s.price, s.brand, s.type) LIKE %?1%")
    public List<Skateboard> search(String keyword);
}
