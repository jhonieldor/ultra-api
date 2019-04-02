package br.com.ultrasistemas.ultraapi.rest_controllers

import br.com.ultrasistemas.ultraapi.ParceiroService
import br.com.ultrasistemas.ultraapi.domain.Parceiro
//import br.com.ultra.apiws.domain.StatusConsultor
//import br.com.ultra.apiws.service.ConsultorService
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@RestController
class ParceiroRestController(val parceiroService: ParceiroService) {

    @RequestMapping("/api-ultra-ws/parceiros", method = arrayOf(RequestMethod.GET))
    fun parceiros(): StatusResponse {
//        var statusConsultor: StatusConsultor? = consultorService.checkDadosConsultor(consultor, if (senha?.isEmpty()) null else senha)
//        if (statusConsultor?.valid!!) {
        var result: List<Parceiro>? = parceiroService?.getParceiros()
        return StatusResponse(true, "OK", result, result?.size)

//        } else {
//            return StatusResponse(false, statusConsultor!!.descricao!!)
//        }
    }

//    @RequestMapping("/api-ultra-ws/parceirosAtualizados", method = arrayOf(RequestMethod.GET))
//    fun parceiros(@RequestHeader("consultor") consultor: Int,
//                  @RequestHeader("senha") senha: String,
//                  @RequestParam("dataHora") dataHora: String): Any {
//        println("/api-ultra-ws/parceirosAtualizados")
//        println("dataHora: " + dataHora)
//        var statusConsultor: StatusConsultor? = consultorService.checkDadosConsultor(consultor, if (senha?.isEmpty()) null else senha)
//        if (statusConsultor?.valid!!) {
//            var result: List<Parceiro> =  parceiroService?.getParceirosAtualizados(LocalDateTime.parse(dataHora, DateTimeFormatter.ISO_DATE_TIME))
//            return StatusResponse(true, "OK", result, result.size)
//        } else {
//            return StatusResponse(false, statusConsultor?.descricao!!)
//        }
//    }

//    @RequestMapping("/api-ultra-ws/parceiros/findById", method = arrayOf(RequestMethod.GET))
//    fun parceiros(@RequestHeader("consultor") consultor: Int,
//                  @RequestHeader("senha") senha: String,
//                  @RequestParam("parceiro") codigo: Int): Any {
//        var statusConsultor: StatusConsultor? = consultorService.checkDadosConsultor(consultor, if (senha?.isEmpty()) null else senha)
//        if (statusConsultor?.valid!!) {
//            var result = parceiroService?.getParceiro(codigo)
//            return StatusResponse(true, "OK", result )
//        } else {
//            return StatusResponse(false, statusConsultor?.descricao!!)
//        }
//    }

    @RequestMapping("/api-ultra-ws/tiposParceiros", method = arrayOf(RequestMethod.GET))
    fun tiposParceiros() = parceiroService?.getParceiros()

//    @RequestMapping("/api-ultra-ws/checkServerConfig", method = arrayOf(RequestMethod.GET))
//    fun checkServerConfig(@RequestParam("parceiro") parceiro: Int,
//                          @RequestParam("filial") filial : Int,
//                          @RequestParam("senha") senha: String?) = parceiroService?.checkServerConfig(parceiro, filial, senha)


}