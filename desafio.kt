enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, var duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome} foi matriculado na formação $nome.")
    }
}

fun main() {
    // Criando conteúdos educacionais
    val conteudoKotlin = ConteudoEducacional(nome = "Kotlin", duracao = 70)
    val conteudoJava = ConteudoEducacional(nome = "Java", duracao = 60)
    
    // Criando uma formação com a lista de conteúdos
    val formacaoProgramacao = Formacao(nome = "Programação", conteudos = listOf(conteudoKotlin, conteudoJava))
    
    // Criando um usuário
    val usuarioLeonardo = Usuario(nome = "Leonardo")
    
    // Matriculando o usuário na formação
    formacaoProgramacao.matricular(usuarioLeonardo)
    
    // Imprimindo os detalhes da formação e dos inscritos
    println(formacaoProgramacao)
    println("Inscritos: ${formacaoProgramacao.inscritos.joinToString { it.nome }}")
}
