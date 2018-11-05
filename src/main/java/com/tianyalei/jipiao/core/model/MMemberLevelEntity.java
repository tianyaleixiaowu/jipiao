package com.tianyalei.jipiao.core.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 会员级别表
 * @author wuweifeng wrote on 2018/11/1.
 */
//@Entity
//@Table(name = "M_MemberLevel", catalog = "")
public class MMemberLevelEntity {
    private String cardNum;
    /**
     * 会员等级（数据字典 GroupId=9）
     */
    private String gradeId;
    /**
     * 可用积分
     */
    private int availScore;
    /**
     * 总积分（消费累加，降级时减少）
     */
    private int totScore;
    /**
     * 会员等级有效期
     */
    private Timestamp memberGradeValid;

    @Id
    @Column(name = "CardNum")
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Basic
    @Column(name = "GradeID")
    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    @Basic
    @Column(name = "AvailScore")
    public int getAvailScore() {
        return availScore;
    }

    public void setAvailScore(int availScore) {
        this.availScore = availScore;
    }

    @Basic
    @Column(name = "TotScore")
    public int getTotScore() {
        return totScore;
    }

    public void setTotScore(int totScore) {
        this.totScore = totScore;
    }

    @Basic
    @Column(name = "MemberGradeValid")
    public Timestamp getMemberGradeValid() {
        return memberGradeValid;
    }

    public void setMemberGradeValid(Timestamp memberGradeValid) {
        this.memberGradeValid = memberGradeValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MMemberLevelEntity that = (MMemberLevelEntity) o;
        return availScore == that.availScore &&
                totScore == that.totScore &&
                Objects.equals(cardNum, that.cardNum) &&
                Objects.equals(gradeId, that.gradeId) &&
                Objects.equals(memberGradeValid, that.memberGradeValid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cardNum, gradeId, availScore, totScore, memberGradeValid);
    }
}
