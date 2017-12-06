package com.sunlands.si.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 问题表实体类
 * @author: xxx.
 * @createDate: 2017/11/30.
 */
@Entity
@Table(name = "question")
public class Question {
    // 主键
    private Long id;
    // 二级类型代码
    private String typeCodeLvTwo;
    // 二级类型名称
    private String typeNameLvTwo;
    // 问题内容
    private String questionContent;
    // 父表(question_type)id(外键关联)
    // private Long questionTypeId;
    // 写了这个,就能不写上面的questionTypeId了
    private QuestionType questionType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeCodeLvTwo() {
        return typeCodeLvTwo;
    }

    public void setTypeCodeLvTwo(String typeCodeLvTwo) {
        this.typeCodeLvTwo = typeCodeLvTwo;
    }

    public String getTypeNameLvTwo() {
        return typeNameLvTwo;
    }

    public void setTypeNameLvTwo(String typeNameLvTwo) {
        this.typeNameLvTwo = typeNameLvTwo;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @ManyToOne(targetEntity = QuestionType.class)
    @JoinColumn(name = "question_type_id",foreignKey = @ForeignKey(name = "FK_QUESTION_TYPE_ID_QUESTION"))
    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
