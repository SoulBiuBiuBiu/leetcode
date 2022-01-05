import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Barry
 * @since 2021/12/22 16:51
 */

public class ThreadTest {
    @Test
    public void test() {
        //[2]Reference Handler 清除Reference的线程
        //[3]Finalizer 调用对象finalize方法的线程
        //[4]Signal Dispatcher 分发处理发送给JVM信号的线程
        //[5]Attach Listener
        //[11]Common-Cleaner
        //[12]Monitor Ctrl-Break

        //获取线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo info :
                threadInfos) {
            System.out.println("[" + info.getThreadId() + "]" + info.getThreadName());
        }
    }
}
