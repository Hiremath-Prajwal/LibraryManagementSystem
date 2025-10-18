package com.library.util;

import java.io.IOException;
import java.util.logging.*;

/**
 * LibraryLogger is a utility class that provides a centralized logger configuration
 * for the Library Management System.
 * 
 * It configures a global Logger with both console and file handlers,
 * ensuring consistent and readable log output across all classes.
 */
public final class LibraryLogger {

    private static final String LOG_FILE = "library.log";
    private static boolean initialized = false;

    private LibraryLogger() {
        // Private constructor to prevent instantiation
    }

    /**
     * Returns a configured logger for the given class.
     * 
     * @param clazz The class requesting the logger.
     * @return A configured Logger instance.
     */
    public static Logger getLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz.getName());
        if (!initialized) {
            configureLogger();
        }
        return logger;
    }

    /**
     * Configures the global logging behavior (executed once).
     */
    private static void configureLogger() {
        try {
            LogManager.getLogManager().reset();
            Logger rootLogger = Logger.getLogger("");

            // Console handler
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            consoleHandler.setFormatter(new SimpleFormatter());

            // File handler
            FileHandler fileHandler = new FileHandler(LOG_FILE, true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());

            // Attach handlers
            rootLogger.addHandler(consoleHandler);
            rootLogger.addHandler(fileHandler);
            rootLogger.setLevel(Level.ALL);

            initialized = true;

        } catch (IOException e) {
            System.err.println("Failed to initialize logging system: " + e.getMessage());
        }
    }
}
