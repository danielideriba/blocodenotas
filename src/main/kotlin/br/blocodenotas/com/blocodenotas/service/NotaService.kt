package br.blocodenotas.com.blocodenotas.service

import br.blocodenotas.com.blocodenotas.model.Nota
import br.blocodenotas.com.blocodenotas.repository.NotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

@Service
class NotaService{

    @Autowired
    lateinit var notaRepository: NotaRepository

    fun salvar(nota: Nota) : Nota{
        return notaRepository.save(nota)
    }

    fun buscarTodos() : List<Nota>{
        return notaRepository.findAll()
    }

    fun apagar(id: String){
        notaRepository.deleteById(id)
    }

    fun buscarPor(id: String): Nota{
        return notaRepository.findById(id).get()
    }

    fun buscarPorTitulo(titulo: String): List<Nota>{
        return notaRepository.findByTituloContaining(titulo)
    }
}