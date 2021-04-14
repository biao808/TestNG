package com.example.testapiauto.app.serviceImp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.example.testapiauto.app.dao.caseDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: caseServiceImp
 * @Description: TODO
 * @author: 假斯文
 * @date: 2021年04月06日 14:27
 * @Version 1.0
 */

@Component
public abstract class caseServiceImp implements caseDao {
    @Resource
    caseDao caseDao;
    private static final Logger logger = LogManager.getLogger(caseServiceImp.class);

    @Override
    public List<caseDao> queryAll(){ return caseDao.queryAll();
    }

}