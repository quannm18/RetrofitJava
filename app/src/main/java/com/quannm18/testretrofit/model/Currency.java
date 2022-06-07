package com.quannm18.testretrofit.model;

public class Currency {
    private boolean success;
    private String terms;
    private String privacy;
    private int timestamp;
    private String source;
    private Quotes quotes;

    public Currency(boolean success, String terms, String privacy, int timestamp, String source, Quotes quotes) {
        this.success = success;
        this.terms = terms;
        this.privacy = privacy;
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
    }

    public Currency() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    public void setQuotes(Quotes quotes) {
        this.quotes = quotes;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "success=" + success +
                ", terms='" + terms + '\n' +
                ", privacy='" + privacy + '\n' +
                ", timestamp=" + timestamp +
                ", source='" + source + '\n' +
                ", quotes=" + quotes +
                '}';
    }
}
