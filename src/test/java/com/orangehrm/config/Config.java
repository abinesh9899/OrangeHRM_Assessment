package com.orangehrm.config;

import java.io.InputStream;
import java.util.Properties;

public final class Config {
    private static final Properties P = new Properties();
    static {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) throw new IllegalStateException("config.properties was not found");
            P.load(in);
        } catch (Exception e) { throw new RuntimeException("Unable to load configuration", e); }
    }
    private Config() {}
    public static String get(String key) {
        String env = System.getenv(key.toUpperCase().replace('.', '_'));
        return env != null && !env.isBlank() ? env : P.getProperty(key, "");
    }
    public static int timeout() { return Integer.parseInt(get("timeout.seconds")); }
    public static boolean headless() { return Boolean.parseBoolean(get("headless")); }
}
