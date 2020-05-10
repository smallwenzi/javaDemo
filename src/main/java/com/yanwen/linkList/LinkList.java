package com.yanwen.linkList;

interface ILink<E>{
    //数据添加
    public void add(E data);
    //数据长度
    public int getSize();
    //转换数组
    public Object[] toArray();
    //是否为空
    public boolean isEmpty();
    //根据索引获取数据
    public E get(int index);
    //修改数据
    public void set(int index,E data);

    //是否包含数据
    public boolean contain(E data);

    //删除数据
    public void remove(E data);

    public void clean();
}

/**
 *
 * @ClassName: LinkList
 * @Description: 链表
 * @Author: YYY
 * @Date: 2020/5/1 12:22 下午
 **/
public class LinkList <E> implements ILink<E>{
    private class Node{
        private E data;
        private Node next;
        private Node(E data){
            this.data=data;
        }
        public void add(Node node){
            if(this.next==null){
                this.next=node;
            }else {
                this.next.add(node);
            }
        }
        public void toArrayNode(){
            LinkList.this.returnData[LinkList.this.foot++]=this.data;
            if(this.next!=null) {
                this.next.toArrayNode();
            }
        }
        public E get(int index){
            if(LinkList.this.foot++==index){
                return this.data;
            }{
                return this.next.get(index);
            }
        }

        public void setNode(int index,E data){
            if(LinkList.this.foot++==index){
               this.data=data;
            }else{
               this.next.setNode(index,data);
            }
        }
        public boolean containNode(E data){
            if(this.data.equals(data)){
                return true;
            }else if(this.next!=null){
                return this.next.containNode(data);
            }
            return false;
        }

        public void removeNode(E data,Node preNode){
            if(this.data.equals(data)){
                  preNode.next=this.next;
            }else if(this.next!=null) {
                this.next.removeNode(data,this);
            }
        }

    }
    //-----Link 类的成员
    //根节点
    private Node root;
    //记录数据
    private int count;
    //数组下标
    private int foot;
    //返回数据保存
    private Object[] returnData;
    @Override
    public void add(E data){
        if(data!=null){
            Node newNode=new Node(data);
            if(root==null){
                root=newNode;
            }else{
                root.add(newNode);
            }
            count++;
        }
    }
    @Override
    public int getSize(){
        return this.count;
    }
    @Override
    public Object[] toArray(){
        if(isEmpty()){
            return null;
        }
        this.foot=0;
       this.returnData=new Object[this.count];
       this.root.toArrayNode();
       return returnData;
    }
    @Override
    public boolean isEmpty(){
        return this.count==0;
    }
    @Override
    public void set(int index,E data){
        if(isEmpty()||index>=this.count||index<0) {
            return ;
        }
        this.foot=0;
        this.root.setNode(index,data);
    }
    @Override
    //时间复杂度为n
    public E get(int index){
     if(isEmpty()||index>=this.count||index<0) {
         return null;
     }
     this.foot=0;
     return this.root.get(index);
    }
    @Override
    public boolean contain(E data){
        if(isEmpty()||data==null) {
            return false;
        }
        return  this.root.containNode(data);
    }
    @Override
    public void clean(){
        this.root=null;
        this.count=0;
    }

    @Override
    public void remove(E data) {
        if(this.contain(data)) {
            if (this.root.data.equals(data)) {
                this.root = this.root.next;
            } else if (this.root.next != null) {
                this.root.next.removeNode(data, this.root);
            }
            this.count--;
        }
    }

    public static void main(String[] args){
        LinkList<String> linkList=new LinkList<String>();
     System.out.println("添加数据之前："+linkList.count+":"+linkList.isEmpty());
        linkList.add("1www");
        linkList.add("2qqq");
        linkList.add("3wwwwwe33");
        System.out.println("添加数据之后："+linkList.count+":"+linkList.isEmpty());
        Object[] objArray=linkList.toArray();
        for(Object obj:objArray){
            System.out.println(obj);
        }
        System.out.println("获取索引"+linkList.get(2));
        linkList.set(2,"set");
        System.out.println("修改数据之后：");
        objArray=linkList.toArray();
        for(Object obj:objArray){
            System.out.println(obj);
        }

        System.out.println("包含"+linkList.contain("set")+":不包含"+linkList.contain("222"));

        System.out.println("删除不是根节点数据之后：");
        linkList.remove("set");
        objArray=linkList.toArray();
        for(Object obj:objArray){
            System.out.println(obj);
        }

        System.out.println("删除是根节点数据之后：");
        linkList.remove("1www");
        objArray=linkList.toArray();
        for(Object obj:objArray){
            System.out.println(obj);
        }
    }
}

