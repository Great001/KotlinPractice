package com.example.hancher.kotlinpractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    /**
     * Kotlin:常量
     */
    val id = 1111L   //自动识别类型， 等同于：val id : Long = 1111L
    /**
     * Kotlin变量
     */
    var name: String? = ""  //自动识别类型,自动判空,只有非空时才会执行

    /**
     * Kotlin变量，包含get和set函数
     */
    var desc: String?
        get() {
            return desc
        }
        set(value) {
            this.desc = value
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv_test).setText(getMyName1())

        testStrPattern("Android Kotlin")
        testArrayForeach()
        testDataClass()
    }

    /**
     * Kotlin:函数1
     */
    private fun getMyName1(): String {
        return "Hello World"
    }

    /**
     * Kotlin:函数2，直接返回，自动识别类型
     */
    private fun getMyName2() = "Hello World"

    /**
     * Kotlin:测试字符串模板
     */
    private fun testStrPattern(name: String) {
        val a = 1
        val b = 2
        println("testStrPattern:$name")
        println("$a + $b = ${a + b}")
    }


    /**
     * Kotlin:数组和Foreach
     */
    private fun testArrayForeach() {
        //字符数组
        var array: CharArray = charArrayOf('a', 'b', 'c', 'd', 'e')
        for (ch in array) {
            if (ch is Char) {
                println(ch)
            }
        }
    }

    /**
     * Kotlin:测试伴生对象
     */
    private fun testCompanion() {
        println(myName)
        println(getName())
    }

    /**
     * Kotlin：测试数据类
     */
    private fun testDataClass() {
        var person = Person("hancher", 18)  //创建对象不用new关键字
        println("名字：" + person.name + "年龄" + person.age)
    }

    /**
     * 伴生对象，静态调用
     */
    companion object {
        val myName = "Hancher"

        fun getName() = myName
    }


    /**
     * kotlin:数据对象 ，自动生成getter/setter,equals,hashCode等函数
     */
    data class Person(var name: String, var age: Int)//无函数体可以省略大括号
}
