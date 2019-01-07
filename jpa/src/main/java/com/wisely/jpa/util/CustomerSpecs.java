package com.wisely.jpa.util;

import static com.google.common.collect.Iterables.toArray;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;





/**
 * 自定义Respository定制一个自动模糊查询
 *
 * @author changzhenzhen
 * @date 2018-12-27
 */
public class CustomerSpecs {

    //定义一个返回值为Specification的方法byAuto，使用泛型T，可以用于所有的实体类，
    // 接受的参数是entityManager和当前的包含值作为查询条件的实体类对象
    public static <T> Specification<T> byAuto(final EntityManager entityManager,
                                              final T example){
        //获取当前实体类对象的类型
        final Class<T> type = (Class<T>) example.getClass();

        return new Specification<T>() {

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //新建Predicate列表存储构造的查询条件
                List<Predicate> predicates = new ArrayList<>();
                //获取实体类的entityType，可根据entityType获取实体类的属性
                EntityType<T> entity = entityManager.getMetamodel().entity(type);
                //遍历实体类的属性
                for (Attribute<T,?> attr:entity.getDeclaredAttributes()){
                    Object attrValue = getValue(example,attr);
                    if (null != attrValue){
                        if (attr.getJavaType() == String.class){
                            if (!StringUtils.isEmpty(attrValue)){
                                //属性是字符串类型构造like查询条件
                                predicates.add(cb.like(root.get(attribute(entity,attr.getName(),String.class)), pattern((String)attrValue)));

                            }
                        }else {
                            //其他类型构造equal查询条件
                            predicates.add(cb.equal(root.get(attribute(entity,attr.getName(),attrValue.getClass())),attrValue));
                        }
                    }
                }

                return predicates.isEmpty()?cb.conjunction():cb.and(toArray(predicates,Predicate.class));
            }

            //通过反射获取对象的属性的值
            private <T> Object getValue(T example,Attribute<T,?> attr){
                return ReflectionUtils.getField((Field) attr.getJavaMember(),example);
            }

            private <E,T> SingularAttribute<T,E> attribute (EntityType<T> entity,String fileName,Class<E> fieldClass){
                return entity.getDeclaredSingularAttribute(fileName,fieldClass);
            }
        };
    }
    static private String pattern(String str){
        return "%"+str+"%";
    }
}
