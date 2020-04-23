package notes.mvc.common.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2020/4/23 17:45
 * @ see
 * @since
 */
public class MyTaskThreadPool extends ThreadPoolExecutor {
    public MyTaskThreadPool() {
        super(1, 1,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    public MyTaskThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(command);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
    }

    @Override
    protected void terminated() {
        super.terminated();
    }
}
