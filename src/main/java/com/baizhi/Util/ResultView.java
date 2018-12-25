package com.baizhi.Util;

public class ResultView {
    private String content;
    private Boolean verify;
    public ResultView(String content, Boolean verify) {
        this.content = content;
        this.verify = verify;
    }
    @Override
    public String toString() {
        return "ResultView{" +
                "content='" + content + '\'' +
                ", verify=" + verify +
                '}';
    }

    public ResultView() {
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getVerify() {
        return verify;
    }

    public void setVerify(Boolean verify) {
        this.verify = verify;
    }
}
