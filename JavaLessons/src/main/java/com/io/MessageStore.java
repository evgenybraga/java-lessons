package com.io;

import java.util.Collection;
import java.util.Date;

public interface MessageStore {

    class Message {
        private int id;
        private Date date;
        private String content;

        Message(int id, Date date, String content) {
            this.id = id;
            this.date = date;
            this.content = content;
        }
    }

    void persist(Message message);

    void persist(Collection<Message> list);
}
