package com.tianyalei.jipiao.core.manager;

import com.alibaba.fastjson.JSONObject;
import com.tianyalei.jipiao.core.model.MMemberPaperEntity;
import com.tianyalei.jipiao.core.repository.MemberPaperRepository;
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
public class MemberPaperManager {

    @Resource
    private MemberPaperRepository memberPaperRepository;
    /*
    分页查询
     */
    public SimplePage<MMemberPaperEntity> list(MMemberPaperEntity entity, Integer page, Integer size, String ord) {
        Pageable pageable = PageRequest.of(
                page, size,
                new Sort(Sort.Direction.ASC, ord)
        );
        //动态查询器
        Page<MMemberPaperEntity> all = memberPaperRepository.findAll(new Specification<MMemberPaperEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<MMemberPaperEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                //动态查询语句
                /*if (!StringUtils.isEmpty(entity.getCardNum())) {
                    predicates.add(cb.and(cb.equal(root.get("cardNum"), entity.getCardNum())));
                }*/
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
        MMemberPaperEntity entity = one(id);
        entity.setIsEnable(false);
        delete(entity);
    }
    /*
    详情
     */
    public MMemberPaperEntity one(Integer id) {
        return memberPaperRepository.getOne(id);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MMemberPaperEntity add(MMemberPaperEntity entity){
        System.err.println(JSONObject.toJSONString(entity));
        return memberPaperRepository.save(entity);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MMemberPaperEntity update(MMemberPaperEntity entity){
        return memberPaperRepository.save(entity);
    }
    private void delete(MMemberPaperEntity entity) {
        //更新可用状态
        update(entity);
    }
}
