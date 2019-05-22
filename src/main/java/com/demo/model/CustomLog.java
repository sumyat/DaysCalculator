package com.demo.model;

public class CustomLog {
    private String message = "";
    private Level level = Level.INFO;

    public enum Level {
        INFO, WARN, ERROR;
    }

    private CustomLog() {}

    public String getMessage() {
        return message;
    }

    public Level getLevel() {
        return level;
    }

    public static final class LogBuilder {
        protected String message;
        protected Level level;

        private LogBuilder() {}

        public static LogBuilder aLog() {
            return new LogBuilder();
        }

        public LogBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public LogBuilder withLevel(Level level) {
            this.level = level;
            return this;
        }

        public CustomLog build() {
            CustomLog customLog = new CustomLog();
            customLog.message = this.message;
            customLog.level = this.level;
            return customLog;
        }
    }
}
