package br.blocodenotas.com.blocodenotas.controller

import br.blocodenotas.com.blocodenotas.model.Nota
import br.blocodenotas.com.blocodenotas.service.NotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/nota")
class NotaController{
    @Autowired
    lateinit var notaService: NotaService

    @GetMapping("/check")
    fun checkHealth() : String {
        return "ok"
    }

    @GetMapping
    fun buscarTodos() : List<Nota>{
        return notaService.buscarTodos()
    }

    @PostMapping
    fun salvar(@RequestBody nota: Nota) : Nota {
        return notaService.salvar(nota)
    }

    @DeleteMapping("/{id}")
    fun apagar(@PathVariable("id") id: String){
        notaService.apagar(id)
    }

    @GetMapping("/busca/{id}")
    fun buscar(@PathVariable("id") id: String): Nota {
        return notaService.buscarPor(id)
    }

    @GetMapping("/buscatitulo/{titulo}")
    fun buscarPorTitulo(@PathVariable("titulo") titulo: String): List<Nota> {
        return notaService.buscarPorTitulo(titulo)
    }
}