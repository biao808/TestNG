package com.example.testapiauto.app.dao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface caseDao {
    List<caseDao> queryAll();
    List<caseDao> queryId();


}
