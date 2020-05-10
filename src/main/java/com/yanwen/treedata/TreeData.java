package com.yanwen.treedata;

import com.sun.security.auth.NTUserPrincipal;
import com.sun.source.tree.BinaryTree;
import org.w3c.dom.Node;

import java.util.Arrays;

/**
 *
 * @ClassName: TreeData
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/9 9:26 上午
 **/
public class TreeData {
    public static void main(String[] args) {
        IBinaryTree<Person> iBinaryTree=new BinaryTreeImpl<Person>();
        iBinaryTree.add(new Person("1-80",80));
        iBinaryTree.add(new Person("2-50",50));
        iBinaryTree.add(new Person("3--60",60));
        iBinaryTree.add(new Person("4-30",30));
        iBinaryTree.add(new Person("5--90",90));
        iBinaryTree.add(new Person("6--10",10));
        iBinaryTree.add(new Person("7--55",55));
        iBinaryTree.add(new Person("8--70",70));
        iBinaryTree.add(new Person("9--85",85));
        iBinaryTree.add(new Person("10--95",95));


        /**
         *         80
         *    50       90
         *  30   60   85  95
         * 10   55 70
         */
        //iBinaryTree.delete(person4); //删除30
       //iBinaryTree.delete(person6); ---删除 10
        ///iBinaryTree.delete(person8);--删除60
        iBinaryTree.delete(new Person("2-50",80));
       System.out.println( Arrays.toString(iBinaryTree.toArray()));

    }
}

 interface IBinaryTree<T> extends  Comparable<T>{
    public void add(Comparable<T> data);
     public int getSize();
     public boolean isEmpty();
     public Object[] toArray();
     public void delete(Comparable<T>  data);

}
class BinaryTreeImpl<T> implements IBinaryTree<T>{

    @Override
    public int compareTo(T o) {
        return 0;
    }

    private class Node<T>{
        private Node left;
        private Node right;
        private Node parent;
        private Comparable<T> data;

       public Node(Comparable<T> data){
           this.data=data;
       }

        /**
         * 添加数据
         * @param newNode
         */
       public void addNode(Node newNode){
           if(newNode.data.compareTo((T) this.data)<=0){ //比当前节点小
               if(this.left==null){
                   this.left=newNode;
                   newNode.parent=this;
               }else{
                   this.left.addNode(newNode);
               }
           }else{
               if(this.right==null){
                   this.right=newNode;
                   newNode.parent=this;
               }else{
                   this.right.addNode(newNode);
               }

           }
       }

       //中序便
       public void toArrayNode(){

           if(this.left!=null){
               this.left.toArrayNode();
           }
           returnData[BinaryTreeImpl.this.foot++]=this.data;
           if(this.right!=null){
                this.right.toArrayNode();
           }
       }

        public Node getRemoveNode(Comparable<T> data){
            if(data.compareTo((T) this.data)==0){
                return this;
            }else if(data.compareTo((T) this.data)<0){
                if(this.left!=null){
                  return  this.left.getRemoveNode(data);
                }else{
                    return null;
                }
            }else if(this.right!=null){
                return this.right.getRemoveNode(data);
            }
                return null;
        }
        public boolean contain(Comparable<T> data){
            if(data.compareTo((T) this.data)==0){
                return true;
            }else if(data.compareTo((T) this.data)<0){
                if(this.left!=null){
                 return   this.left.contain(data);
                }else{
                    return false;
                }
            }else if(this.right!=null){
                return this.right.contain(data);
            }
                return false;
        }
    }
    //-----二叉树实现
    Node root;
    public int count;
    private Object[] returnData;
    private int foot;
    @Override
    public Object[] toArray(){
        if(isEmpty()){
            return null;
        }
        this.foot=0;
        this.returnData=new Object[count];
        this.root.toArrayNode();
        return returnData;
    }

    @Override
    public void delete(Comparable<T> data) {
        if(!this.contains(data)){
            return;
        }
        this.count--;
        if(root.data.compareTo(data)==0){
            Node moveNode = this.root.right;
            //删除节点的右节点的最小的左节点
            while (moveNode.left != null) {
                moveNode = moveNode.left;
            }
            moveNode.left=this.root.left;
            moveNode.parent.left=null;
            moveNode.right=this.root.right;
            this.root=moveNode;
        }else{
        Node removeNode=this.root.getRemoveNode(data);
        if(removeNode!=null) {
            System.out.println("删除" + removeNode.data + removeNode.right + ":" + removeNode.left);
            if (removeNode.left == null && removeNode.right == null) { //左右为空
                //判断移除是父节点的左节点
                if (removeNode.parent.data.compareTo(removeNode.data) > 0) {
                    removeNode.parent.left = null;
                } else {
                    removeNode.parent.right = null;
                }
            } else if (removeNode.left != null && removeNode.right == null) {//左不为空
                removeNode.parent.left = removeNode.left;
                removeNode.left.parent = removeNode.parent;
            } else if (removeNode.left == null && removeNode.right != null) {//右不为空
                removeNode.right.parent = removeNode.parent;
                removeNode.parent.left = removeNode.right;
            } else if (removeNode.right != null && removeNode.left != null) {
                Node moveNode = removeNode.right;
                //删除节点的右节点的最小的左节点
                while (moveNode.left != null) {
                    moveNode = moveNode.left;
                }
                if (removeNode.parent != null) {
                    removeNode.parent.left = moveNode;
                }

                moveNode.parent.left = null; //断开原本链接
                moveNode.parent = removeNode.parent;
                moveNode.right = removeNode.right;
                moveNode.left = removeNode.left; //改变原始指
            }
          }
        }
    }

    public boolean contains(Comparable<T> data){
        if(this.isEmpty()){
            return false;
        }
        return this.root.contain(data);
    }
    @Override
    public boolean isEmpty(){
        return this.count==0;
    }
    @Override
    public int getSize(){
        return count;
    }
    @Override
    public void add(Comparable<T> data) {
        if(data==null){
            throw new NullPointerException("保存数据 不允许为空");
        }
        Node newNode=new Node(data);
        if(this.root==null){
            this.root=newNode;
        }else{
            this.root.addNode(newNode);
        }
        count++;
    }
}

class Person implements  Comparable<Person>{
   private String name;
   private int age;
   public Person(String name,int age){
       this.name=name;
       this.age=age;
   }
    @Override
    public int compareTo(Person person) {
        return this.age-person.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "}\n";
    }
}