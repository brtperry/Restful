package com.demo.restful;

public class Response {
    private final String content;
    private final int count;

    public Response(final String content, final int count) {
        this.content=content;
        this.count=count;
    }

    public String getContent() {
        return content;
    }

    public int getCount() {
        return count;
    }
}
