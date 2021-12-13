package com.mischenkov.dao;

import org.apache.log4j.Logger;

public final class Storages {

    private static final Logger LOGGER = Logger.getLogger(Storages.class);

    private Storages() {}

    public static void quiteClose(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                LOGGER.warn(e);
            }
        }
    }
}
