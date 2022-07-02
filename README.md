# VAR do Java 10
## Pontos Principais
#### 1. O Java 10 introduziu o recurso de inferência de tipos para variáveis locais. Agora é possível declarar variáveis locais com o tipo especial "var", ao invés da definição de tipo atual;
#### 2. Esse recurso foi implementado para aperfeiçoar a linguagem Java e estender a inferência de tipos para declarações de variáveis locais com inicializadores. Isso reduz o código repetitivo, enquanto mantém a verificação dos tipos do Java em tempo de compilação;
#### 3. Como o compilador precisa inferir o tipo da "var" observando a atribuição feita no lado direito, esse recurso tem algumas limitações, como ao inicializar Arrays e Streams;

## Introdução
#### O Java 10 introduziu o recurso de inferência de tipos para variáveis locais. Agora é possível declarar variáveis com o tipo especial "var", ao invés da definição do tipo específico, como demonstrado no exemplo a seguir:
````
var name = “Mohamed Taman”;
````
#### Esse recurso foi implementado para aperfeiçoar a linguagem Java e estender a inferência de tipos para declarações de variáveis ​​locais com inicializadores. Isso reduz o código repetitivo, enquanto mantém a verificação dos tipos em tempo de compilação.

#### Como o compilador precisa inferir o tipo real do "var" olhando para a atribuição feita no lado direito (Right-Hand Side - RHS), esse recurso tem limitações em alguns casos, que será abordado mais adiante. Vejamos alguns exemplos simples agora.

#### Para executar os exemplos escolha seu IDE favorito que suporta Java SE 10, como o Apache NetBeans 9, o IntelliJ IDEA 2018 ou o novo Eclipse.

#### Pessoalmente, prefiro usar uma ferramenta de ambiente de programação interativa, para aprender rapidamente a sintaxe da linguagem Java, explorar novas APIs e seus recursos, e até para prototipar códigos complexos. Isto é, ao invés do tedioso ciclo de edição, compilação e execução de código, que normalmente envolve o seguinte processo:

#### 1. Escreva um programa completo;
#### 2. Compile e corrija qualquer erro;
#### 3. Execute o programa;
#### 4. Descobrir o que está errado com isso;
#### 5. Edite-o;
#### 6. Repita o processo.
#### A grande novidade é a ferramenta JShell integrada e fornecida com o Java SE JDK desde o Java SE 9, que era um dos recurso principais desta versão.

## O que é JShell
Agora, o Java tem uma implementação de REPL (Read-Evaluate-Print-Loop) com a ferramenta JShell, também chamada de Java Shell como um ambiente de programação interativo. O JShell fornece um ambiente rápido e amigável que permite explorar, descobrir e experimentar rapidamente os recursos da linguagem Java e suas diversas bibliotecas.

Usando o JShell é possível inserir elementos do programa um de cada vez, ver imediatamente o resultado e fazer ajustes conforme necessário. Portanto, o JShell substitui o tedioso ciclo de edição, compilação e execução com o loop de leitura-avaliação-impressão. Em vez de programas completos, no JShell são escritos comandos JShell e trechos de código Java.

Ao inserir um trecho de código, o JShell imediatamente lê, avalia e imprime seus resultados. Em seguida, ele faz um loop para executar esse processo novamente para o próximo trecho de código. Assim, o JShell e seu feedback instantâneo mantêm sua atenção, aprimoram seu desempenho e aceleram os processos de aprendizado e desenvolvimento de software.

Para a execução desse tutorial, essa introdução sobre o JShell é o suficiente, caso queira conhecer mais o InfoQ publicou uma introdução completa da ferramenta.
Agora, vamos ver alguns exemplos rápidos para entender o que pode ser feito com o tipo var usando o JShell.

## Software necessário
Para trabalhar com o JShell, utilize o Java SE ou o JDK 10+ e configure para que as ferramentas que estão na pasta bin do JDK possam ser acessadas a partir de qualquer lugar do sistema.

## Iniciando uma sessão no JShell
Para iniciar uma sessão no JShell:

#### 1. No Microsoft Windows abra o Prompt de Comando, digite jshell e pressione Enter;
#### 2. No Linux, abra uma janela de shell, digite jshell e pressione Enter;
#### 3. No macOS (antigo OS X), abra uma janela de Terminal, digite jshell e pressione Enter.
Esse comando executa uma nova sessão do JShell e exibe essa mensagem no prompt jshell>:
````
|  Welcome to JShell -- Version 10.0.1
|  For an introduction type: /help intro
jshell>
````
## Trabalhando com o tipo "var"
Com o JDK 10+ instalado, vejamos alguns exemplos do uso do tipo "var" no JShell. Para executar os exemplos digite cada um dos trechos no prompt do jshell. Se prestar atenção no código, parece que há algo errado, já que não há ponto-e-vírgula. Experimente e veja se funciona ou não.

