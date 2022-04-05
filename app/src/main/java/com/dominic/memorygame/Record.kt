package com.dominic.memorygame

import java.io.Serializable

class Record : Serializable {
    var record:String? = "0"

    constructor(record: String?) {
        this.record = record
    }

    constructor()
}