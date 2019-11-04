package com.liust.jd.msb.interv.a1b2.locks;

import sun.misc.Unsafe;

import java.util.concurrent.locks.AbstractQueuedSynchronizer.ConditionObject;
import java.util.concurrent.locks.ReentrantLock;

public class LiuLock extends ReentrantLock {

    public class LiuConditionObject extends ConditionObject {
        private volatile boolean hasSignaled = false;

        public void doAwait() throws InterruptedException{
            if(!hasSignaled){
                await();
            }else {
                hasSignaled = false;
            }
        }

        public void doSignal() {
            if(getQueueLength() == 0){
                hasSignaled = true;
            }else {
                signal();
            }
        }
    }

    @Override
    public ConditionObject newCondition(){
        return new LiuConditionObject();
    }


}
