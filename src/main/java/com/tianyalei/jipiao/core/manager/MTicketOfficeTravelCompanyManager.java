package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MTicketOfficeTravelCompanyEntity;
import com.tianyalei.jipiao.core.repository.MTicketOfficeTravelCompanyRepository;
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
* 差旅单位表
* @author Bai
* @date 2019/01/08 11:55
*/
@Service
public class MTicketOfficeTravelCompanyManager {

    @Resource
    private MTicketOfficeTravelCompanyRepository mTicketOfficeTravelCompanyRepository;

    /*
    分页查询
    */
    public SimplePage<MTicketOfficeTravelCompanyEntity> list(MTicketOfficeTravelCompanyEntity entity, Integer page, Integer size, String ord) {
        Pageable pageable = PageRequest.of(
                page, size,
                new Sort(Sort.Direction.ASC, ord)
        );
        //动态查询器
        Page<MTicketOfficeTravelCompanyEntity> all = mTicketOfficeTravelCompanyRepository.findAll(new Specification<MTicketOfficeTravelCompanyEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<MTicketOfficeTravelCompanyEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
        MTicketOfficeTravelCompanyEntity entity = one(id);
        //entity.setIsEnable(false);
        delete(entity);
    }
    /*
    详情
    */
    public MTicketOfficeTravelCompanyEntity one(Integer id) {
        return mTicketOfficeTravelCompanyRepository.getOne(id);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MTicketOfficeTravelCompanyEntity add(MTicketOfficeTravelCompanyEntity entity){
        return mTicketOfficeTravelCompanyRepository.save(entity);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MTicketOfficeTravelCompanyEntity update(MTicketOfficeTravelCompanyEntity entity){
        return mTicketOfficeTravelCompanyRepository.save(entity);
    }
    private void delete(MTicketOfficeTravelCompanyEntity entity) {
        //更新可用状态
        update(entity);
    }

}