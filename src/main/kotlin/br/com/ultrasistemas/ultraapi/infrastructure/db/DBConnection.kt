package br.com.ultrasistemas.ultraapi.infrastructure.db


import org.apache.tomcat.jdbc.pool.DataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.sql.SQLException

@Configuration
@EnableTransactionManagement
@Component
class DBConnection {

    private var db: DB? = null

    private var dataSource: DataSource? = null

    private var jdbcTemplate: JdbcTemplate? = null

    private var refused: Boolean = false

//    private var started : Boolean = false
    private var attempts: Int = 0

    @Bean
    fun createDataSource(): DataSource? {

        try {
            dataSource = DataSource()
            jdbcTemplate = JdbcTemplate()

            this.setDBConfig()

            setDataSource(this.db!!)

            return dataSource!!
        }catch (e: Exception){
            println("Problema na conexão com o banco!")
            e.printStackTrace()
            this.refused = true
            return null
        }

    }


    fun setDataSource(db: DB) {
//        this.db = db
        dataSource!!.close()
        dataSource!!.setDriverClassName("org.firebirdsql.jdbc.FBDriver")

        dataSource!!.setUrl(db.url)
        dataSource!!.setUsername(db.username)
        dataSource!!.setPassword(db.password)

        println("Criando pool de conexão...")
        try {
            dataSource!!.createPool()
            this.refused = false
//            this.started = true
        } catch (e: SQLException) {
            println("Não foi possível criar o pool de conexão!\nErro: " + e.message)
            this.refused = true

            this.attempts++

            while(refused && attempts < 10){
                reset()
            }

//            e.printStackTrace()
        }

    }

    fun reset(){
        println("Resetando conexão do banco")
        this.setDBConfig()
        this.setDataSource(this.db!!)
    }

    fun isRefused(): Boolean{
        return this.refused
    }

    @Scheduled(fixedDelay = 5000)
    fun checkStatus(){

        if(this.refused){
            println("Verificando o status de conexão, pois foi recusada anteriormente...")
            reset()
        }
    }


    fun setDBConfig() {
        val lines = Files.readAllLines(Paths.get("BD.Conf"), StandardCharsets.UTF_8)
        val configurationMap = hashMapOf<String, Any>()
        for (line in lines) {
            val value = line.split("=")[0]
            println("value:" + value)
            var default: Boolean = false
            if (value.equals("Default")) {
                default = line.split("=")[1].trim().equals("Sim")
            }

            when (value) {
                "Servidor" -> configurationMap.put("Servidor", line.split("=")[1])
                "Caminho" -> configurationMap.put("Caminho", line.split("=")[1])
                "Default" -> configurationMap.put("Default", line.split("=")[1])
            }
            if (default) {
                break
            }

        }

        var dbURL = "jdbc:firebirdsql:${configurationMap.get("Servidor").toString()}/3050:" +
                "${configurationMap.get("Caminho").toString()}?encoding=ISO8859_1"

        println("Conectando no banco ${dbURL}")

        this.db = DB(dbURL, "Banco Local", "SYSDBA", "masterkey")
    }
}