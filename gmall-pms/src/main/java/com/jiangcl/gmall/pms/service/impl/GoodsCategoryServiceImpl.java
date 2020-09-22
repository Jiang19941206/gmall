package com.jiangcl.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jiangcl.gmall.pms.entity.GoodsCategory;
import com.jiangcl.gmall.pms.mapper.GoodsCategoryMapper;
import com.jiangcl.gmall.pms.service.GoodsCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jiangcl
 * @date 2020/9/18
 * @desc
 */
@Slf4j
@Service(timeout = 30000)
@Component
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    /**
     * 当一次请求中，有多个方法需要使用同一个值的时候，可以使用ThreadLocal保存这个值
     */
    ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    @Override
    public List<GoodsCategory> goodsCategoryList() {
        List<GoodsCategory> categories = goodsCategoryMapper.goodsCategoryList(0);
        return categories;
    }

    /**
     *  事物传播行为测试
     *      模拟场景：
     *          当一个方法需要多次对数据库进行写入操作时，针对业务需求，
     *          对不同的写入操作进行不同的事物控制
     *   使用到的事物传播行为
     *      REQUIRED：如果之前有事务就和之前使用同一个事物，否则创建一个事物
     *      REQUIRES_NEW：创建一个新事物，如果之前有一个事物，暂停之前的事物
     *
     *    外事物{
     *        A();REQUIRED
     *        B();REQUIRES_NEW
     *        C();REQUIRED
     *        D();REQUIRES_NEW
     *      自身逻辑...
     *    }
     *    场景1：
     *      A出现异常，所有都失败，无事物发生
     *    场景2：
     *      B出现异常，外事物感知到异常，所以A回滚，C,D以及外事物自身逻辑无法执行
     *    场景3：
     *      C出现异常，外事物感知到异常，A，C回滚，B成功，D以及外事物自身逻辑无法执行
     *    场景4：
     *      D出现异常，外事物感知到异常，A，C回滚，B成功，外事物自身逻辑无法执行
     *    场景5：
     *      外事物自身逻辑出现异常，A,C,自身逻辑回滚，B，D成功
     *    场景6：
     *      try{
     *          C();
     *      }catch{}
     *      对C方法进行try-catch,由于C方法对异常进行了捕获，所以外事物无法感知异常，
     *      即A，B，D，外事物自身逻辑都执行成功
     *
     *      事物存在的问题：
     *          当service调用自己本类中的方法时，无法加上被调用方法本身的事物
     *          解决方式：
     *              1、导入AOP包，开启代理对象相关功能
     *              2、在启动类中加上@EnableAspectJAutoProxy(exposeProxy = true)，暴露代理对象
     *              3、获取代理对象，并调用方法
     * *******************************
     *      异常回滚策略：
     *          运行时异常默认回滚
     *          编译时异常默认不会滚
     *          可以使用rollbackFor指定那些异常回滚
     *              使用noRollbackFor指定哪些异常不回滚
     */

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insertCategory() {
        threadLocal.set(System.currentTimeMillis());
        log.info("当前时间戳为：{}",threadLocal.get());
        //获取代理对象
        GoodsCategoryServiceImpl proxy = (GoodsCategoryServiceImpl)AopContext.currentProxy();
        proxy.insertCategoryA();
        proxy.insertCategoryB();
        proxy.insertCategoryC();
        proxy.insertCategoryD();
        int i = 1/0;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertCategoryA(){
        goodsCategoryMapper.insertCategoryA(threadLocal.get(),"事物测试A",1l);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertCategoryB(){
        goodsCategoryMapper.insertCategoryB(threadLocal.get(),"事物测试B");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertCategoryC(){
        goodsCategoryMapper.insertCategoryC(threadLocal.get(),"事物测试C",1l);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertCategoryD(){
        goodsCategoryMapper.insertCategoryD(threadLocal.get(),"事物测试D",1l);
    }
}
