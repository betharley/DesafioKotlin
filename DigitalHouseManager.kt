package Kotlin.Desafio1

import java.time.LocalDateTime

class DigitalHouseManager{
    var listaAlunos: ArrayList<Aluno> = ArrayList<Aluno>()
    var listaProfessores: ArrayList<Professor> = ArrayList<Professor>()
    var listaCursos: ArrayList<Curso> = ArrayList<Curso>()
    var listaMatriculas: ArrayList<Matricula> = ArrayList<Matricula>()


    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int){
        var curso: Curso = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos)

        println("O curso ${curso.nome} com codigo ${curso.codigo}, com maximo de ${curso.maximoAlunos} alunos")
        this.listaCursos!!.add( curso )
    }

    fun excluirCurso(codigoCurso: Int){
        for ( curso in this.listaCursos ) {
            if ( curso.codigo == codigoCurso ){
                println("O curso de ${curso.nome} foi excluido.")
                listaCursos.remove( curso )
                break
            }
        }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String,
        codigoProfessor: Int, quantidadeDeHoras: Int){

        var professor: Professor = ProfessorAdjunto(nome, sobrenome, 10, codigoProfessor, quantidadeDeHoras)
        listaProfessores.add( professor )

        println("O professor ${professor.nome} é Adjunto foi registrado.")
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String ,
                                  codigoProfessor: Int, especialidade: String ){
        var professor: Professor = ProfessorTitular(nome, sobrenome, 10, codigoProfessor, especialidade)
        println("O professor ${professor.nome} é Titular foi registrado.")

        listaProfessores.add( professor )
    }

    fun excluirProfessor(codigoProfessor: Int){
//        listaProfessores.forEach {
//            if ( it.codigo == codigoProfessor ){
//                listaProfessores.remove( it )
//                println("O professor ${it.nome} foi removido com sucesso.")
//            }
//        }
        for ( professor in this.listaProfessores){
            if ( professor.codigo.equals(codigoProfessor) ){
                listaProfessores.remove( professor )
                println("O professor ${professor.nome} foi removido com sucesso.")
                break
            }
            //println("EXCLUSÃO DE PROFESSOR: ${professor.codigo}")
        }
        println("Quantidade de Professores: ${listaProfessores.size}")

    }

    fun matricularAluno(nome: String , sobrenome: String , codigoAluno: Int){
        var aluno: Aluno = Aluno(nome, sobrenome, codigoAluno)
        println("O aluno ${aluno.nome} foi matriculado com sucesso.")
        listaAlunos.add( aluno )
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){

        var alunoEncontrado: Aluno? = null
        var cursoEncontrado: Curso? = null

        listaAlunos.forEach {
            if (it.codigo == codigoAluno){
                alunoEncontrado = it
            }
        }
//        listaCursos.forEach {
//            if ( it.codigo == codigoCurso ){
//                cursoEncontrado = it
//            }
//        }
        for ( curso in listaCursos ){
            if ( curso.codigo == codigoCurso ){
                cursoEncontrado = curso
                println("CURSO ENCONTRADO COM SUCESSO .... ${curso.nome}")
            }
            //println("LOOP ${curso.codigo}, ${codigoCurso}")
        }

        var quantidadeMatriculados = 0
        listaMatriculas.forEach {
            if ( it.curso.codigo == codigoCurso ){
                quantidadeMatriculados++
            }
            //println("LOOP MATRICULAS, codigo do curso ${it.curso.codigo}, parametro ${codigoCurso}, Matriculas realizadas ${listaMatriculas.size}")
        }
        if ( alunoEncontrado != null  && cursoEncontrado != null ){
            if ( quantidadeMatriculados < cursoEncontrado!!.maximoAlunos ){

            var dataMatricula = LocalDateTime.now()
            var matricula: Matricula = Matricula(alunoEncontrado!!, cursoEncontrado!!, dataMatricula )

            listaMatriculas.add( matricula )
            println(">>> O aluno ${alunoEncontrado!!.nome} foi Matriculado com Sucesso no curso ${cursoEncontrado!!.nome}")
            }
        }else{
            println("Erro ao matricular aluno no curso...")
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        var professorTitular: Professor? = null
        var professorAdjunto: Professor? = null
        var cursoEncontrado: Curso? = null

//        listaProfessores.forEach {
//            if ( it.codigo == codigoProfessorTitular )
//                professorTitular = it
//            if ( it.codigo == codigoProfessorAdjunto )
//                professorAdjunto = it
//        }
        for ( professor in this.listaProfessores){
            if ( professor.codigo == codigoProfessorTitular)
                professorTitular = professor

            if ( professor.codigo == codigoProfessorAdjunto)
                professorAdjunto = professor
        }
        for ( curso in this.listaCursos){
            if ( codigoCurso == curso.codigo)
                cursoEncontrado = curso
        }
        if ( professorTitular != null && professorAdjunto != null && cursoEncontrado != null ) {
            //val curso = Curso("", codigoCurso, professorTitular as ProfessorTitular, professorAdjunto as ProfessorAdjunto, 50, this.listaAlunos) }
            listaCursos.add(  Curso(cursoEncontrado.nome, codigoCurso, professorTitular as ProfessorTitular, professorAdjunto as ProfessorAdjunto, 50, this.listaAlunos) )
            println("O Curso ${cursoEncontrado.nome}, Titular ${professorTitular!!.nome} e Adjunto ${professorAdjunto.nome} foram matriculados com sucesso.")
        }

    }


}












