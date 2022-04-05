package com.dominic.memorygame

import java.io.Serializable

class WinGame : Serializable {
    var score:String? = "0"


    constructor(score: String?) {
        this.score = score

    }

    constructor()
}