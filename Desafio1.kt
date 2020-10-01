package Kotlin.Desafio1

fun main() {
    var aluno1 = Aluno("BethArley", "Rodrigues", 10)
    var aluno2 = Aluno("Sandra", "Araujo", 11)
    var aluno3 = Aluno("Daniel", "Sousa", 12)

    var professorT: Professor = ProfessorTitular("Lucas", "Silva", 5, 15, "Kotlin")
    var professorA: Professor = ProfessorAdjunto("Lucas", "Silva", 5, 16, 10)

    var cursoJava: Curso = Curso("JAVA", 1001, 2)
    var cursoKotlin: Curso = Curso("Kotlin", 1002, 2)
    var cursoPhp: Curso = Curso("PHP", 1003, 2)

    var digital: DigitalHouseManager = DigitalHouseManager()

    digital.registrarCurso(cursoJava.nome, cursoJava.codigo, cursoJava.maximoAlunos)
    digital.registrarCurso(cursoKotlin.nome, cursoKotlin.codigo, cursoKotlin.maximoAlunos)
    digital.registrarCurso(cursoPhp.nome, cursoPhp.codigo, cursoPhp.maximoAlunos)
    println( "CURSO REGISTRADOS: " + digital.listaCursos.size )

    digital.matricularAluno(aluno1.nome, aluno1.sobrenome, aluno1.codigo)
    digital.matricularAluno(aluno2.nome, aluno2.sobrenome, aluno2.codigo)
    digital.matricularAluno(aluno3.nome, aluno3.sobrenome, aluno3.codigo)

    digital.matricularAluno(aluno1.codigo, cursoJava.codigo)
    digital.matricularAluno(aluno2.codigo, cursoKotlin.codigo)
    digital.matricularAluno(aluno3.codigo, cursoPhp.codigo)


    //digital.excluirCurso(1003)
    println( "CURSO REGISTRADOS: " + digital.listaCursos.size )

    digital.registrarProfessorAdjunto("Lucas", "Silva", 105, 50)
    digital.registrarProfessorTitular("Felipe", "Silva", 104, "Mobile")
    digital.registrarProfessorTitular("Rosi", "Silva", professorT.codigo, "Mobile")
    digital.registrarProfessorTitular("Carla", "Silva", professorA.codigo, "Mobile")


    digital.excluirProfessor(15)

    digital.alocarProfessores(1001, 104, 105)


}