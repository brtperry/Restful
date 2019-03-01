package com.demo.restful;

public class Message {

    private final long id;

    private final String content;

    public Message(long id, String content) {
        this.id = id;
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public long getId() {
        return id;
    }
}
