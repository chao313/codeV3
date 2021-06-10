package demo.spring.boot.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
class HostInfo {
    private String ip;
    private int port;

    public HostInfo() {
    }

    public HostInfo(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}

@Component
@Slf4j
public class AtomicityExample {

    private HostInfo hostInfo = new HostInfo();

    /**
     * 更新ip和port
     * <p>
     * 这里加入了Thread.sleep去放大更新的间隔
     *
     * @param ip
     * @param port
     */
    public void updateHostInfo(String ip, int port) throws InterruptedException {
        this.hostInfo.setIp(ip);
        Thread.sleep(1000);
        this.hostInfo.setPort(port);
        HostInfo newHostInfo = new HostInfo(ip,port);
        this.hostInfo = newHostInfo;//原子操作
    }

    /**
     * 获取ip和port
     *
     * @return
     */
    public HostInfo getHostInfo() {
        return this.hostInfo;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicityExample atomicityExample = new AtomicityExample();
        /**
         * 更新操作
         */
        Runnable updateRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    atomicityExample.updateHostInfo("192.168.0.1", 8080);
                    log.info("写成功");
                    System.out.println("写成功");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        /**
         * 读取操作
         */
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                HostInfo hostInfo = atomicityExample.getHostInfo();
                log.info("读成功:{}", hostInfo);
                System.out.println("读成功" + hostInfo.toString());
            }
        };

        new Thread(updateRunnable).start();
        new Thread(readRunnable).start();


    }

}








