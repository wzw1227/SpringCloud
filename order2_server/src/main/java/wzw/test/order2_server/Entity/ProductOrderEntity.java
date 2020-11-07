package wzw.test.order2_server.Entity;

import java.util.Date;

/*
商品订单实体类
 */
public class ProductOrderEntity {
  private int id;//订单id
  private String productname;//商品名称
  private String tradeNo;//订单号
  private int price;//价格
  private Date createTime;//创建时间
  private int userId;//用户id
  private String userName;//用户名


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
