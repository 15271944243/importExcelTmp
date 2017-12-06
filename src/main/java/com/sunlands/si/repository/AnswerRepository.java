package com.sunlands.si.repository;

import com.sunlands.si.domain.Answer;


/**
 * @description:
 * @author: xxx.
 * @createDate: 2017/11/30.
 */
public interface AnswerRepository extends OrmRepository<Answer,Long> {

    @Override
    default String name(){
        return "问题回答";
    }
}
