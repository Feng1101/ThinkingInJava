package feng.R_Enumerted.H_常量相关;

import feng.util.javaUtil.Enums;

import java.util.Iterator;

/**
 * 职责链模式
 * 使用enum的职责链
 * 各个部分负责各自的功能，互不干扰，通过一个handle可以判断整体的结果
 * 这里在类中定义enum类，使得其实现某一特定功能，更加易用
 */

class Mail{
    enum GeneralDelivery{YES,NO1,NO2,NO3,NO4,NO5;}
    enum Scannability{UNSCANNABLE, YES1 ,YES2, YES3, YES4;}
    enum Readability{ILLEGIBLE, YES1, YES2, YES3,YES4;}
    enum Address{INCORRECT, OK1 ,OK2, OK3, OK4,OK5, OK6;}
    enum ReturnAddress{MISSING ,OK1 ,OK2, OK3, OK4, OK5;}
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id =counter ++;
    public String toString () { return  "Mail "+id;}
    public String details(){
        return toString()+
                ", General Delivery: "+generalDelivery+
                ", Scannability: "+scannability+
                ", Readability:: "+readability+
                ", Address: "+address+
                ", Return Address: "+returnAddress;
    }
    public static Mail randomMail(){
        Mail mail = new Mail();
        mail.generalDelivery=Enums.random(GeneralDelivery.class);
        mail.scannability=Enums.random(Scannability.class);
        mail.readability=Enums.random(Readability.class);
        mail.address=Enums.random(Address.class);
        mail.returnAddress=Enums.random(ReturnAddress.class);
        return mail;
    }

    public static Iterable<Mail> generator(final int count){
        return new Iterable<Mail>() {
            int n=count;
            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-->0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}


public class PostOffice {
    enum MailHandler{
        GENERAL_DELIVERY{
            boolean handle(Mail m){
                switch (m.generalDelivery){
                    case YES : System.out.println("Using general delivery for "+m);
                    return  true;
                    default : return false;
                }
            }
        },
        MACHINE_SCAN{
            boolean handle(Mail m){
                switch(m.scannability){
                    case UNSCANNABLE : return false;
                    default:
                        switch (m.address){
                            case INCORRECT :return false;
                            default:
                                System.out.println("Delivering "+m+ " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION{
            boolean handle(Mail m){
                switch (m.readability){
                    case ILLEGIBLE : return false;
                    default:
                        switch (m.address){
                            case INCORRECT :return false;
                            default:
                                System.out.println("Delivering "+m+ " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER{
            boolean handle(Mail m){
                switch (m.returnAddress){
                    case MISSING :return false;
                    default:
                        System.out.println("Returning "+m+" to sender");
                        return true;
                }
            }
        };
        abstract boolean handle(Mail m);
    }
    static void handle(Mail m){
        for(MailHandler handler: MailHandler.values()){
            if(handler.handle(m))
                return;
            System.out.println(m+" is a dead letter");
        }
    }

    public static void main(String[] args) {
        //mail类有了generator才能使用for循环
        for(Mail mail:Mail.generator(10)){
            System.out.println(mail.details());
            handle(mail);
            System.out.println("**************");
        }
    }

}
