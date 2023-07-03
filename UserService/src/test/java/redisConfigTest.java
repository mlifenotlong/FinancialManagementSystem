import com.cj.userModule.UserApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


    @Slf4j
    @RunWith(SpringRunner.class)
    @SpringBootTest(classes = UserApplication.class)
    public class redisConfigTest {

        @Autowired
        private RedisTemplate redisTemplate;

        @Test
        public void test1(){
            redisTemplate.opsForValue().set("aaa","111");
            log.info("成功---"+redisTemplate.opsForValue().get("aaa"));
        }
    }