Caso de inferência de tipo simples
No exemplo a seguir, temos um uso básico do tipo var, o compilador pode inferir o RHS como um literal String:
````
var name = "Mohamed Taman"
var lastName = str.substring(8)
System.out.println("Value: "+lastName +" ,and type is: "+ lastName.getClass().getTypeName())
````
Nenhum ponto e vírgula é necessário porque o JShell é um ambiente interativo. Um ponto-e-vírgula é necessário apenas quando há várias instruções na mesma linha, ou instruções dentro de um tipo ou método declarado, veremos também alguns exemplos que necessitam de ponto-e-vírgula a seguir.

## tipo var e herança
Também podemos usar polimorfismo com os tipos var. No mundo da herança, um subtipo de tipo var pode ser atribuído ao supertipo de tipo var, como nos casos normais:
````
import javax.swing.*
var password = new JPasswordField("Password text")
String.valueOf(password.getPassword()) // To convert password char array to string to see the value
var textField = new JTextField("Hello text")
textField = password
textField.getText()
````
Mas um super tipo var não pode ser atribuído ao subtipo var, como o seguinte:
````
password = textField
````
Isso porque o JPasswordField é uma subclasse da classe JTextField.

var e a segurança em tempo de compilação
Tipos de variáveis incompatíveis não podem ser atribuídos uns aos outros. Depois que o compilador inferir o tipo real da var, não é possível atribuir um valor com um tipo diferente, exemplo:
````
       var number = 10
       number = "InfoQ"
````
O compilador substitui "var number = 10" por "int number = 10" para fazer as verificações, a segurança ainda é mantida.

## var com coleções e generics
Vejamos como funciona o var com inferência de tipo de elemento de coleção e generics. No caso a seguir, o compilador pode inferir qual é o tipo de elementos da coleção:
````
 var list = List.of(10);
 ````
Não há necessidade de conversão, pois o compilador infere o tipo de elemento correto int
````
int i = list.get(0); //equivalent to: var i = list.get(0);
````
No caso seguinte, a situação é diferente, o compilador só vai tomá-lo como coleção de objetos (não inteiros), porque no uso do operador diamante, o Java já precisa de um tipo no LHS (Left Hand Side) para inferir o tipo no RHS vamos ver como;
````
var list2 = new ArrayList<>(); list2.add(10); list2
int i = list2.get(0) //Compilation error
int i = (int) list2.get(0) //need to cast to get int back
````
No caso dos generics, é melhor usar um tipo específico (em vez de operador de diamante) no RHS como o seguinte:
````
var list3 = new ArrayList<Integer>(); list3.add(10); System.out.println(list3)
int i = list3.get(0)
````
A seguir veremos como o tipo var funciona dentro dos diferentes tipos de laços:

## tipo var dentro de laço for
Vamos verificar primeiro o For normal baseado em índice:
````
for (var x = 1; x <= 5; x++) {
           var m = x * 2; //equivalent to: int m = x * 2;
          System.out.println(m); 
}
````
## E agora usando o For Each:
````
var list = Arrays.asList(1,2,3,4,5,6,7,8,9,10)
    for (var item : list) {
          var m = item + 2;
          System.out.println(m);
}
````
Agora tenho uma pergunta, o var funciona com um Stream do Java 8? Vamos ver com o seguinte exemplo:
````
   var list = List.of(1, 2, 3, 4, 5, 6, 7)
   var stream = list.stream()
   stream.filter(x ->  x % 2 == 0).forEach(System.out::println)
   ````
## Tipo var com operador ternário
O var funciona com o operador ternário?
````
var x = 1 > 0 ? 10 : -10
int i = x 
````
E se usar diferentes tipos de operandos no RHS do operador ternário? Vamos ver:
````
var x = 1 > 0 ? 10 : "Less than zero"; System.out.println(x.getClass()) //Integer
var x = 1 < 0 ? 10 : "Less than zero"; System.out.println(x.getClass()) // String
````
Esses dois exemplos mostram que o tipo do var é decidido durante a execução? Absolutamente não! Vamos fazer a mesma coisa do jeito antigo:
````
Serializable x = 1 < 0 ? 10 : "Less than zero"; System.out.println(x.getClass())
````
Serializable, é um tipo comum compatível e o tipo mais especializado para dois operandos diferentes (só é menos especializado que o java.lang.Object).

Tanto a String como o Integer implementam Serializable. O Integer tem auto-boxer para int. Em outras palavras, Serializable é um LUB (Least Upper Bound) com dois operandos. Nesse terceiro e último exemplo, mostramos que o tipo var também é Serializable.

Vamos para o próximo assunto: passando o tipo var como parâmetro.

## tipo var com métodos
Vamos primeiro declarar um método chamado squareOf com um argumento do tipo BigDecimal, que retorna o quadrado desse argumento:
````
BigDecimal squareOf(BigDecimal number) {
      var result= number.multiply(number);
      return result;
  }
var number = new BigDecimal("2.5")
number = squareOf(number)
````

