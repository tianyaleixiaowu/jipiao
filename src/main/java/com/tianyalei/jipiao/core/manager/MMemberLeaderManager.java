package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberLeaderEntity;
import com.tianyalei.jipiao.core.repository.MMemberLeaderRepository;
import com.tianyalei.jipiao.global.bean.SimplePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class MMemberLeaderManager {

    @Resource
    private MMemberLeaderRepository mMemberLeaderRepository;

    /*
    分页查询
    */
    public SimplePage<MMemberLeaderEntity> list(MMemberLeaderEntity entity, Integer page, Integer size, String ord) {
        Pageable pageable = PageRequest.of(
                page, size,
                new Sort(Sort.Direction.ASC, ord)
        );
        //动态查询器
        Page<MMemberLeaderEntity> all = mMemberLeaderRepository.findAll(new Specification<MMemberLeaderEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<MMemberLeaderEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                //动态查询语句
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return new SimplePage<>(all.getTotalPages(), all
                    .getTotalElements(), all.getContent());
    }

    /*
    删除逻辑更改可用状态
    */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void updateIsEnable(Integer id) throws Exception{
        MMemberLeaderEntity entity = one(id);
        entity.setIsEnable(false);
        delete(entity);
    }
    /*
    详情
    */
    public MMemberLeaderEntity one(Integer id) {
        return mMemberLeaderRepository.getOne(id);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MMemberLeaderEntity add(MMemberLeaderEntity entity){
        return mMemberLeaderRepository.save(entity);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MMemberLeaderEntity update(MMemberLeaderEntity entity){
        return mMemberLeaderRepository.save(entity);
    }
    private void delete(MMemberLeaderEntity entity) {
        //更新可用状态
        update(entity);
    }

}