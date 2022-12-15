package challenges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LoadBalancer {

    public Map<String, Integer> ipMap = new ConcurrentHashMap<>();

    @Test
    public void test() {
        new IpHash().getServer("127.0.0.1");
    }

    public class IpPool {

        public Map<String, Integer> getIpMap()
        {
            ipMap.put("192.168.1.1", 10);
            ipMap.put("192.168.1.2", 10);
            ipMap.put("192.168.1.3", 10);
            ipMap.put("192.168.1.4", 10);
            ipMap.put("192.168.1.5", 10);
            ipMap.put("192.168.1.6", 10);
            ipMap.put("192.168.1.7", 10);
            ipMap.put("192.168.1.8", 10);
            ipMap.put("192.168.1.9", 10);
            ipMap.put("192.168.1.10", 10);

            return ipMap;
        }
    }


    public interface LoadBalance {
        String getServer(String clientIp);
    }


    public class IpHash implements LoadBalance {

        IpPool ipPool = new IpPool();

        @Override
        public String getServer(String clientIp) {
            if (clientIp == null) {
                clientIp = "127.0.0.1";
            }
            Set<String> servers = ipPool.getIpMap().keySet();
            List<String> serverList = new ArrayList<>();
            serverList.addAll(servers);
            String remoteId = clientIp;
            Integer index = remoteId.hashCode() % serverList.size();
            String target = serverList.get(index);
            return target;
        }
    }
}
