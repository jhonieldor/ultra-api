package br.com.ultrasistemas.ultraapi.repository

import br.com.ultrasistemas.ultraapi.domain.Cidade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDateTime
import java.util.*

interface CidadeRepository : JpaRepository<Cidade, Int> {

    @Query(value = "select codigo, cidade, cep, estado, codnacional, pais " +
            "from cidades where data_criacao_alteracao >= :data", nativeQuery = true)
    fun getCidades(@Param("data") dataInicial: LocalDateTime): List<Cidade>


    @Query(value = "select codigo, cidade, cep, estado, codnacional, pais " +
            "from cidades", nativeQuery = true)
    fun getCidades(): List<Cidade>
}