package notes.mvc.common;

/**
 * Description：online conf
 *
 * man
 * -Xmx6g -Xms6g -XX:+UseG1GC -XX:MetaspaceSize=512m -XX:G1MaxNewSizePercent=65
 * -XX:G1HeapRegionSize=32m -XX:MaxGCPauseMillis=500 -XX:G1HeapWastePercent=5
 * -XX:InitiatingHeapOccupancyPercent=10 -XX:ParallelGCThreads=1 -XX:ConcGCThreads=1
 * -XX:G1MixedGCLiveThresholdPercent=60 -Dfile.encoding=UTF-8 -XX:+UseStringDeduplication
 *
 * soa
 * -Xmx6144M -Xms6144M -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8 -Xmn4g
 * -XX:SurvivorRatio=6 -XX:MaxTenuringThreshold=5 -XX:GCTimeRatio=19 -Xnoclassgc
 * -XX:+DisableExplicitGC -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection
 * -XX:CMSFullGCsBeforeCompaction=0 -XX:-CMSParallelRemarkEnabled
 *
 * pc-langfang
 * -Xmx6g -Xms6g -Xmn5g -XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=1024m -XX:ParallelGCThreads=4
 * -XX:ConcGCThreads=2 -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8
 * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+UseCMSInitiatingOccupancyOnly
 * -XX:CMSInitiatingOccupancyFraction=60
 *
 * pc-huitian
 * -Xmx6144M -Xms6144M -XX:PermSize=512M -XX:MaxPermSize=1024M -XX:+HeapDumpOnOutOfMemoryError
 * -Dfile.encoding=UTF-8 -Xmn4g -XX:SurvivorRatio=6 -XX:MaxTenuringThreshold=5
 * -XX:GCTimeRatio=19 -Xnoclassgc -XX:+DisableExplicitGC -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
 * -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=0 -XX:-CMSParallelRemarkEnabled
 *
 * https://www.oracle.com/technical-resources/articles/java/g1gc.html
 *
 * @author zzy520git
 * @date 2019/12/30 18:08
 * @ see
 * @since
 */
public class TestMain {
    /**
     * vmoptions:
     * -server -Xms128m -Xmx512m -XX:ReservedCodeCacheSize=240m -XX:+UseConcMarkSweepGC
     * -XX:SoftRefLRUPolicyMSPerMB=50 -ea -Dsun.io.useCanonCaches=false -Djava.net.preferIPv4Stack=true
     * -XX:+HeapDumpOnOutOfMemoryError -XX:-OmitStackTraceInFastThrow
     *
     * default:main
     * -XX:CICompilerCount=3 -XX:InitialHeapSize=130023424 -XX:MaxHeapSize=2048917504
     * -XX:MaxNewSize=682622976 -XX:MinHeapDeltaBytes=524288 -XX:NewSize=42991616
     * -XX:OldSize=87031808 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops
     * -XX:+UseFastUnorderedTimeStamps -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int core = 32;
        System.out.println(core>>>1);
//        int count = 0;
//        while (count++ < 10) {
//            TimeUnit.SECONDS.sleep(30);
//            System.out.println(count);
//        }
    }
}
