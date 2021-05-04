package com.web.demo.exception;

/**
 * @author 郑超
 * @date 2021-05-04 11:04
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在！");
    }
}
