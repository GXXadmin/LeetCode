package 数据结构.stack.后缀表达式_逆波兰表达式.补充.泛型_相当于形参;

import java.util.List;
import java.util.ArrayList;

public class GenericTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();//灰色
        list.add("qqyumidi");
        list.add("corn");
        //list.add(100);

        for (int i = 0; i < list.size(); i++) {
            String  name = (String) list.get(i);//灰色
            System.out.println("name:" + name);
        }
    }
}