package br.com.ultrasistemas.ultraapi.domain
import br.com.ultrasistemas.ultraapi.domain.Cidade
import br.com.ultrasistemas.ultraapi.domain.TipoParceiro
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "PARCEIROS")
class Parceiro {
    @Id
    @Column(name = "PARCEIRO")
    var id: Int = 0

    @Column(name = "NOME")
    var nome: String = ""

    @Column(name = "FANTASIA")
    var fantasia: String = ""

    @Column(name = "RAZAO_SOCIAL")
    var razaoSocial: String = ""

    @Column(name = "ENDERECO")
    var endereco: String = ""

    @Column(name = "LATITUDE")
    var latitude: String = ""

    @Column(name = "LONGITUDE")
    var longitude: String = ""

    @Column(name = "CEP")
    var cep: String = ""

    @Column(name = "CELULAR")
    var celular: String = ""

    @Column(name = "TELEFONE")
    var telefone: String = ""

    @Column(name = "COMPLEMENTO")
    var complemento: String = ""

    @Column(name = "BAIRRO")
    var bairro: String = ""

    @Column(name = "MUNICIPIO")
    var municipio: String = ""

    @Column(name = "UF")
    var uf: String = ""

    @Column(name = "EMAIL_XML")
    var email: String = ""

    @Column(name = "EMAIL")
    var emailCopia: String = ""

    @Column(name = "VENDEDOR_DO_PARCEIRO")
    var vendedor: Int? = null


    @ManyToOne
    @JoinColumn(name = "CODCIDADE", referencedColumnName = "CODIGO")
    var cidade: Cidade? = null

    @ManyToOne
    @JoinColumn(name = "TIPO_PARCEIRO", referencedColumnName = "TIPO_PARCEIRO")
    var tipoParceiro: TipoParceiro? = null

    constructor()


    constructor(
            id: Int,
            nome: String,
            fantasia: String,
            razaoSocial: String,
            endereco: String,
            latitude: String,
            longitude: String,
            cep: String,
            celular: String,
            telefone: String,
            complemento: String,
            bairro: String,
            cidade: Cidade?,
            tipoParceiro: TipoParceiro?,
            municipio: String,
            uf: String,
            email: String,
            emailCopia: String
    ) {
        this.id = id
        this.nome = nome
        this.fantasia = fantasia
        this.razaoSocial = razaoSocial
        this.endereco = endereco
        this.latitude = latitude
        this.longitude = longitude
        this.cep = cep
        this.celular = celular
        this.telefone = telefone
        this.complemento = complemento
        this.bairro = bairro
        this.cidade = cidade
        this.municipio = municipio
        this.tipoParceiro = tipoParceiro
        this.uf = uf
        this.email = email
        this.emailCopia = emailCopia

    }


    constructor(id: Int, nome: String, telefone: String, email: String) {
        this.id = id
        this.nome = nome
        this.telefone = telefone
        this.email = email
    }



    constructor(id: Int, nome: String, telefone: String, email: String, cidade: Cidade?) {
        this.id = id
        this.nome = nome
        this.telefone = telefone
        this.email = email
        this.cidade = cidade
    }




    override fun toString(): String {
        return "Parceiro(id=$id, nome='$nome', fantasia='$fantasia', razaoSocial='$razaoSocial', endereco='$endereco', latitude='$latitude', longitude='$longitude', cep='$cep', celular='$celular', telefone='$telefone', complemento='$complemento', bairro='$bairro', municipio='$municipio', uf='$uf', email='$email', emailCopia='$emailCopia', cidade=$cidade, tipoParceiro=$tipoParceiro)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Parceiro

        if (endereco != other.endereco) return false
        if (celular != other.celular) return false
        if (telefone != other.telefone) return false
        if (email != other.email) return false

        return true
    }

    public fun equalsVisita(other: Parceiro?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Parceiro

        if (nome != other.nome) return false
        if (telefone != other.telefone) return false
        if (email != other.email) return false

        return true
    }

    fun equalsCidade(other: Parceiro?): Boolean{
        return this.cidade?.id!!.equals(other?.cidade?.id)
    }


    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + endereco.hashCode()
        result = 31 * result + celular.hashCode()
        result = 31 * result + telefone.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }

}
