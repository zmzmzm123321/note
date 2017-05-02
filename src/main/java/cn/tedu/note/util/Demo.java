package cn.tedu.note.util;

/**
 * Created by TM on 2017-4-19.
 */
public class Demo {
    public static void main(String[] args){


        Girl g = Girl.getGirl();
        Girl g1 = Girl.getGirl();
    }


}

/**
 * 对象创建的时机不同，都能保证唯一（单例模式）
 */
//饿汉模式（立即加载）
class Girl{
    //在类被加载的时候就被创建了
    private static Girl girl = new Girl();
    private Girl(){

    }
    public static Girl getGirl(){
        return girl;
    }
}

//懒惰模式（懒汉模式）就是被动模式
class Boy{
    private static Boy boy;
    private Boy(){

    }
    //如果一辈子不调用get方法，就不会创建实例，
    // 瑕疵：方法是会有多线程的。
    public synchronized/*避免多线程同时操作,保证单例*/ static Boy getBoy(){
        if(boy==null){
            boy = new Boy();
        }
        return boy;
    }
}