package com.sunlands.si.domain;

import com.sunlands.si.constant.AnswerType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 问题类别表实体类
 * @author: xxx.
 * @createDate: 2017/11/30.
 */
@Entity
@Table(name = "question_type")
public class QuestionType {
    // 主键
    private Long id;
    // 类型序号
    private Integer sortNum;
    // 类型名称
    private String typeName;
    // 答案类型(0:无回答,1:选项,2:无过滤条件的自由输入,3:针对电话微信号码的过滤)
    private AnswerType answerType;

    private List<Question> questionList = new ArrayList<Question>(0);
    // private List<Answer> answerList = new ArrayList<Answer>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getTypeName() { return typeName; }

    public void setTypeName(String typeName) { this.typeName = typeName; }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    @OneToMany(targetEntity =  Question.class,mappedBy = "questionType")
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    /*@OneToMany(targetEntity =  Answer.class,mappedBy = "questionType")
    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }*/
}
