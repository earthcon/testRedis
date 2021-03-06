package redis.testredis;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardRepository {
    // DB 조회 횟수
    private static int dbCount = 0;
    public List<Board> createBySize(String size) throws InterruptedException {
        // DB 조회를 했다고 가정하여 카운트를 올린다.
        dbCount++;
        ArrayList<Board> boards = new ArrayList<Board>();
        int count = Integer.parseInt(size);
        Thread.sleep(5000);

        for (int i = 0; i < count; i++) {
            boards.add(new Board(i + 0L, i + "번째 게시물", i + "번째 내용"));
        }

        return boards;
    }
    public static int getDbCount() {
        return dbCount;
    }
}