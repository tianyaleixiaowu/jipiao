package com.tianyalei.jipiao.core.manager;

import com.alibaba.fastjson.JSONObject;
import com.tianyalei.jipiao.core.model.MMemberEntity;
import com.tianyalei.jipiao.core.model.MMemberPassengerEntity;
import com.tianyalei.jipiao.core.repository.MMemberPassengerRepository;
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
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
* 会员（因公出行）常用乘机人表
* @author Bai
* @date 2019/01/07 11:38
*/
@Service
public class MMemberPassengerManager {

    @Resource
    private MMemberPassengerRepository mMemberPassengerRepository;

    /*
    分页查询
    */
    public SimplePage<MMemberPassengerEntity> list(MMemberPassengerEntity entity, Integer page, Integer size, String ord) {
        Pageable pageable = PageRequest.of(
                page, size,
                new Sort(Sort.Direction.ASC, ord)
        );
        //动态查询器
        Page<MMemberPassengerEntity> all = mMemberPassengerRepository.findAll(new Specification<MMemberPassengerEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<MMemberPassengerEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                /*//级联查询被关联实体名称在实体中映射
                Join<MMemberPassengerEntity,MMemberEntity> join = root.join("mMemberEntity",JoinType.INNER);
                //动态查询语句
                Path<Object> cardNum = join.get("cardNum");
                predicates.add(cb.and(cb.equal(join.get("cardNum"),entity.getmMemberEntity().getCardNum())));*/
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        SimplePage<MMemberPassengerEntity> listPage = new SimplePage<>(all.getTotalPages(), all
                .getTotalElements(), all.getContent());
        //转换属性
        List<MMemberPassengerEntity> list = (List<MMemberPassengerEntity>) listPage.getList();
        list.stream().forEach(num -> {
            num.setCardNumName(StringUtils.isEmpty(num.getmMemberEntity().getRealName()) ? "" : num.getmMemberEntity().getRealName());
        });
        return listPage;
    }

    /*
    删除逻辑更改可用状态
    */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void updateIsEnable(Integer id) throws Exception{
        MMemberPassengerEntity entity = one(id);
        entity.setIsEnable(false);
        delete(entity);
    }
    /*
    详情
    */
    public MMemberPassengerEntity one(Integer id) {
        MMemberPassengerEntity one = mMemberPassengerRepository.getOne(id);
        one.setCardNumName(StringUtils.isEmpty(one.getmMemberEntity().getRealName()) ? "" : one.getmMemberEntity().getRealName());
        return one;
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MMemberPassengerEntity add(MMemberPassengerEntity entity){
        return mMemberPassengerRepository.save(entity);
    }
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public MMemberPassengerEntity update(MMemberPassengerEntity entity){
        return mMemberPassengerRepository.save(entity);
    }
    private void delete(MMemberPassengerEntity entity) {
        //更新可用状态
        update(entity);
    }

}