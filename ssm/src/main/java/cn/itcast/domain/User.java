package cn.itcast.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String username;
    private String password;
    //一对多的关系
    private List<Commodity> commodity;
    private List<Order> order;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", commodity=" + commodity +
                ", order=" + order +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Commodity> getCommodity() {
        return commodity;
    }

    public void setCommodity(List<Commodity> commodity) {
        this.commodity = commodity;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
