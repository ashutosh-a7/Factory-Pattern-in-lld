import java.io.*;
import java.util.*;
import java.util.Scanner;

class message{
    String text, senderName, receiverName;
}

interface messageBuilder{
   message buildMessage();
   public void info();
   
}

class SMSMessageBuilder implements messageBuilder{
    public message buildMessage(){
       return new message();
    }
    public void info(){
        System.out.println("This is SMS Message Builder\n");
    }
}
class EMAILMessageBuilder implements messageBuilder{
    public message buildMessage(){
       return new message();
    }
    public void info(){
        System.out.println("This is Email Message Builder\n");
    }
}
class NotificationMessageBuilder implements messageBuilder{
    public message buildMessage(){
       return new message();
    }
    public void info(){
        System.out.println("This is Notifications Message Builder\n");
    }
}


class myMessageBuilder{

    messageFactory mf;
    public myMessageBuilder(messageFactory mF){
        mf = mF;
    }
    public messageBuilder build(String myMessage){
        return mf.build(myMessage);
    }  
}

class messageFactory{
     messageBuilder mb;
     static Map<String,messageBuilder> messages = new HashMap<String,messageBuilder>();
     
     final void populateMap(messageFactory mF)
     {
         mb = new SMSMessageBuilder();
         mF.messages.put("SMS",mb);
         mb = new NotificationMessageBuilder();
         mF.messages.put("Notifications",mb);
         mb = new EMAILMessageBuilder();
         mF.messages.put("Email",mb);
    }

    public messageBuilder build(String myMessage){
          return messages.get(myMessage);
    }
}


public class factoryPattern {
    public static void main(String[] args)
    {
          System.out.println("\nThis is Factory Pattern \n");

          messageFactory factory1 = new messageFactory();
          factory1.populateMap(factory1);
          myMessageBuilder my = new myMessageBuilder(factory1);
          
          messageBuilder mymsg = my.build("SMS");
          mymsg.info();
          
    }
}
