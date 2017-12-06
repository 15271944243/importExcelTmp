package com.sunlands.si.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@NoRepositoryBean
public interface OrmRepository<T, ID extends Serializable>
		extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {
	default String name() {
		return "业务对象";
	}

	/**
	 * 加载实体么，如果加载不到则会抛出异常
	 * 
	 * @param id
	 *            主键
	 * @return 对应实体
	 */
	default T load(ID id) {
		T entity = this.findOne(id);
		if (entity == null) {
			StringBuilder msg = new StringBuilder(this.name());
			msg.append("[").append(id).append("]不存在!");
			throw new RuntimeException(msg.toString());
		}
		return entity;
	}
}
