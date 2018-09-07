package staticfunction;

public class staticfun {
    //静态代码块
    static {
        System.out.println("staticfun 静态代码块");
    }
    //构造代码块
    {
        System.out.println("staticfun 构造代码块");
    }
    //无参构造代码块
    public staticfun(){
        System.out.println("staticfun 无参构造代码块");
    }

    public static void main(String[] args) {
        System.out.println("staticfun 主函数main执行...");
        Coder c=new Coder();
        Coder c1=new Coder();
    }
}

class Coder{

    //静态代码块
    static{
        System.out.println("Coder静态代码块执行");
    }

    //构造代码块
    {
        System.out.println("Coder构造代码块");
    }

    //无参构造
    public Coder(){
        System.out.println("Coder无参构造代码块");
    }
}


