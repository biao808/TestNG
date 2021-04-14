package com.example.testapiauto.app.entity;
import lombok.Data;
/**
 * @ClassName: caseEntity
 * @Description: TODO
 * @author: 假斯文
 * @date: 2021年04月06日 14:20
 * @Version 1.0
 */
@Data
public class caseEntity {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}