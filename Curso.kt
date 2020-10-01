package Kotlin.Desafio1

import java.util.*
import kotlin.collections.ArrayList

//Propriedades: nome do curso, código do curso, professor titular,
//professor adjunto, quantidade máxima de alunos, lista de alunos
//matriculados

class Curso {
    var nome: String = ""
    var codigo: Int = -1
    var titular: ProfessorTitular? = null
    var adjunto: ProfessorAdjunto? = null
    var maximoAlunos: Int = 0
    var listaAlunos: ArrayList<Aluno> = ArrayList<Aluno>()

    constructor(nome: String,
                codigo: Int,
                titular: ProfessorTitular,
                adjunto: ProfessorAdjunto,
                maximoAlunos: Int,
                listaAlunos: ArrayList<Aluno>){

    }
    constructor(nome: String, codigo: Int, maximoAlunos: Int){
        this.nome = nome
        this.codigo = codigo
        this.maximoAlunos = maximoAlunos
    }

    fun adicionarUmAluno( aluno: Aluno): Boolean{
        if ( listaAlunos.size < maximoAlunos){
            listaAlunos.add( aluno)
            println("Aluno adicionado. Tamanho da lista ${listaAlunos.size}")
            return true
        }
        println("Aluno NÃO adicionado. Tamanho da lista ${listaAlunos.size}")
        return false
    }

    fun excluirAluno(aluno: Aluno){
        var remocao = listaAlunos.remove( aluno )
        if ( remocao ){
            println("Aluno ${aluno.nome} removido da list acom sucesso...")
        }else{
            println("Aluno ${aluno.nome} não encontrado na lista...")
        }
    }
}