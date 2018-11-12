package com.tianyalei.jipiao.core.request;

/**
 * @author wuweifeng wrote on 2018/11/12.
 */
public class Wechat {
    private String msgID;
    private String type;
    private Long time;
    private String atlist;
    private String fromWxid;
    private String sendWxid;
    private String recvWxid;
    private String msg;

    @Override
    public String toString() {
        return "Wechat{" +
                "msgID='" + msgID + '\'' +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", atlist='" + atlist + '\'' +
                ", fromWxid='" + fromWxid + '\'' +
                ", sendWxid='" + sendWxid + '\'' +
                ", recvWxid='" + recvWxid + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getMsgID() {
        return msgID;
    }

    public void setMsgID(String msgID) {
        this.msgID = msgID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getAtlist() {
        return atlist;
    }

    public void setAtlist(String atlist) {
        this.atlist = atlist;
    }

    public String getFromWxid() {
        return fromWxid;
    }

    public void setFromWxid(String fromWxid) {
        this.fromWxid = fromWxid;
    }

    public String getSendWxid() {
        return sendWxid;
    }

    public void setSendWxid(String sendWxid) {
        this.sendWxid = sendWxid;
    }

    public String getRecvWxid() {
        return recvWxid;
    }

    public void setRecvWxid(String recvWxid) {
        this.recvWxid = recvWxid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
