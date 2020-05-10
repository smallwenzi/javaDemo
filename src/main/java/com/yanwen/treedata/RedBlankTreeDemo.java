package com.yanwen.treedata;

/**
 *
 * @ClassName: RedBlankTreeDemo
 * @Description:
 * @Author: YYY
 * @Date: 2020/5/9 6:25 下午
 **/
public class RedBlankTreeDemo {
}

enum Color{
    RED,BLACK;
}
class RedBlackBinartTree<T>{
    private class Node{
        private T data;
        private  Node parent;
        private Node left;
        private Node right;
        private Color color;
        public Node(T data){
            this.data=data;
        }

    }
    public int  count;
    public void add(T data){

    }
   // public boolean
}