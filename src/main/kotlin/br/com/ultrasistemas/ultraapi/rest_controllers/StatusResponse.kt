package br.com.ultrasistemas.ultraapi.rest_controllers

data class StatusResponse(
        val valid: Boolean = false,
        val mensagem: String = "",
        var result: Any? = null,
        var count: Int? = null,
        val codigo: Int? = null

)