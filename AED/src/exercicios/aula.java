package exercicios;

/**
 * Created by André on 07-10-2015.
 */
public class aula {

    public static int lowerBound(int[] table, int l, int r, int min){
        int m =((l+r)/2);
        if(l>r) return (min<table[m]) ? m: m+1;
        else{
            if(min==table[m]) return m;
            else if (min<table[m]) return lowerBound(table, l, m-1, min);
            else return lowerBound(table, m + 1, r, min);
        }
    }

    public static int upperBound(int[] table, int l, int r, int max){
        int m =((l+r)/2);
        if(l>r) return (max>table[m]) ? m: m-1;
        else{
            if(max==table[m]) return m;
            else if (max<table[m]) return upperBound(table, l, m-1, max);
            else return upperBound(table, m + 1, r, max);
        }
    }

    int distanceBetween(int[] table, int l, int r, int min, int max){

        int lower = lowerBound(table, l, r, min);
        int upper = upperBound(table, l, r, max);
        return (lower >= l && upper <= r) ? upper - lower + 1 : 0;
    }

    public static void main(String[] args)
    {
        int[] table = new int[] {2,5,7,12,15,20,22,30};
        System.out.println(lowerBound(table, 0, 7, 3));
    }

}
