package redis.testredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository repository;

    @Cacheable(key = "#size", value = "getBoards")
    public List<Board> getBoards(String size) throws InterruptedException {
        return repository.createBySize(size);
    }

    @CacheEvict(value = "getBoards")
    public String resetCache(String id)  {
        return "OK";
    }

    public static int getDbCount() {
        return BoardRepository.getDbCount();
    }
}