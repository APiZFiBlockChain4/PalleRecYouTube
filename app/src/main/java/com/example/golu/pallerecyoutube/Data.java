package com.example.golu.pallerecyoutube;

/**
 * Created by GOLU on 09-05-2017.
 */

public class Data {


    private String slno;
    private String topic;
    private String duration;
    private String video;

    public Data(String slno, String topic, String duration, String video) {
        this.slno = slno;
        this.topic = topic;
        this.duration = duration;
        this.video = video;
    }

    public String getSlno() {
        return slno;
    }

    public void setSlno(String slno) {
        this.slno = slno;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
