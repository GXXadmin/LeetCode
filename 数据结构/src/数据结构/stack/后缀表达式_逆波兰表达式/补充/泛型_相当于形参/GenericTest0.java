package 数据结构.stack.后缀表达式_逆波兰表达式.补充.泛型_相当于形参;

public class GenericTest0 {
    public static void main(String[] args) {

        Box<String> name = new Box<String>("corn");
        System.out.println("name:" + name.getData());
    }
}


class Box<T> {//T就是泛型,相当于int String char

    private T data;

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}

