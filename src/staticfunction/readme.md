# 静态方法执行顺序(面试题)

一般情况下 执行顺序 静态代码块->构造代码块->构造方法

在staticfun这个类里面执行顺序如下:

1.staticfun静态代码块(因为静态是随着类执行而执行的)<br>
--由于没有new staticfun 不执行staticfun 的构造代码块 和 无参构造方法--
2.staticfun主函数mian<br>
3.Coder静态代码块(由于主函数里面new了一个 c对象)<br>
4.Coder构造代码块(由于主函数里面new了一个 c对象)<br>
5.Coder无参构造方法(由于主函数里面new了一个 c对象)<br><br>
--这里要<b>注意一下</b>Coder 的静态代码块只执行一次 在第一次new的时候执行了--<br><br>
6.Coder构造代码块(由于主函数里面又new了一个 c1对象)<br>
7.Coder无参构造方法
