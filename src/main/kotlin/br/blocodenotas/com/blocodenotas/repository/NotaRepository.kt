package br.blocodenotas.com.blocodenotas.repository

import br.blocodenotas.com.blocodenotas.model.Nota
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NotaRepository : MongoRepository<Nota, String>{
    fun findByTituloContaining(titulo: String) : List<Nota>
}