package infrastructure;

import infrastructure.logger.StdLogger;

public class ConfigurationManager {
    private static ConfigurationManager configurationManager;
    private Browser browser;
    private OS os;

    private ConfigurationManager() {
        String browser = System.getenv("CM_BROWSER");
        String os = System.getenv("CM_OS");
        if (browser.contains("chrome"))
            this.browser = Browser.CHROME;
        else if (browser.contains("firefox"))
            this.browser = Browser.FIREFOX;
        if (os.contains("windows"))
            this.os = OS.WINDOWS;
        else if (browser.contains("linux"))
            this.os = OS.LINUX;
        else if (browser.contains("mac"))
            this.os = OS.MAC;
    }

    public static ConfigurationManager getConfigurationManager() {
        if (configurationManager == null) {
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }

    public Browser getBrowser() {
        return browser;
    }

    public OS getOS() {
        return os;
    }
}