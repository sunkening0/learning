package com.skn.Learning.designpatterndemo.proxy.jtproxy;





/**
 * @Auther: dan gao
 * @Description:
 * @Date: 22:43 2018/1/9 0009
 */
public class BuyHouseProxy implements IBuyHouse {

    private IBuyHouse buyHouse;

    public BuyHouseProxy(final IBuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    public void buyHosue() {
        System.out.println("买房前准备");
        buyHouse.buyHosue();
        System.out.println("买房后装修");

    }
}
