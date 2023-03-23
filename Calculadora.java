import java.util.Scanner;

public class Calculadora implements Pilha {
    private char[] info = new char[];
    private char tipo;
    private String expressao;
    private int tamanho = 0;
    private ListaEncadeada<char> pilhaencad = new ListaEncadeada<>();
    private NoLista<char> primeiro;
    public NoLista<char> ultimo;
    private int qtdeElementos;


    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        expressao = leitor.nextLine();

        boolean validar = true; //Essa variável é só pra quitar do switch

        System.out.println("Selecione o tipo de Pilha que você quer usar. Selecione 1 para" +
                "lista estática, 2 para lista encadeada e 3 para sair.");
                tipo = leitor.nextLine();
        switch (tipo) {
            case 1: //Pilha Estática
                String str = "[ ";
                char c = null;
                for (int i = 0; i <= expressao.lenght(); i++) { 
                    c = expressao[i];
                    str += c + " ]";
                } 
                int X = 0;
                int Y = 0;
                int Z = 0;
                for (int i = 0; i <= expressao.lenght(); i++) {
                    if (expressao.charAt(i) >= '0' && expressao.charAt(i) <= '9') {
                    info.inserir(i);
                    tamanho++;
                }
                        if (info.lenght() == 2) {
                            X = info[tamanho - 1];
                            info.pop();
                            Y = info[tamanho - 1];
                            info.pop();
                        }
                        if (X == 0 || Y == 0) {
                            throw new RuntimeException("Não há operandos o suficiente para realizar a conta");
                        } else {
                        if (expressao[i] = '+') {
                            Z = X + Y;
                        } else if {
                            if(expressao[i] = '-') {
                                Z = X - Y;
                            } else if {
                                if (expressao[i] = '*') {
                                    Z = X * Y;
                                } else {
                                    if (expressao[i] = '/') {
                                        Z = X / Y;
                                    }
                                }
                            }
                        }
                    }
                        Z.info.inserir();
                }
                System.out.println("Resultado Final = " + info);
                validar = true;
            break;

            case 2: //Pilha Encadeada
                String str = "[ ";
                char c = null;
                for (int i = 0; i <= expressao.lenght(); i++) { 
                    c = expressao[i];
                    str += c + " ]";
                }
                int X = 0;
                int Y = 0;
                int Z = 0;
                char c = null;
                for (int i = 0; i <= expressao.lenght(); i++) {
                    c = expressao[i];
                    NoLista<char> novo = new NoLista();
                    novo.setInfo(c);
                        if (this.EstaVazia()) {
                            primeiro = novo;
                        } else {
                            ultimo.setProx(novo);
                        }
                        if (pilhaencad.lenght() == 2) {
                            X = pilhaencad[qtdeElementos - 1];
                            pilhaencad.retirar();
                            Y = pilhaencad[qtdeElementos - 1];
                            pilhaencad.retirar();
                        }
                        if (X == 0 || Y == 0) {
                            throw new RuntimeException("Não há operandos o suficiente para realizar a conta");
                        } else {
                        if (expressao[i] = '+') {
                            Z = X + Y;
                        } else if {
                            if(expressao[i] = '-') {
                                Z = X - Y;
                            } else if {
                                if (expressao[i] = '*') {
                                    Z = X * Y;
                                } else {
                                    if (expressao[i] = '/') {
                                        Z = X / Y;
                                    }
                                }
                            }
                        }
                    }
                System.out.println("Resultado Final = " + pilhaencad);        
                validar = true;
            break;

            case 3: //Quit
                System.out.println("Adeus");
                validar = false;
            break:

            default:
                validar = true;
            break;
        }
        leitor.close();
    }
}