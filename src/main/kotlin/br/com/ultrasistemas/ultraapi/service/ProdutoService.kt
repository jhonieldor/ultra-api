package br.com.ultra.apiws.service

import br.com.ultrasistemas.ultraapi.domain.Produto
import br.com.ultrasistemas.ultraapi.repository.ProdutoRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class ProdutoService(val produtoRepository: ProdutoRepository) {

    fun getProdutos(dataHoraInicial: LocalDateTime, vendedor: Int, filial: Int) =
            produtoRepository.getWSProdutos(dataHoraInicial, vendedor, filial, Arrays.asList(1,6,7))


    fun getProduto(vendedor: Int, filial: Int, codProduto: Int, codProdutoClas: Int): Produto {
        var dataHora = LocalDateTime.parse("1900-01-01T00:00:00.000Z", DateTimeFormatter.ISO_DATE_TIME)
        return produtoRepository.getWSProduto(dataHora, vendedor, filial, codProduto, codProdutoClas)
    }

}