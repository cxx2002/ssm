import com.cxx.pojo.User;
import com.cxx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *
 * @author 陈喜喜
 * @date 2022-08-02 22:06
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  //启动spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml",
        "classpath:applicationContext_service.xml"})
public class MyTest {
    @Autowired
    UserService userService;

    @Test
    public void test() {
        List<User> list = userService.selectUserPage(null, null, 1);
        list.forEach(user -> {System.out.println(user);});
    }
}
