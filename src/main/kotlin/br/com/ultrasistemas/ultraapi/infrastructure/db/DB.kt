package br.com.ultrasistemas.ultraapi.infrastructure.db

class DB {
    var url: String? = null

    val porta = "3050"

    var targetDB: String? = null

    var username: String? = null

    var password: String? = null

    constructor(url: String?, targetDB: String?, username: String?, password: String?) {
        this.url = url
        this.targetDB = targetDB
        this.username = username
        this.password = password
    }
}