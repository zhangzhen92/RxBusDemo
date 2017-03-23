package com.example.zz.rxworkdemo;


import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2017/3/23 16:36
 */


public class RxBus {
    private static RxBus mInstance;
    private final Subject bus;

    public RxBus()
    {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBus getInstance()
    {

        RxBus rxBus = mInstance;
        if (mInstance == null)
        {
            synchronized (RxBus.class)
            {
                rxBus = mInstance;
                if (mInstance == null)
                {
                    rxBus = new RxBus();
                    mInstance = rxBus;
                }
            }
        }
        return rxBus;
    }

    /**
     * 发送数据
      * @param object
     */
    public void post(Object object){
        bus.onNext(object);
    }

    public <T> Observable<T> tObservable(Class<T> eventType){
        return bus.ofType(eventType);
    }
}
