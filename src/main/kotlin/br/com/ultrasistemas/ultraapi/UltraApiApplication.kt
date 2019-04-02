package br.com.ultrasistemas.ultraapi

import org.hibernate.HibernateException
import org.springframework.beans.factory.BeanCreationException
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling
import java.net.ConnectException
import java.sql.SQLException
import java.sql.SQLNonTransientConnectionException

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("br.com.ultrasistemas.ultraapi")
@EntityScan("br.com.ultrasistemas.ultraapi")
@EnableScheduling
class UltraApiApplication

fun main(args: Array<String>) {
	try{
		runApplication<UltraApiApplication>(*args)
	}catch (e: BeanCreationException){
		println("Erro na inicialização da API")
		println(e.toString())
//		e.printStackTrace()
	}

}
