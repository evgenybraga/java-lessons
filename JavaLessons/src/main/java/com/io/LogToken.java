package com.io;

import java.time.LocalDateTime;

/**
 * Created by ibraga on 17/01/2016.
 */
public class LogToken {

    enum HttpMethod {
        GET,
        POST;
    }
    LocalDateTime time;
    HttpMethod method;
    String message;

}
