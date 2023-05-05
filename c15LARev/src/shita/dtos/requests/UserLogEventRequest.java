package shita.dtos.requests;

import shita.data.models.User;

import java.time.LocalDateTime;

public class UserLogEventRequest {
    private String what;
    private User who;
    private LocalDateTime when;

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public User getWho() {
        return who;
    }

    public void setWho(User who) {
        this.who = who;
    }

    public LocalDateTime getWhen(LocalDateTime now) {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }
}
