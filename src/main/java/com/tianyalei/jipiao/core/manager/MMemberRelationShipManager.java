package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberRelationShipEntity;
import com.tianyalei.jipiao.core.repository.MMemberRelationShipRepository;
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

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
* 会员亲属关系表
* @author Bai
* @date 2019/01/07 11:00
*/
@Service
public class MMemberRelationShipManager {

    @Resource
    private MMemberRelationShipRepository mMemberRelationShipRepository;

    /*
    分页查询
    */
    public SimplePage<MMemberRelationShipEntity> list(MMemberRelationShipEntity entity, Integer page, Integer size, String ord) {
        Pageable pageable = PageRequest.of(
                page, size,
                new Sort(Sort.Direction.ASC, ord)
        );
        //动态查询器
        Page<MMemberRelationShipEntity> all = mMemberRelationShipRepository.findAll(new Specification<MMemberRelationShipEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<MMemberRelationShipEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
        MMemberRelationShipEntity entity = one(id);
        entity.setIsEnable(false);
        delete(entity);
    }
    /*
    详情
    */
    public MMemberRelationShipEntity one(Integer id) {
        return mMemberRelationShipRepository.getOne(id);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MMemberRelationShipEntity add(MMemberRelationShipEntity entity){
        return mMemberRelationShipRepository.save(entity);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MMemberRelationShipEntity update(MMemberRelationShipEntity entity){
        return mMemberRelationShipRepository.save(entity);
    }
    private void delete(MMemberRelationShipEntity entity) {
        //更新可用状态
        update(entity);
    }

}