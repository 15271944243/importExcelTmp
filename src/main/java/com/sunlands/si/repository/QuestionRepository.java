package com.sunlands.si.repository;

import com.sunlands.si.domain.Question;

/**
 * @description:
 * @author: xxx.
 * @createDate: 2017/11/30.
 */
public interface QuestionRepository extends OrmRepository<Question,Long> {

    @Override
    default String name(){
        return "问题";
    }
}
