package com.liust.jd.msb.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZkUtils {
    static ZooKeeper zk;

    static String zkAddress = "";
    static int timeOut = 3000;

    public  static ZooKeeper getZk(){
        if(zk == null){
            try {
                zk = new ZooKeeper(zkAddress, timeOut, new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {

                        switch (watchedEvent.getState()) {
                            case Unknown:
                                break;
                            case Disconnected:
                                break;
                            case NoSyncConnected:
                                break;
                            case SyncConnected:
                                break;
                            case AuthFailed:
                                break;
                            case ConnectedReadOnly:
                                break;
                            case SaslAuthenticated:
                                break;
                            case Expired:
                                break;
                        }


                        switch (watchedEvent.getType()) {
                            case None:
                                System.out.println(" event none");
                                break;
                            case NodeCreated:
                                System.out.println(" event NodeCreated");
                                break;
                            case NodeDeleted:
                                System.out.println(" event NodeDeleted");
                                break;
                            case NodeDataChanged:
                                System.out.println(" event NodeDataChanged");
                                break;
                            case NodeChildrenChanged:
                                System.out.println(" event NodeChildrenChanged");
                                break;
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return zk;
    }
}
