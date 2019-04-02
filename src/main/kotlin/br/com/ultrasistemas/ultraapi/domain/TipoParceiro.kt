package br.com.ultrasistemas.ultraapi.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "TIPOS_PARCEIROS")
data class TipoParceiro(
        @Id
        @Column(name = "TIPO_PARCEIRO")
        val id: Int = 0,

        @Column(name = "DSC_TIPO_DESCRICAO")
        val nome: String = ""
)