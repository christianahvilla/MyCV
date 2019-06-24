package com.werden.mycv.common

class CommonFunctions {

    fun fillItems(items: ArrayList<String>): String {
        var finalString: String = ""

        items.forEach { item -> run {
            finalString += "* $item\n"
        } }

        return finalString
    }
}