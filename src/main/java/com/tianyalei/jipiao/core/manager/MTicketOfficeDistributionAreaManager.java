package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MTicketOfficeDistributionAreaEntity;
import com.tianyalei.jipiao.core.repository.MTicketOfficeDistributionAreaRepository;
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
* 配送区域表
* @author Bai
* @date 2019/01/08 11:55
*/
@Service
public class MTicketOfficeDistributionAreaManager {

    @Resource
    private MTicketOfficeDistributionAreaRepository mTicketOfficeDistributionAreaRepository;

    /*
    分页查询
    */
    public SimplePage<MTicketOfficeDistributionAreaEntity> list(MTicketOfficeDistributionAreaEntity entity, Integer page, Integer size, String ord) {
        Pageable pageable = PageRequest.of(
                page, size,
                new Sort(Sort.Direction.ASC, ord)
        );
        //动态查询器
        Page<MTicketOfficeDistributionAreaEntity> all = mTicketOfficeDistributionAreaRepository.findAll(new Specification<MTicketOfficeDistributionAreaEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<MTicketOfficeDistributionAreaEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
        MTicketOfficeDistributionAreaEntity entity = one(id);
        //entity.setIsEnable(false);
        delete(entity);
    }
    /*
    详情
    */
    public MTicketOfficeDistributionAreaEntity one(Integer id) {
        return mTicketOfficeDistributionAreaRepository.getOne(id);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MTicketOfficeDistributionAreaEntity add(MTicketOfficeDistributionAreaEntity entity){
        return mTicketOfficeDistributionAreaRepository.save(entity);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MTicketOfficeDistributionAreaEntity update(MTicketOfficeDistributionAreaEntity entity){
        return mTicketOfficeDistributionAreaRepository.save(entity);
    }
    private void delete(MTicketOfficeDistributionAreaEntity entity) {
        //更新可用状态
        update(entity);
    }

}