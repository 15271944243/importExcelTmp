package com.sunlands.si.domain;


import javax.persistence.*;

/**
 * @description: 答案表实体类
 * @author: xxx.
 * @createDate: 2017/11/30.
 */
@Entity
@Table(name = "answer")
public class Answer {

    // 主键
    private Long id;
    // 问题回答内容
    private String answerContent;
    // 结果分支(该字段针对非选项类型的试题,不同的结果分支对应不同的下一个问题)
    private Integer answerBranch;
    // 指向下一个问题的类型序号
    private Integer nextSortNum;
    // 父表(question_type)id(外键关联)
    private Long questionTypeId;

    // private QuestionType questionType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Integer getAnswerBranch() {
        return answerBranch;
    }

    public void setAnswerBranch(Integer answerBranch) {
        this.answerBranch = answerBranch;
    }

    public Integer getNextSortNum() {
        return nextSortNum;
    }

    public void setNextSortNum(Integer nextSortNum) {
        this.nextSortNum = nextSortNum;
    }

    public Long getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Long questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    /*@ManyToOne(targetEntity = QuestionType.class)
    @JoinColumn(name = "FK_QUESTION_TYPE_ID_ANSWER")
    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }*/
}
