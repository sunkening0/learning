package skn.Learning.designpatterndemo.template;

public class SendSms extends skn.Learning.designpatterndemo.template.SendCustomer {
    @Override
    public void to() {
        System.out.println("to sss");
    }

    @Override
    public void from() {
        System.out.println("from kkk");
    }

    @Override
    public void content() {
        System.out.println("nnn");
    }

    @Override
    public void send() {
        System.out.println("send sms");
    }

    public static void main(String[] args) {
        skn.Learning.designpatterndemo.template.SendCustomer sendCustomer = new SendSms();
        sendCustomer.sendMessage();
    }
}
