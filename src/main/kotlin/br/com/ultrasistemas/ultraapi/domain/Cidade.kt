package br.com.ultrasistemas.ultraapi.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "CIDADES")
data class Cidade(
        @Id
        @Column(name = "CODIGO")
        val id: Int = 0,

        @Column(name = "CIDADE")
        val nome: String = "",

        @Column(name = "CEP")
        val cep: String = "",

        @Column(name = "ESTADO")
        val estado : String = "",

        @Column(name = "CODNACIONAL")
        val igbe: Int = 0,

        @Column(name = "PAIS")
        val pais: Int = 0

)