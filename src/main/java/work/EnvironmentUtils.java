package work;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author 喻可
 * @Date 2022/3/15 14:26
 */
public class EnvironmentUtils {

    private static final Logger logger = LoggerFactory.getLogger(EnvironmentUtils.class);

    private static final String PROPERTIES_FILE = "application.properties";
    private static final String PARAM_ENV = "wind2.run-env";

    private static final String TEST = "test";
    private static final String DAILY = "daily";
    private static final String STAGING = "staging";
    private static final String PRODUCTION = "production";

    private static String runMode;

    static {
        init();
    }

    synchronized static private void init() {

        try (InputStream in = EnvironmentUtils.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            // 要加载的属性文件
            Properties props = new Properties();
            props.load(in);
            runMode = props.getProperty(PARAM_ENV);
        } catch (FileNotFoundException e) {
            logger.error("address.properties文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException");
        }
    }

    public static String getTenant() {
        return runMode;
    }

    public static boolean isTest() {
        return StringUtils.equalsIgnoreCase(TEST, runMode);
    }

    public static boolean isDaily() {
        return StringUtils.equalsIgnoreCase(DAILY, runMode);
    }

    public static boolean isStaging() {
        return StringUtils.equalsIgnoreCase(STAGING, runMode);
    }

    public static boolean isProduction() {
        return StringUtils.equalsIgnoreCase(PRODUCTION, runMode);
    }

}
