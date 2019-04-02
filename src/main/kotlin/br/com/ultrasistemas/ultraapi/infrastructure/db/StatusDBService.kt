package br.com.ultrasistemas.ultraapi.infrastructure.db

import br.com.ultrasistemas.ultraapi.domain.Parceiro
import br.com.ultrasistemas.ultraapi.repository.ParceiroRepository
import org.hibernate.exception.GenericJDBCException
import org.springframework.orm.jpa.JpaSystemException
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class StatusDBService(val parceiroRepository: ParceiroRepository,
                      val dbConnection: DBConnection){

    private var dbOff = false

    @Scheduled(fixedDelay = 5000)
    fun checkConnection(){

        if(this.dbOff && !this.dbConnection.isRefused()){
            println("Verificando status do servidor Firebird")
            try {
                var parceiros: List<Parceiro> = parceiroRepository.getParceiros()
                dbOff = false
            }catch (e : GenericJDBCException){
                println("Servidor está fora, tentando reiniciar conexão")
//                e.printStackTrace()
                dbConnection.reset()
            }catch (e : JpaSystemException) {
                println("Servidor está fora, tentando reiniciar conexão")
//                e.printStackTrace()
                dbConnection.reset()
            }
        }


    }

    fun setDbStatusOff(){
        this.dbOff = true
    }


}