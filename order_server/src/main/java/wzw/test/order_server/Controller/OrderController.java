package wzw.test.order_server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wzw.test.order_server.Service.ProductOrderServerI;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private  ProductOrderServerI productOrderServerI;

    @RequestMapping("save")
    public Object save(@RequestParam("user_id")int userId,@RequestParam("product_id")int productId ){
        return productOrderServerI.save(userId,productId);
    }
}
