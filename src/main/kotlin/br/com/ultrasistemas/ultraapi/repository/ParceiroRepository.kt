package br.com.ultrasistemas.ultraapi.repository

import br.com.ultrasistemas.ultraapi.domain.Parceiro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate
import java.time.LocalDateTime
import javax.transaction.Transactional

interface ParceiroRepository : JpaRepository<Parceiro, Int> {

    @Query(value = "select distinct pa.parceiro, pa.nome, pa.fantasia, pa.razao_social, pa.endereco, pa.latitude, pa.longitude,\n" +
            "pa.cep, pa.celular, pa.telefone, pa.complemento, pa.tipo_parceiro, pa.bairro, pa.codcidade, pa.municipio, pa.uf, pa.email_xml, pa.email,\n" +
            "pa.vendedor_do_parceiro\n" +
            "from parceiros pa\n" +
            "where pa.idn_cliente = 'S'", nativeQuery = true)
    fun getParceiros(): List<Parceiro>

    @Query(value = "select distinct pa.parceiro, pa.nome, pa.fantasia, pa.razao_social, pa.endereco, pa.latitude, pa.longitude,\n" +
            "pa.cep, pa.celular, pa.telefone, pa.complemento, pa.tipo_parceiro, pa.bairro, pa.codcidade, pa.municipio, pa.uf, pa.email_xml, pa.email,\n" +
            "pa.vendedor_do_parceiro\n" +
            "from parceiros pa\n" +
            "where pa.idn_cliente = 'S' and data_criacao_alteracao >= :data_hora_inicial", nativeQuery = true)
    fun getParceirosAtualizados(@Param("data_hora_inicial") dataHoraInicial: LocalDateTime): List<Parceiro>

    @Query(value = "select distinct pa.parceiro, pa.nome, pa.fantasia, pa.razao_social, pa.endereco, pa.latitude, pa.longitude,\n" +
            "pa.cep, pa.celular, pa.telefone, pa.complemento, pa.tipo_parceiro, pa.bairro, pa.codcidade, pa.municipio, pa.uf, pa.email_xml, pa.email,\n" +
            "pa.vendedor_do_parceiro\n" +
            "from parceiros pa\n" +
            "where pa.parceiro = :parceiro", nativeQuery = true)
    fun getParceiro(parceiro: Int): Parceiro?

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update parceiros pa set pa.nome = :nome, pa.email_xml = :email, pa.telefone = :telefone where pa.parceiro = :parceiro", nativeQuery = true)
    fun atualizarParceiro(
            @Param("parceiro") parceiro: Int,
            @Param("nome") nome: String,
            @Param("email") email: String,
            @Param("telefone") telefone: String
    )


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "insert into parceiros(" +
            "parceiro," +
            "nome," +
            "fantasia," +
            "razao_social," +
            "endereco," +
            "latitude," +
            "longitude," +
            "cep," +
            "celular," +
            "telefone," +
            "complemento," +
            "bairro," +
            "municipio," +
            "uf," +
            "codcidade," +
            "idnsaldoscc," +
            "idn_preco_custo_outras_saidas" +
            ")values(" +
            ":parceiro," +
            ":nome," +
            ":fantasia," +
            ":razao_social," +
            ":endereco," +
            ":latitude," +
            ":longitude," +
            ":cep," +
            ":celular," +
            ":telefone," +
            ":complemento," +
            ":bairro," +
            ":municipio," +
            ":uf," +
            ":codcidade," +
            ":idnsaldoscc," +
            ":idn_preco_custo_outras_saidas)", nativeQuery = true)
    fun insert(
            @Param("parceiro") parceiro: Int,
            @Param("nome") nome: String,
            @Param("fantasia") fantasia: String,
            @Param("razao_social") razaoSocial: String,
            @Param("endereco") endereco: String,
            @Param("latitude") latitude: String,
            @Param("longitude") longitude: String,
            @Param("cep") cep: String,
            @Param("celular") celular: String,
            @Param("telefone") telefone: String,
            @Param("complemento") complemento: String,
            @Param("bairro") bairro: String,
            @Param("municipio") municipio: String,
            @Param("uf") uf: String,
            @Param("codcidade") codigoCidade: Int,
            @Param("idnsaldoscc") idnSaldoCC: String,
            @Param("idn_preco_custo_outras_saidas") idnPrecoCustoOutrasSaidas: String)

    @Query(value = "Select coalesce(Max(parceiro)+1,0) as Maximo From Parceiros", nativeQuery = true)
    fun getCodigo(): Int

    @Query(value = "Select coalesce(Max(parceiro)+1,0) as Maximo From Parceiros\n" +
            " where ((tipo_parceiro = :tipo_parceiro))", nativeQuery = true)
    fun getCodigo(@Param("tipo_parceiro") tipoParceiro: Int): Int

    @Query(value = "select count(*) from parceiros pa where pa.parceiro =:parceiro and pa.codfilial_cadastro =:filial and\n" +
            "(pa.senha =:senha or (pa.senha is null) )", nativeQuery = true)
    fun checkConfig(@Param("parceiro") parceiro: Int, @Param("filial") filial: Int, @Param("senha") senha: String?): Int
}