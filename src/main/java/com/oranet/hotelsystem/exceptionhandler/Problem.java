package com.oranet.hotelsystem.exceptionhandler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Problem {

    private Integer status;

    private String type;

    private String title;

    private String detail;

    private String userMessage;

    private LocalDateTime timeStamp;

    private List<Object> objects;

    @Getter
    @Builder
    public static class Object {

        private String name;

        private String userMessage;
    }


}
