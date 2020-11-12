package skn.Learning.designpatterndemo.template;

import java.util.Date;

/**
 * 模板方法模式
 */
public abstract class SendCustomer {
    public abstract void to();
    public abstract void from();
    public abstract void content();
    public void data(){
        System.out.println(new Date());
    }
    public abstract void send();

    public void sendMessage(){
         to();
         from();
         content();
         data();
         send();
    }
}
