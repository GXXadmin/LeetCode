package 数据结构.五子棋_稀疏数组.补充;

public class replaceAll方法 {
    public static void main(String [] args){
        String str = "java,java,你好!";
        String newStr = str.replaceAll("java","星星");
        //replaceAll会将所有的java替换为星星
        System.out.println("newSte=" + newStr);
    }
}