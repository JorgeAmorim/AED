package exercicios;

import java.util.Stack;

public class ExAulaListas {

    /**
     * Implemente o método estatico que recebe a string S e que verifica se os parentesis(curvos, retos e chavetas)
     * presentes em S, se encontram emparelhados e aninhados correctamente. O metodo retorna true em caso afirmativo.
     *
     * ex: "...(...{...)...}...[...]..." - false
     *     "...(...)...{...[...]...}...[...]..." - true
     */
    public static boolean verifyPaining(String S){
        Stack<Character> stx = new Stack<Character>();
        for(int i = 0; i<S.length(); i++){
            Character car = S.charAt(i);
            Character res = null;
            switch (car){
                case '(': case ')':
                    res = '(';
                    break;
                case '[': case']':
                    res = '[';
                    break;
                case '{':case '}':
                    res = '{';
                    break;
                default: res = null;
            }
            if(res == null);//outro caracter
            else if(res == car)//parentesis a abrir
                stx.push(car);
            else if(stx.isEmpty() || stx.pop() != res)//parentesis a fechar
                return false;
        }
        return stx.isEmpty();//para confirmar que n ficam parentesis no stack
    }

    public static void main(String args[]){
        String one = "...(...{...)...}...[...]...";
        String two = "...(...)...{...[...]...}...[...]...";

        System.out.println(verifyPaining(one));
        System.out.println(verifyPaining(two));
    }
}
