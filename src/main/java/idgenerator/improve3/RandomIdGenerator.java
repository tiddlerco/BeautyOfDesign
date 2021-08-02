package idgenerator.improve3;

import idgenerator.improve3.exception.IdGenerationFailureException;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * 所谓受检异常还是非受检异常是由我们自己决定的，需不需要在方法上声明抛出，调用者必须进行处理
 * <p>
 * 1.如果 func1() 抛出的异常是可以恢复，
 * 且 func2() 的调用方并不关心此异常，
 * 我们完全可以在 func2() 内将 func1() 抛出的异常吞掉；
 * <p>
 * 2.如果 func1() 抛出的异常对 func2() 的调用方来说，
 * 也是可以理解的、关心的 ，并且在业务概念上有一定的相关性，
 * 我们可以选择直接将 func1 抛出的异常 re-throw；
 * <p>
 * 3.如果 func1() 抛出的异常太底层，对 func2() 的调用方来说，
 * 缺乏背景去理解、且业务概念上无关，
 * 我们可以将它重新包装成调用方可以理解的新异常，然后 re-throw。
 * <p>
 * 总之,是否往上继续抛出，要看上层代码是否关心这个异常。
 * 关心就将它抛出，否则就直接吞掉。
 * 是否需要包装成新的异常抛出，看上层代码是否能理解这个异常、是否业务相关。
 * 如果能理解、业务相关就可以直接抛出，否则就封装成新的异常抛出
 */
@Slf4j
public class RandomIdGenerator implements IdGenerator {

    @Override
    public String generate() throws IdGenerationFailureException {
        String substrOfHostName = null;
        try {
            substrOfHostName = getLastFieldOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("...", e);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s",
                substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    private String getLastFieldOfHostName() throws UnknownHostException {
        String substrOfHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException("...");
        }
        substrOfHostName = getLastSubstrSplittedByDot(hostName);
        return substrOfHostName;
    }

    protected String getLastSubstrSplittedByDot(String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("...");
        }

        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }

    protected String generateRandomAlphameric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("...");
        }

        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }
}