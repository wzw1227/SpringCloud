package wzw.test.order2_server.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wzw.test.order2_server.Service.ProductOrderServerI;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private ProductOrderServerI productOrderServerI;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")//访问失败时执行熔断
    public Object save(@RequestParam("user_id")int userId,@RequestParam("product_id")int productId ){

        Map<String,Object> data =new HashMap<>();
        data.put("code",1);
        data.put("data",productOrderServerI.save(userId,productId));
        return data;
    }

    //注意：方法名一定要和api方法一致
    private Object saveOrderFail(int userId,int productId){

        //监控报警
        String saveOrderKye = "save-order";
        String sendValue = redisTemplate.opsForValue().get(saveOrderKye);
            //开启一个线程异步执行报警、避免阻塞
            new Thread(()->{
                if(StringUtils.isBlank(sendValue)){
                    System.out.println("紧急短信：用户下单失败，请查找原因");
                    //调用短信服务，发送一个http请求
                    //将短信内容保存到redis服务器，并且设置保存时间
                    redisTemplate.opsForValue().set(saveOrderKye,"save-order-fail",20, TimeUnit.SECONDS);
                }else {
                    System.out.println("已经发送过短信，20秒内不重复发送");
                }
            }).start();

        Map<String,Object> map =new HashMap<>();
        map.put("code","-1");
        map.put("msg","当前抢购人数太多，您被挤出了，稍等重试");
        return map;
    }
}
