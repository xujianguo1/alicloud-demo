package  com.xu.mircoservice.orderdemo.server.service.impl;

import com.xu.mircoservice.orderdemo.client.model.OrderItemVo;
import com.xu.mircoservice.orderdemo.client.model.SubOrderItemVo;
import com.xu.mircoservice.orderdemo.client.service.OrderService;
import com.xu.mircoservice.productclient.model.Product;
import com.xu.mircoservice.productclient.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Reference
    private ProductService productService;
    @Override
    public List<OrderItemVo> getUserOrders(Long userId, Long productId) {
        log.info("OrderServiceImpl 执行方法getUserOrders， 入参：userId={} ,productId={}",userId,productId);
        List<OrderItemVo> orderItemVos = new ArrayList<>();
        orderItemVos.add(createOrder(userId,productId));
        getProductInfo(orderItemVos);
        return orderItemVos;
    }

    @Override
    public List<OrderItemVo> getRecentOrder(Long productId) {
        log.info("OrderServiceImpl 执行方法 getRecentOrder， 入参： productId={}", productId);
        List<OrderItemVo> orderItemVos = new ArrayList<>();
        for(int i =0;i<3;i++){
            orderItemVos.add(createOrder(null,productId));
        }
        getProductInfo(orderItemVos);
        return orderItemVos;
    }

    private void getProductInfo(List<OrderItemVo> orderItemVos){
        if(orderItemVos ==null|| orderItemVos.size()==0){
            return;
        }
        for(OrderItemVo order:orderItemVos){
            order.getSubOrderItemVoList().stream().forEach(subOrder ->{
                Product p = productService.getProductById(subOrder.getProductId());
                subOrder.setCatName(p.getCatName());
                subOrder.setProductName(p.getProductName());
                return;
            });
        }
        return ;
    }

    private OrderItemVo createOrder(Long userId,Long productId){
        OrderItemVo orderItemVo = new OrderItemVo();
        orderItemVo.setOrderId(productId+ new Random().nextInt(10000));
        orderItemVo.setOrderTime(new Date());
        orderItemVo.setProductNum(3);
        orderItemVo.setTotalAmount(new BigDecimal(383.6));
        orderItemVo.setUserId(userId==null ? new Random().nextLong():userId);
        List<SubOrderItemVo> subList = new ArrayList<>();
        int num = userId ==null ?new Random().nextInt(5):1;
        for(int i = 0;i<num;i++){
            SubOrderItemVo subItem = new SubOrderItemVo();
            if(i!=0){
                subItem.setProductId(new Random().nextLong());
            }else{
                subItem.setProductId(productId);
            }
            subItem.setSubOrderId(new Random().nextLong());
            subItem.setUnitPrice(new BigDecimal(1.1));
            subList.add(subItem);
        }
        orderItemVo.setSubOrderItemVoList(subList);
        return orderItemVo;
    }
}
