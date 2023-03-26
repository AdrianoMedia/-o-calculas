//ainda não testado

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        char tipo = 'a';
        String expressao = " ";
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
                    if (pilha.length() == 2 && elementos[i].getProx().isDigit) {
                        segundoNum = pilha.pop();
                        primeiroNum = pilha.pop();
                        throw new RuntimeException("Expressão invalida, tente novamente");
                    }

                    if (pilha.length() == 1 && elementos[i].getProx().equals("-") || elementos[i].getProx().equals("+") || elementos[i].getProx().equals("*")
                     || elementos[i].getProx().equals("/")) {
                        primeiroNum = pilha.pop();
                        throw new IllegalArgumentException("A expressão deve ser escrita na forma pós-fixa");
                    }

                    if (elementos[i].equals("-") || elementos[i].equals("+") || elementos[i].equals("*") || elementos[i].equals("/") 
                    && elementos[i].getProx().equals("-") || elementos[i].getProx().equals("+") || elementos[i].getProx().equals("*") 
                    || elementos[i].getProx().equals("/") ||) {
                        if (pilha.length() == 2 && elementos[i].equals("-") || elementos[i].equals("+") || elementos[i].equals("*") || elementos[i].equals("/")) {
                            if (elementos[i].equals("/")) {
                                segundoNum = pilha.pop();
                                primeiroNum = pilha.pop();
                                pilha.push(primeiroNum / segundoNum);
                            } else {
                                if (elementos[i].equals("+")) {
                                    segundoNum = pilha.pop();
                                    primeiroNum = pilha.pop();
                                    pilha.push(primeiroNum + segundoNum);
                                } else {
                                    if (elementos[i].equals("-")) {
                                        segundoNum = pilha.pop();
                                        primeiroNum = pilha.pop();
                                        pilha.push(primeiroNum - segundoNum);
                                    } else {
                                        if (elementos[i].equals("*")) {
                                            segundoNum = pilha.pop();
                                            primeiroNum = pilha.pop();
                                            pilha.push(primeiroNum * segundoNum);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    pilha.push(Double.valueOf(elementos[i])); 
                } else {
                    if (elementos[i].equals("/")) {
                        segundoNum = pilha.pop();
                        primeiroNum = pilha.pop();
                        pilha.push(primeiroNum / segundoNum);
                    } else {
                        if (elementos[i].equals("+")) {
                            segundoNum = pilha.pop();
                            primeiroNum = pilha.pop();
                            pilha.push(primeiroNum + segundoNum);
                        } else {
                            if (elementos[i].equals("-")) {
                                segundoNum = pilha.pop();
                                primeiroNum = pilha.pop();
                                pilha.push(primeiroNum - segundoNum);
                            } else {
                                if (elementos[i].equals("*")) {
                                    segundoNum = pilha.pop();
                                    primeiroNum = pilha.pop();
                                    pilha.push(primeiroNum * segundoNum);
                                }
                            }
                        }
                    }
                }        
            i++;
        }

        System.out.println("Resultado: " + pilha.peek());
        teclado.close();
    }

}
