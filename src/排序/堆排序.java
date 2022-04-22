package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User:郭星星
 * Date:2021/6/21
 * Time:15:11
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 3, 6, 1, 4};
        System.out.println(Arrays.toString(collate(arr)));
    }

    public static int[] collate(int[] arr) {
        arr = heap(arr);

        return arr;
    }

    public static int[] heap(int[] arr) {
        List list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.reverse(list);

        return arr;
    }
}

class newHeap {
    int num;
    newHeap left;
    newHeap right;

    public newHeap(int num, newHeap left, newHeap right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public newHeap getLeft() {
        return left;
    }

    public void setLeft(newHeap left) {
        this.left = left;
    }

    public newHeap getRight() {
        return right;
    }

    public void setRight(newHeap right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "newHeap{" +
                "num=" + num +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}


