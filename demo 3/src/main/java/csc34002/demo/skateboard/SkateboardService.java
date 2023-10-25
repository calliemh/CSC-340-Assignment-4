package csc34002.demo.skateboard;

import java.util.List;

import csc34002.demo.skateboard.Skateboard;
import csc34002.demo.skateboard.SkateboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Callie Hampton
 *
 */
@Service
public class SkateboardService {
    @Autowired
    private SkateboardRepo sRepo;

    public List<Skateboard> getAllSkateboards() {return sRepo.findAll();}

    public List<Skateboard> getAllSkateboards(String keyword) {
        if (keyword != null) {
            return sRepo.search(keyword);
        }
        return sRepo.findAll();
    }

    public Skateboard findByType(String type) {
        return sRepo.findOneByType(type);
    }

    /**
     *
     * @param boardId
     * @return the skateboard
     */
    public Skateboard getSkateboard(long boardId) { return sRepo.getReferenceById(boardId); }

    /**
     *
     * @param boardId
     */
    public void deleteSkateboard(long boardId) {sRepo.deleteById(boardId); }

    void saveSkateboard(Skateboard board) {sRepo.save(board); }

}
