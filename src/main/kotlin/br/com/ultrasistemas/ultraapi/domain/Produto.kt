package br.com.ultrasistemas.ultraapi.domain

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "PRODUTOS")
@IdClass(ProdutoPK::class)
class Produto {

    @Id
    @Column(name = "CODPRODUTO")
    var produto: Int = 0

    @Id
    @Column(name = "CODPRODUTO_CLAS")
    var classificacao: Int = 0

    @Column(name = "DSCPRODUTO")
    var descricaoProduto: String = ""

    @Column(name = "DSCPRODUTO_CLAS")
    var descricaoClassificacao: String? = null

    @Column(name = "CUSTO")
    var custo: Double? = null

    @Column(name = "MARCA")
    var marca: String? = null

    @Column(name = "UND_MEDIDA")
    var unidadeMedida: String? = null

    @Column(name = "IDNGRADE")
    var idnGrade: String? = null

    @Column(name = "LINHA")
    var linha: String? = null

    @Column(name = "COLUNA")
    var coluna: String? = null

    @Column(name = "PRECO")
    var preco: Double? = null

    @Column(name = "QTD_ESTOQUE")
    var qtdEstoque: Double? = null

    @Column(name = "CODGRUPO_NIVEL1")
    var grupoNivel1: Int? = null

    @Column(name = "CODGRUPO_NIVEL2")
    var grupoNivel2: Int? = null

    @Column(name = "CODGRUPO_NIVEL3")
    var grupoNivel3: Int? = null

    @Column(name = "GRUPO_FISCAL")
    var grupoFiscal: Int? = null

    @Column(name = "SUSPENDER_PEDIDOS")
    var suspenderPedidos: String? = null

    @Column(name = "DATA_BAIXA")
    var dataBaixa: Date? = null

    @Column(name = "IDN_REVENDA")
    var idnRevenda: String? = null

    @Column(name = "DSCGRUPO_NIVEL1")
    var descricaoGrupo1: String = ""

    @Column(name = "DSCGRUPO_NIVEL2")
    var descricaoGrupo2: String? = null

    @Column(name = "IDN_FORA_LINHA")
    var idnForaLinha: String? = null

    @Column(name = "REF_FABRICA")
    var referenciaFabrica: String? = null

    @Column(name = "CODBARRAS")
    var codigoBarras: String? = null

    @Column(name = "PRECO_MINIMO")
    var precoMinimo: Double? = null

    @Column(name = "OBS")
    var observacao: String? = null

    @Column(name = "MARCKUP_MIN")
    var marckupMinimo: Double? = null

    @Column(name = "MARCKUP_PADRAO")
    var marckupPadrao: Double? = null

    @Column(name = "PESO_PRODUTO")
    var pesoProduto: Double? = null

    @Column(name = "PESO_EMBALAGEM")
    var pesoEmbalagem: Double? = null

    @Column(name = "TIPO")
    var tipo: Int? = null

    @Column(name = "DSC_TIPO")
    var nomeTipo: String? = null

    constructor()

    constructor(produto: Int, classificacao: Int, descricaoProduto: String, descricaoClassificacao: String, custo: Double, marca: String,
                unidadeMedida: String, idnGrade: String, linha: String, coluna: String, preco: Double, qtdEstoque: Double, grupoNivel1: Int,
                grupoNivel2: Int, grupoNivel3: Int, grupoFiscal: Int, suspenderPedidos: String, descricaoGrupo1: String, descricaoGrupo2: String,
                idnForaLinha: String, referenciaFabrica: String, codigoBarras: String, precoMinimo: Double, observacao: String, marckupMinimo: Double,
                marckupPadrao: Double, pesoProduto: Double, pesoEmbalagem: Double, tipo: Int, nomeTipo: String ) {
        this.produto = produto
        this.classificacao = classificacao
        this.descricaoProduto = descricaoProduto
        this.descricaoClassificacao = descricaoClassificacao
        this.custo = custo
        this.marca = marca
        this.unidadeMedida = unidadeMedida
        this.idnGrade = idnGrade
        this.linha = linha
        this.coluna = coluna
        this.preco = preco
        this.qtdEstoque = qtdEstoque
        this.grupoNivel1 = grupoNivel1
        this.grupoNivel2 = grupoNivel2
        this.grupoNivel3 = grupoNivel3
        this.grupoFiscal = grupoFiscal
        this.suspenderPedidos = suspenderPedidos
        this.descricaoGrupo1 = descricaoGrupo1
        this.descricaoGrupo2 = descricaoGrupo2
        this.idnForaLinha = idnForaLinha
        this.referenciaFabrica = referenciaFabrica
        this.codigoBarras = codigoBarras
        this.precoMinimo = precoMinimo
        this.observacao = observacao
        this.marckupMinimo = marckupMinimo
        this.marckupPadrao = marckupPadrao
        this.pesoProduto = pesoProduto
        this.pesoEmbalagem = pesoEmbalagem
        this.tipo = tipo
        this.nomeTipo = nomeTipo
    }

    override fun toString(): String {
        return "Produto(produto=$produto, classificacao=$classificacao, descricaoProduto='$descricaoProduto', descricaoClassificacao=$descricaoClassificacao, custo=$custo, marca=$marca, unidadeMedida=$unidadeMedida, idnGrade=$idnGrade, linha=$linha, grade=$coluna, preco=$preco, qtdEstoque=$qtdEstoque, grupoNivel1=$grupoNivel1, grupoNivel2=$grupoNivel2, grupoNivel3=$grupoNivel3, grupoFiscal=$grupoFiscal, suspenderPedidos=$suspenderPedidos, dataBaixa=$dataBaixa, idnRevenda=$idnRevenda, descricaoGrupo1='$descricaoGrupo1', descricaoGrupo2=$descricaoGrupo2, idnForaLinha=$idnForaLinha, referenciaFabrica=$referenciaFabrica, codigoBarras=$codigoBarras, precoMinimo=$precoMinimo, observacao=$observacao," +
                " marckupMinimo=$marckupMinimo, marckupPadrao=$marckupPadrao, pesoProduto=$pesoProduto, pesoEmbalagem=$pesoEmbalagem, " +
                " tipo=$tipo, nomeTipo=$nomeTipo)"
    }


}


