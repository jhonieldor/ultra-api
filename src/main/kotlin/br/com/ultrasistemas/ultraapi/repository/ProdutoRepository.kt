package br.com.ultrasistemas.ultraapi.repository

import br.com.ultrasistemas.ultraapi.domain.Produto
import br.com.ultrasistemas.ultraapi.domain.ProdutoPK
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

interface ProdutoRepository: JpaRepository<Produto, ProdutoPK>{

    @Query(value = "SELECT CODPRODUTO, CODPRODUTO_CLAS, DSCPRODUTO, DSCPRODUTO_CLAS, CUSTO, MARCA, " +
            "UND_MEDIDA, IDNGRADE, LINHA, COLUNA, PRECO, QTD_ESTOQUE, CODGRUPO_NIVEL1, CODGRUPO_NIVEL2, " +
            "CODGRUPO_NIVEL3, GRUPO_FISCAL, SUSPENDER_PEDIDOS, DATA_BAIXA, IDN_REVENDA, DSCGRUPO_NIVEL1, DSCGRUPO_NIVEL2, IDN_FORA_LINHA," +
            "REF_FABRICA, CODBARRAS, PRECO_MINIMO, OBS, MARCKUP_MIN, MARCKUP_PADRAO, PESO_PRODUTO, PESO_EMBALAGEM " +
            "FROM WS_PRODUTOS_POCKET(:DATA_HORA_INI, :IDVENDEDOR, :IDFILIAL) ", nativeQuery = true)
    fun getWSProdutos(@Param("DATA_HORA_INI") dataHoraInicial: LocalDateTime,
                      @Param("IDVENDEDOR") vendedor: Int,
                      @Param("IDFILIAL") filial: Int): List<Produto>

    @Query(value = "SELECT CODPRODUTO, CODPRODUTO_CLAS, DSCPRODUTO, DSCPRODUTO_CLAS, CUSTO, MARCA, " +
            "UND_MEDIDA, IDNGRADE, LINHA, COLUNA, PRECO, QTD_ESTOQUE, CODGRUPO_NIVEL1, CODGRUPO_NIVEL2, " +
            "CODGRUPO_NIVEL3, GRUPO_FISCAL, SUSPENDER_PEDIDOS, DATA_BAIXA, IDN_REVENDA, DSCGRUPO_NIVEL1, DSCGRUPO_NIVEL2, IDN_FORA_LINHA," +
            "REF_FABRICA, CODBARRAS, PRECO_MINIMO, OBS, MARCKUP_MIN, MARCKUP_PADRAO, PESO_PRODUTO, PESO_EMBALAGEM, TIPO, DSC_TIPO " +
            "FROM WS_PRODUTOS_AGRO_VISITAS(:DATA_HORA_INI, :IDVENDEDOR, :IDFILIAL) WHERE TIPO IN (:TIPOS) ", nativeQuery = true)
    fun getWSProdutos(@Param("DATA_HORA_INI") dataHoraInicial: LocalDateTime,
                      @Param("IDVENDEDOR") vendedor: Int,
                      @Param("IDFILIAL") filial: Int,
                      @Param("TIPOS") tipos: List<Int>): List<Produto>


    @Query(value = "SELECT CODPRODUTO, CODPRODUTO_CLAS, DSCPRODUTO, DSCPRODUTO_CLAS, CUSTO, MARCA, " +
            "UND_MEDIDA, IDNGRADE, LINHA, COLUNA, PRECO, QTD_ESTOQUE, CODGRUPO_NIVEL1, CODGRUPO_NIVEL2, " +
            "CODGRUPO_NIVEL3, GRUPO_FISCAL, SUSPENDER_PEDIDOS, DATA_BAIXA, IDN_REVENDA, DSCGRUPO_NIVEL1, DSCGRUPO_NIVEL2, IDN_FORA_LINHA," +
            "REF_FABRICA, CODBARRAS, PRECO_MINIMO, OBS, MARCKUP_MIN, MARCKUP_PADRAO, PESO_PRODUTO, PESO_EMBALAGEM, TIPO, DSC_TIPO " +
            "FROM WS_PRODUTOS_AGRO_VISITAS(:DATA_HORA_INI, :IDVENDEDOR, :IDFILIAL) WHERE CODPRODUTO = :CODPRODUTO AND CODPRODUTO_CLAS = :CLAS", nativeQuery = true)
    fun getWSProduto(@Param("DATA_HORA_INI") dataHoraInicial: LocalDateTime,
                      @Param("IDVENDEDOR") vendedor: Int,
                      @Param("IDFILIAL") filial: Int,
                      @Param("CODPRODUTO") codProduto: Int,
                      @Param("CLAS") codProdutoClas: Int): Produto

    @Query(value = "SELECT CODPRODUTO, CODPRODUTO_CLAS, DSCPRODUTO, DSCPRODUTO_CLAS, CUSTO, MARCA, " +
            "UND_MEDIDA, IDNGRADE, LINHA, COLUNA, PRECO, QTD_ESTOQUE, CODGRUPO_NIVEL1, CODGRUPO_NIVEL2, " +
            "CODGRUPO_NIVEL3, GRUPO_FISCAL, SUSPENDER_PEDIDOS, DATA_BAIXA, IDN_REVENDA, DSCGRUPO_NIVEL1, DSCGRUPO_NIVEL2, IDN_FORA_LINHA," +
            "REF_FABRICA, CODBARRAS, PRECO_MINIMO, OBS, MARCKUP_MIN, MARCKUP_PADRAO, PESO_PRODUTO, PESO_EMBALAGEM, TIPO, DSC_TIPO " +
            "FROM WS_PRODUTOS_AGRO_VISITAS(:DATA_HORA_INI, :IDVENDEDOR, :IDFILIAL) WHERE TIPO IN (:TIPOS) ", nativeQuery = true)
    fun getWSProdutosTest(@Param("DATA_HORA_INI") dataHoraInicial: LocalDate,
                      @Param("IDVENDEDOR") vendedor: Int,
                      @Param("IDFILIAL") filial: Int,
                      @Param("TIPOS") tipos: List<Int>): List<Produto>
}