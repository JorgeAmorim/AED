package exercicios;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ExIterators {

    /**
     * Realize um método que dada a sequência representada por src, retorna um iteravel com os
     * elementos  <= value existentes na sequencia onrdenada crescentemente. A sequencia a
     * retornar nao deverá coneter elementos repetidos. A implementação deste método deve
     * minimizar o espaço ocupado no iterável. O iterador nao suporta o método remove.
     */
    public static Iterable<Integer> getValuesLessThan(final Iterable<Integer> src, final int value){

        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {

                    Iterator<Integer> it = src.iterator();
                    Integer prev, curr;

                    @Override
                    public boolean hasNext() {
                        while(curr == null){
                            if(it.hasNext()) {
                                curr = it.next();
                                if(curr > value)
                                    return false;
                                if(curr == prev)
                                    curr = null;
                            }
                            else
                                return false;
                        }
                        return true;
                    }

                    @Override
                    public Integer next() {
                        if(!hasNext()) throw new NoSuchElementException();
                        Integer aux = curr;
                        curr = null;
                        return aux;
                    }
                };
            }
        };
    }

    /**
     * Realize o metodo estatico que retorna um iteravel com todos os elementos que satisfazem o predicado pred
     * https://commons.apache.org/proper/commons-collections/javadocs/api-3.2.1/org/apache/commons/collections/Predicate.html
     */
    public static Iterable<Integer> getValues2(final Iterable<Integer>src, final Predicate<Integer> pred){
        return new Iterable<Integer>(){
            public Iterator<Integer> iterator()
            {
                return new Iterator<Integer>()
                {
                    Iterator<Integer> it = src.iterator();
                    Integer curr;
                    @Override
                    public boolean hasNext()
                    {
                        while(curr == null)
                        {
                            if(it.hasNext())
                                curr = it.next();
                            //PRED???
                           // if (!(pred.evaluate(curr)))
                              //  curr=null;

                        }
                        return true;
                    }
                    @Override
                    public Integer next() {
                        return null;
                    }
                };
            }
        };
    }

    /**
    * Realize um metodo que dada a sequencia representada por src, retorna um iteravel em que os elementos
    * pares que ocorrem em src, precedem os elementos impares. A sequencia src pode ser percorrida mais do que
    * uma vez
     */
    public static Iterable<Integer> evenOdd(final Iterable<Integer>src) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator()
            {
                return new Iterator<Integer>()
                {
                    Iterator<Integer>it = src.iterator();
                    Integer curr;
                    boolean isEven = true; //duas voltas, primeira a procura dos pares e depois nos impares
                    public boolean hasNext() {
                        while (curr == null) {
                            if (it.hasNext()) {
                                curr = it.next();
                                if ((curr % 2 == 0) != isEven)
                                    curr = null;
                            } else //tenho um valor para devolver
                                if (isEven) //vou recomecar do principio para impares
                                {
                                    it = src.iterator();
                                    isEven = false;
                                } else
                                    return false;
                        }
                        return true;
                    }

                    @Override
                    public Integer next() {
                        return null;
                    }
                };
            }
        };
    }

    /**
     * Realize o método estático que retorna um iteravel com os elementos da sequencia src que ocorram
     * antes do primeiro elemento que nao verifique o preicado pred Ex: src{2,4,6,1,3,2} Se o predicado
     * devolver false quando o numero for impar, o objecto retornado deve representar a sequencia {2,4,6}
     */
    public static Iterable<Integer> takeWhile(final Iterable<Integer> src, final Predicate<Integer> pred){
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    Iterator<Integer> it = src.iterator();
                    Integer curr;
                    boolean stop = false;

                    @Override
                    public boolean hasNext() {
                        while(curr == null){
                            if(stop)
                                return false;
                            if(it.hasNext()){
                                curr = it.next();
                                //if(!pred.evaluate(curr)){
                                   // curr = null;
                                   // stop = true;
                                //}
                            }
                            else return false;
                        }
                        return true;
                    }

                    @Override
                    public Integer next() {
                        if(!hasNext()) throw new NoSuchElementException();
                        Integer aux = curr;
                        curr = null;
                        return aux;
                    }
                };
            }
        };
    }

    /**
     * Realize o metodo que retorna um iteravel com todos os elementos que satisfazem o predicado pred,
     * presentes na sequencia equivalente a concatenaçao das sequencias presentes em src.
     * Exemplo: {{"mar", "terra" "sol"}, {"universo", "galaxia"}, {"marte", "mercurio", "urano"}, {"meteorito", "astro", "mar"}}
     * se o predicado devolver true quando a sequencia tiver o prefixo "mar".
     * resultado:{"mar terra sol", "marte}
     */
    public static Iterable<String> getValues(final Iterable<Iterable<String>> src, final Predicate<String> pred){
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    Iterator<Iterable<String>> it = src.iterator();
                    String curr = null;

                    @Override
                    public boolean hasNext() {
                        while (curr == null){
                            if(it.hasNext()){
                                curr = "";
                                Iterator<String> itStr = it.next().iterator();
                                while (itStr.hasNext()) curr += itStr.next() + " ";
                               // if(!pred.evaluate(curr)) curr = null;
                            }
                            else return false;
                        }
                        return true;
                    }

                    @Override
                    public String next() {
                        if(!hasNext()) throw new NoSuchElementException();
                        String aux = curr;
                        curr = null;
                        return aux;
                    }
                };
            }
        };
    }
}

