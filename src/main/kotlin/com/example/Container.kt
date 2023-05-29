package com.example

interface Container<T> {
    fun add(element: T)
    fun remove(index: Int)
    fun update(index: Int, element: T)
    fun get(index: Int): T
    fun getAll(): List<T>
}

class PhoneContainer : Container<Phone> {
    private val phones: MutableList<Phone> = mutableListOf()
    override fun add(element: Phone) {
        phones.add(element)
    }

    override fun remove(index: Int) {
        phones.removeAt(index)
    }

    override fun update(index: Int, element: Phone) {
        phones[index] = element
    }

    override fun get(index: Int): Phone {
        return phones[index]
    }

    override fun getAll(): List<Phone> {
        return phones
    }
}