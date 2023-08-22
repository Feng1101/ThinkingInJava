package feng.util.redis;

import feng.atunit.Test;
import redis.clients.jedis.Jedis;

public class redis {
    @Test
    public void redisTester(){
        Jedis jedis = new Jedis("localhost", 6379, 10000);

    }
}
