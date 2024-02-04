package com.dash.navigation.common.exception;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.dash.navigation.common.util.StringExtUtils;

/**
 * 资源文件读取异常
 * @author Jason.liu
 * @date 2024-02-04
 */
public class ResourceReadException extends RuntimeException {

    private static final long serialVersionUID = 143422262865091780L;

    /**
     * ResourceReadException.
     *
     * @param message message
     * @param args args
     */
    public ResourceReadException(String message, Object... args) {
        super(StringExtUtils.format(message, args), EventArgUtil.extractThrowable(args));
    }

}
