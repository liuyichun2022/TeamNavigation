package com.dash.navigation.common.exception;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.dash.navigation.common.util.StringExtUtils;

/**
 * 资源文件解压异常
 * @author Jason.liu
 * @date 2024-02-04
 */
public class UnzipException extends RuntimeException {

    private static final long serialVersionUID = -1150086217385159231L;

    /**
     * UnzipException.
     *
     * @param message message
     * @param args args
     */
    public UnzipException(String message, Object... args) {
        super(StringExtUtils.format(message, args), EventArgUtil.extractThrowable(args));
    }

}
