package idgenerator;

import jdk.nashorn.internal.runtime.logging.Logger;

import java.net.InetAddress;
import java.util.Random;

/**
 * @Author 喻可
 * @Date 2021/7/1 16:43
 */
@Logger
public class IdGenerator2 {

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

        private String getLastfieldOfHostName() {
            String substrOfHostName = null;
            try {
                String hostName = InetAddress.getLocalHost().getHostName();
                String[] tokens = hostName.split("\\.");
                substrOfHostName = tokens[tokens.length - 1];
                return substrOfHostName;
            } catch (UnknownHostException e) {
                logger.warn("Failed to get the host name.", e);
            }
            return substrOfHostName;
        }

        private String generateRandomAlphameric(int length) {
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
