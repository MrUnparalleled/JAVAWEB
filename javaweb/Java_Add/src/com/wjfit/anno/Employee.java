package com.wjfit.anno;

//使用注解时，当只有一个属性并且名称为value，此时可以省略value
@SuppressWarnings("all")
@Deprecated
@VIP(name = "xx",age=20, hobby = { "java" })
public class Employee {

}
