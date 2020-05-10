package com.yanwen;
/**
 *
 * @ClassName: AutocloseableDemo
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/5 8:42 下午
 **/
public class AutocloseableDemo {
    public static void main(String args[]){
        try(IMessage message=new MessageImpl()){
            message.send();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
interface IMessage extends AutoCloseable{
 public void send();
}

class MessageImpl implements IMessage{

    @Override
    public void send() {
        if(open()) {
            System.out.println("发送消息");
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("关闭消息");
    }

    public boolean open(){
        System.out.println("打开通道");
        return true;
    }

}
