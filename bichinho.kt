fun main(){
    println("\n Olá, eu sou a Tina. Bem-vindo ao simulador de animal de estimação!")
    println("\n Escolha a opção abaixo!")
    val bichinho= bichinho()

    while (true){
        println("\n Menu")
        println("\n 1. Alimentar")
        println("\n 2. Brincar")
        println("\n 3. Descansar")
        println("\n 4. Status")
        println("\n 5. Tempo")
        println("\n 6. Sair")
        val escolha = readLine()?.toIntOrNull() ?:continue
        when(escolha){
            1-> bichinho.alimentar()
            2-> bichinho.brincar()
            3-> {
                print("Quanto tempo de descanso? ")
                val horas = readLine()?.toIntOrNull() ?: 0
                bichinho.descansar(horas)
            }
            4->  bichinho.status()
            5 -> bichinho.tempo()
            6 -> {
                println("Sai logo! Até a próxima.")
                return
            }else -> println("Opção inválida.Tente outra vez.")
        }
    }
} class bichinho(
    val nome: String = "Theo",
    var fome: Int = 50,
    var felicidade: Int = 100,
    var cansaço: Int = 0,
    var idade: Int = 0,
    var sujeira: Int = 0,
    var banheiro: Int = 0
) {
    fun alimentar(){
        if (fome<100){
            fome+=10
            felicidade+=10
            banheiro+=20
            println("\n $nome já comeu! Nível de fome:$fome")
            println("\n $nome está feliz! Nível de felicidade:$felicidade")
            println("\n $nome quer ir ao banheiro! Nível de vontade:$banheiro")
        }else{
            println(" $nome já comeu bastante!")
        }
    }
    fun brincar(){
        if (felicidade>100) felicidade=100
        if (cansaço>100) cansaço=100
        if (sujeira>100) sujeira=100
        felicidade+=10
        cansaço+=15
        sujeira+=20
        println("\n $nome já brincou! Nível de felicidade:$felicidade, Nível de cansaço:$cansaço, Nível de sujeira:$sujeira")
    }
    fun descansar(horas:Int){
        cansaço-=horas*10
        if (cansaço<0) cansaço=0
        println("\n $nome foi descansar por $horas horas")
        println("\n $nome está cansado ainda! Nivel de cansaço:$cansaço")
    }
    fun status(){
        println("\n Verificar status!")
        println("\n Status nome :$nome ")
        println("\n Fome : $fome")
        println("\n Felicidade : $felicidade")
        println("\n Cansaço : $cansaço")
        println("\n Idade : $idade")
        println("\n Sujeira : $sujeira")
        println("\n Banheiro : $banheiro")
    }
    fun tempo(){
        fome+=3
        felicidade-=3
        cansaço+=10
        idade+=1
        if (felicidade<=0||fome>=100||cansaço>=100){
            println("\n Você já atingiu o limite cai fora!")
            return
        }
        println("Você já está velho! Sua idade é: $idade, Fome:$fome, Felicidadee:$felicidade, Cansaço:$cansaço")
    }
}