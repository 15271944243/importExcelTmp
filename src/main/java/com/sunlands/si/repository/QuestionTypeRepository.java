package com.sunlands.si.repository;

import com.sunlands.si.domain.QuestionType;

/**
 * @description:
 * @author: xxx.
 * @createDate: 2017/11/30.
 */
public interface QuestionTypeRepository extends OrmRepository<QuestionType,Long> {

    @Override
    default String name(){
        return "问题分类";
    }
}