Agora vamos ver como funciona com generics; novamente, vamos declarar um método chamado toIntgerList com um argumento do tipo List do tipo T (um tipo genérico), que retorna uma lista baseada em números inteiros desse argumento usando a API do Streams da seguinte maneira:
````
<T extends Number> List<Integer> toIntgerList(List<T> numbers) {
               var integers = numbers.stream()
                                    .map(Number::intValue)
                                    .collect(Collectors.toList());
               return integers;
}

         var numbers = List.of(1.1, 2.2, 3.3, 4.4, 5.5)
         var integers = toIntgerList(numbers)
````
## var com classes anônimas
Por fim, vamos analisar o uso de var com classes anônimas. Aproveitemos a segmentação implementando a interface Runnable da seguinte forma:
````
   var message = "running..." //effectively final
         var runner = new Runnable(){
                  @Override
                  public void run() {
                           System.out.println(message);
                  }}

            runner.run()
 ````
Até agora, apresentei o novo tipo "var" do Java 10, que reduz a codificação, enquanto mantém a verificação de tipo de tempo de compilação do Java. E vimos alguns exemplos que mostram o que pode ser feito. Agora vejamos as limitações do tipo var e onde isso não é permitido.

## Limitações do tipo "var"
Agora vejamos alguns exemplos rápidos para entender o que não pode ser feito com o recurso do tipo var.

Os resultados do prompt do jshell explicarão o que há de errado com o código, para que possamos tirar proveito do feedback instantâneo interativo.

Não pode declarar um var sem inicializar o valor
Não é permitido declarar tipos var sem inicializar seu valor:
````
var name;
````
Ocorrerá um erro de compilação; porque o compilador não pode inferir o tipo da variável local x.

Não pode fazer declarações compostas
Tente executar essa linha:
````
var x = 1, y = 3, z = 4
````
Ocorrerá o erro: 'var' não é permitido em uma declaração composta.

## Atribuição não definitiva
Tente criar o método chamado testVar como o seguinte, apenas copie e cole o método no JShell:
````
   void testVar(boolean b) {
       var x;
       if (b) {
           x = 1;
       } else {
           x = 2;
       }
      System.out.println(x);
   }
   ````
Ele não criará o método e, em vez disso, lançará um erro de compilação. Não é possível usar 'var' na variável sem um inicializador. Mesmo tarefas como as seguintes (conhecidas como Definite Assignment) não funcionam com o tipo var.

## Atribuição null
Atribuição nula não é permitida, conforme mostrado a seguir:
````
var name = null;
````
Isto irá lançar uma exceção "inicialização da variável é 'null'". Porque nulo não é um tipo.

## Trabalhando com Lambdas
Outro exemplo, sem um inicializador Lambda. Isto é exatamente como o caso do operador diamante, o RHS precisa da inferência de tipo do LHS.
````
var runnable = () -> {}
````
Esta exceção será lançada: "expressão lambda precisa de um tipo explícito".

## var e referência de método
Nenhum inicializador de referência de método, semelhante às expressões lambda e operador diamante:
````
var abs = BigDecimal::abs
````
Esta exceção será lançada: "referência de método precisa de um tipo de alvo explícito".

## var e inicialização de array
Nem todos os inicializadores de array funcionam, vamos ver que o var com [] não funciona:
````
var numbers[] = new int[]{2, 4, 6}
````
O erro será: 'var' não é permitido como um tipo de elemento de um array.

O seguinte também não funciona:
````
var numbers = {2, 4, 6}
````
O erro é: “o inicializador do array precisa de um tipo de alvo explícito”

Assim como no último exemplo, var e [] não podem estar juntos em LHS:
````
var numbers[] = {2, 4, 6}
````
## Erro: 'var' não permite um elemento do tipo array. Somente a seguinte inicialização de áreas funciona:
````
var numbers = new int[]{2, 4, 6}
var number = numbers[1]
number = number + 3
Não é permitido campos var
class Clazz {
  private var name;
}
````
## Não é permitido parâmetros var
````
void doAwesomeStuffHere(var salary){}
````
## Não é permitido o tipo de retorno var
````
var getAwesomeStuff(){ return salary; }
````
## Não pode usar var na cláusula catch
````
      try {
         Files.readAllBytes(Paths.get("c:\temp\temp.txt"));
      } catch (var e) {}
  ````
O que acontece com o tipo var em tempo de compilação?
"var" é realmente apenas um acréscimo sintático e não introduz nenhuma construção de bytecode nova no código compilado e, durante o tempo de execução, a JVM não possui instruções especiais para eles.

Conclusão
Resumindo o artigo, foi abordado o que é o tipo "var" e como esse recurso reduz a codificação redundante, enquanto mantém a verificação de tipo em tempo de compilação do Java.

Em seguida, foi apresentado a nova ferramenta JShell, a implementação de REPL de Java, que ajuda a aprender rapidamente a linguagem Java e a explorar novas APIs e seus recursos. Também podemos prototipar código complexo usando o JShell, em vez do tradicional ciclo tedioso de edição, compilação e execução de código.

Por fim, menciono todos os recursos e limitações do tipo var, por exemplo, onde pode e não pode usá-lo.

Fonte: https://www.infoq.com/br/articles/java-10-var-type/
