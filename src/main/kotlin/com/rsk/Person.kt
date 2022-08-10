package com.rsk

interface Signatory {
    fun sign()
}

// Classes are final by default in kotlin
class Person(val name: String, var age: Int) : Signatory {
    override fun sign() = println("$name aged $age can sign doc")
}

open class OpenPerson(val name: String, var age: Int) : Signatory {
    // Run after object is constructed
    init {
        if (name.equals("John") && age < 54) throw Exception("invalid age")
    }

    var isMarried = false

    // Secondary constructor like this are not preferred rather use default value on primary constructor like OpenPersonWithMarriage
    constructor(name: String, age: Int, isMarried: Boolean) : this(name, age) {
        this.isMarried = isMarried
    }
    override fun sign() = println("Student with $name aged $age can sign doc")
}

open class OpenPersonWithMarriage(val name: String, var age: Int, var isMarried: Boolean = false) : Signatory {
    override fun sign() = println("OpenPerson $name aged $age can sign doc(Maritial status isMarried:$isMarried)")

}


open class Student(name: String, age: Int) : OpenPerson(name, age) {
    override fun sign() = println("OpenPerson $name aged $age can sign doc(Maritial status isMarried:$isMarried)")
}

fun main(args: Array<String>) {
    val p = Person("John", 55)
    p.sign()
    p.age = 44
    p.sign()

    Student("John", 55).sign()
}
