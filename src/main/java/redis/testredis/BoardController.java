package redis.testredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardService service;

    @GetMapping()
    public List<Board> boards(String size) throws InterruptedException {
        List<Board> boards = service.getBoards(size);
        return boards;
    }

    @GetMapping("count")
    public int count() {
        return BoardService.getDbCount();
    }

    @GetMapping("/refresh")
    public String cacheRefresh( String id)  {
        String boards = service.resetCache(id);
        return boards;
    }

    @GetMapping("/resetAll")
    @CacheEvict(value = "getBoards", allEntries = true)
    public String cacheRefreshAll(){
        return "OK";
    }
}
