package com.fynnjason.app.goodrequest.model;

/**
 * Created by FynnJason.
 * Function：
 */
public class UserInfoModel extends BaseModel {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private int userid;
        private String nickname;
        private String mobile;
        private String image;
        private int level;
        private int jifen;
        private String invitecode;
        private String zhifubao;
        private String tbid;
        private String earnamount;
        private int inviter;
        private int regdays;
        private int next_jifen;
        private String flbl;
        private int redpacket;
        private String today_estimate;
        private String month_estimate;
        private String last_month_estimate;
        private String total_estimate;
        private String amount;

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getJifen() {
            return jifen;
        }

        public void setJifen(int jifen) {
            this.jifen = jifen;
        }

        public String getInvitecode() {
            return invitecode;
        }

        public void setInvitecode(String invitecode) {
            this.invitecode = invitecode;
        }

        public String getZhifubao() {
            return zhifubao;
        }

        public void setZhifubao(String zhifubao) {
            this.zhifubao = zhifubao;
        }

        public String getTbid() {
            return tbid;
        }

        public void setTbid(String tbid) {
            this.tbid = tbid;
        }

        public String getEarnamount() {
            return earnamount;
        }

        public void setEarnamount(String earnamount) {
            this.earnamount = earnamount;
        }

        public int getInviter() {
            return inviter;
        }

        public void setInviter(int inviter) {
            this.inviter = inviter;
        }

        public int getRegdays() {
            return regdays;
        }

        public void setRegdays(int regdays) {
            this.regdays = regdays;
        }

        public int getNext_jifen() {
            return next_jifen;
        }

        public void setNext_jifen(int next_jifen) {
            this.next_jifen = next_jifen;
        }

        public String getFlbl() {
            return flbl;
        }

        public void setFlbl(String flbl) {
            this.flbl = flbl;
        }

        public int getRedpacket() {
            return redpacket;
        }

        public void setRedpacket(int redpacket) {
            this.redpacket = redpacket;
        }

        public String getToday_estimate() {
            return today_estimate;
        }

        public void setToday_estimate(String today_estimate) {
            this.today_estimate = today_estimate;
        }

        public String getMonth_estimate() {
            return month_estimate;
        }

        public void setMonth_estimate(String month_estimate) {
            this.month_estimate = month_estimate;
        }

        public String getLast_month_estimate() {
            return last_month_estimate;
        }

        public void setLast_month_estimate(String last_month_estimate) {
            this.last_month_estimate = last_month_estimate;
        }

        public String getTotal_estimate() {
            return total_estimate;
        }

        public void setTotal_estimate(String total_estimate) {
            this.total_estimate = total_estimate;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}
