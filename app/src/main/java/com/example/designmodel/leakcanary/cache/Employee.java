package com.example.designmodel.leakcanary.cache;

/**
 * Created by tellerWang on 2020/12/25.
 */
public class Employee {
    private String id;// 雇员的标识号码
    private String name;// 雇员姓名
    private String department;// 该雇员所在部门
    private String Phone;// 该雇员联系电话
    private int salary;// 该雇员薪资
    private String origin;// 该雇员信息的来源

    // 构造方法
    public Employee(String id) {
        this.id = id;
        getDataFromlnfoCenter();
    }

    // 到数据库中取得雇员信息
    private void getDataFromlnfoCenter() {
        // 和数据库建立连接井查询该雇员的信息，将查询结果赋值
        // 给name，department，plone，salary等变量
        // 同时将origin赋值为"From DataBase"
    }

    public String getID() {
        return id;
    }
}
