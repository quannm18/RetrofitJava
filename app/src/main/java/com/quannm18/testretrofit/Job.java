package com.quannm18.testretrofit;

public class Job {
    public int id;
    public String job;

    public Job(int id, String job) {
        this.id = id;
        this.job = job;
    }

    public Job() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
