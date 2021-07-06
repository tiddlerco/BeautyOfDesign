package idgenerator;

import jdk.nashorn.internal.runtime.logging.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author 喻可
 * @Date 2021/7/1 16:43
 */
@Logger
public class IdGenerator3 {

    public interface IdGenerator {
        String generate();
    }

    public interface LogTraceIdGenerator extends IdGenerator {
    }


    public class RandomIdGenerator implements LogTraceIdGenerator {
        private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

        @Override
        public String generate() {
            String substrOfHostName = getLastfieldOfHostName();
            long currentTimeMillis = System.currentTimeMillis();
            String randomString = generateRandomAlphameric(8);
            String id = String.format("%s-%d-%s",
                    substrOfHostName, currentTimeMillis, randomString);
            return id;
        }


        private String getLastFieldOfHostName() throws UnknownHostException {
            String substrOfHostName = null;
            String hostName = InetAddress.getLocalHost().getHostName();
            substrOfHostName = getLastSubstrSplittedByDot(hostName);
            return substrOfHostName;
        }

        @VisibleForTesting
        protected String getLastSubstrSplittedByDot(String hostName) {
            String[] tokens = hostName.split("\\.");
            String substrOfHostName = tokens[tokens.length - 1];
            return substrOfHostName;
        }

        @VisibleForTesting
        protected String generateRandomAlphameric(int length) {
            char[] randomChars = new char[length];
            int count = 0;
            Random random = new Random();
            while (count < length) {
                int maxAscii = 'z';
                int randomAscii = random.nextInt(maxAscii);
                boolean isDigit= randomAscii >= '0' && randomAscii <= '9';
                boolean isUppercase= randomAscii >= 'A' && randomAscii <= 'Z';
                boolean isLowercase= randomAscii >= 'a' && randomAscii <= 'z';
                if (isDigit|| isUppercase || isLowercase) {
                    randomChars[count] = (char) (randomAscii);
                    ++count;
                }
            }
            return new String(randomChars);
        }
    }

    //代码使用举例
    LogTraceIdGenerator logTraceIdGenerator = new RandomIdGenerator();
}
