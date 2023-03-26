import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        char tipo = 'a';
        String expressao = " ";
        int tamanho = 0;
        System.out.println("Insira a expressao pos fixa");
        Scanner teclado = new Scanner(System.in);
        expressao = teclado.next() + teclado.nextLine();
        while (tipo != 'e' && tipo != 'E' && tipo != 'd' && tipo != 'D') {
            System.out.println("Digite 'E' para usar a pilha estática ou 'D' para a pilha dinâmica");
            tipo = teclado.next().charAt(0);

            if (tipo != 'e' && tipo != 'E' && tipo != 'd' && tipo != 'D') {
                System.out.println("Deve ser digitado 'E' ou 'D', tente novamente");
            }
        }

        Pilha<Double> pilha;
        switch(tipo) {
            case 'e':
             pilha = new PilhaVetor<>();
            break;
            case 'E':
             pilha = new PilhaVetor<>();
            break;
            case 'd':
             pilha = new PilhaLista<>();
            break;
            case 'D':
            pilha = new PilhaLista<>();
            break;
            default:
             pilha = new PilhaLista<>();
        }

        int i = 0;
        Double primeiroNum = 0.0;
        Double segundoNum = 0.0;

        String[] elementos = expressao.split(" ");


        while (i < elementos.length) {
                if (!elementos[i].equals("-") && !elementos[i].equals("+") && !elementos[i].equals("*") &&  !elementos[i].equals("/")) {
                    pilha.push(Double.valueOf(elementos[i])); 
                    tamanho++;
                } else {
                    if (elementos[i].equals("-") || elementos[i].equals("+") || elementos[i].equals("*") || elementos[i].equals("/") 
                    && elementos[i + 1].equals("-") || elementos[i + 1].equals("+") || elementos[i + 1].equals("*") 
                    || elementos[i + 1].equals("/")) {
                        if (tamanho == 2 && elementos[i].equals("-") || elementos[i].equals("+") || elementos[i].equals("*") || elementos[i].equals("/")) {
                            if (elementos[i].equals("/")) {
                                if (tamanho != 1 && tamanho <= 3) {
                                segundoNum = pilha.pop();
                                tamanho--;
                                primeiroNum = pilha.pop();
                                tamanho--;
                                pilha.push(primeiroNum / segundoNum);
                                tamanho++;
                                } else {
                                    throw new IllegalArgumentException("Expressão incorreta");
                                }
                            } else {
                                if (elementos[i].equals("+")) {
                                    if (tamanho != 1 && tamanho <= 3) {
                                        segundoNum = pilha.pop();
                                        tamanho--;
                                        primeiroNum = pilha.pop();
                                        tamanho--;
                                    pilha.push(primeiroNum + segundoNum);
                                    tamanho++;
                                    } else {
                                        throw new IllegalArgumentException("Expressão incorreta");
                                    }
                                } else {
                                    if (elementos[i].equals("-")) {
                                        if (tamanho != 1 && tamanho <= 3) {
                                            segundoNum = pilha.pop();
                                            tamanho--;
                                            primeiroNum = pilha.pop();
                                            tamanho--;
                                        pilha.push(primeiroNum - segundoNum);
                                        tamanho++;
                                        } else {
                                            throw new IllegalArgumentException("Expressão incorreta");
                                        }
                                    } else {
                                        if (elementos[i].equals("*")) {
                                            if (tamanho != 1 && tamanho <= 3) {
                                                segundoNum = pilha.pop();
                                                tamanho--;
                                                primeiroNum = pilha.pop();
                                                tamanho--;
                                            pilha.push(primeiroNum * segundoNum);
                                            tamanho++;
                                            } else {
                                                throw new IllegalArgumentException("Expressão incorreta");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Espressão invalida, deve haver 2 valores na pilha para realizar um calculo");
                    }
                }        
            i++;
        }

        System.out.println("Resultado: " + pilha.peek());
        teclado.close();
    }

}
