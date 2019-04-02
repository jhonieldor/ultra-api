package br.com.ultrasistemas.ultraapi

//import br.com.ultra.apiws.repository.TipoParceiroRepository
import br.com.ultrasistemas.ultraapi.domain.Parceiro
import br.com.ultrasistemas.ultraapi.infrastructure.db.StatusDBService
import br.com.ultrasistemas.ultraapi.repository.ParceiroRepository
import org.hibernate.exception.GenericJDBCException
import org.springframework.orm.jpa.JpaSystemException
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class ParceiroService(
        val parceiroRepository: ParceiroRepository,
        val statusDBService: StatusDBService

) {

    fun getParceiros(): List<Parceiro>? {
        try {
            return parceiroRepository.getParceiros()
        } catch (e: GenericJDBCException) {
            println("Erro: " + e.toString())
            e.printStackTrace()
            statusDBService.setDbStatusOff()
            return null
        } catch (jpaException: JpaSystemException) {
            println("Erro: " + jpaException.toString())
            jpaException.printStackTrace()
            statusDBService.setDbStatusOff()
            return null
        }
    }

    fun getParceirosAtualizados(dataHoraInicial: LocalDateTime) = parceiroRepository.getParceirosAtualizados(dataHoraInicial)

    fun getParceiro(codigo: Int): Parceiro? = parceiroRepository.findById(codigo)?.get()

    fun atualizarParceiro(parceiro: Parceiro) {
        try {
            parceiroRepository.atualizarParceiro(parceiro.id, parceiro.nome, parceiro.email, parceiro.telefone)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

//    fun getTiposParceiros() = tipoParceiroRepository.getTiposParceiros()

    fun checkServerConfig(parceiro: Int, filial: Int, senha: String?) = parceiroRepository.checkConfig(parceiro, filial, senha)
}