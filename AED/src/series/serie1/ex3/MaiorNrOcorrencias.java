package series.serie1.ex3;


import java.io.IOException;
import java.io.PrintWriter;

public class MaiorNrOcorrencias {
	
	static CountWords [] cw;
	static Readers[] rd;
	
	public static void main(String[] args) throws IOException{
		long beggin = System.currentTimeMillis();
		System.out.println("Beginning at " + beggin);
	
		PrintWriter writer = new PrintWriter(args[0]);
		int idx = Integer.parseInt(args[1]);
		cw = new CountWords[idx];
		rd = new Readers[args.length - 2];

		for(int i=0; i<cw.length; i++){ // inicializar CountWords para nao haver comparaçoes com null
			cw[i]=new CountWords();
		}
		for(int i=0; i<rd.length; i++){ 
			rd[i]=new Readers();
		}
		for(int i=rd.length-1;i>=0; i--){ //inicializar os bufferes
			rd[i]=new Readers(args[i+2], i);
			rd[i].setWord(rd[i].buffer.readLine());	
			minHeapifyReaders(rd, 0 , rd.length);
		}
		compareWords();		
		creatUnionOfFiles(cw, writer);
		
		long ending = System.currentTimeMillis();
		long dif = ending-beggin;
		System.out.println("Finish at " +  ending);
		System.out.println("RunTime " + dif + "ms");
	}

	public static void compareWords() throws IOException{
		int count=0, sizeRD= rd.length, sizeCW=cw.length;
		String lineToCompare="", line="";
		boolean first = true;
		while((lineToCompare=rd[0].getWord())!=null){
			if(first){
				line=lineToCompare;
				first=false;
			}
			if(lineToCompare.equals(line)){
				++count;
				line= rd[0].getLine();
				rd[0].setWord(line);
				if(line==null){
					rd[0].buffer.close();
					Readers temp= rd[0];
					rd[0]= rd[sizeRD-1];
					rd[sizeRD-1]= temp;
					--sizeRD;
				}
				minHeapifyReaders(rd, 0, sizeRD);
				//System.out.println(rd[0].pos);
				line=rd[0].getWord();
				if(lineToCompare.equals(line))
					continue;
			}
			else{
				lineToCompare=line;
				rd[0].setWord(line);
				minHeapifyReaders(rd, 0, sizeRD);
				//System.out.println(rd[0].pos);
			}
			if(sizeCW>0){
				cw[sizeCW-1].setCW(lineToCompare, count);
				minHeapify(cw, sizeCW-1, cw.length);
				--sizeCW;
				count=0;
			}
			if(count>cw[0].getCount() && sizeCW == 0){
				cw[0].setCW(lineToCompare, count);
				minHeapify(cw, 0, cw.length);	
			}
			count=0;
		}
	}
	
	public static void  minHeapify(CountWords []minHeap, int parentIndex, int hSize){
        int left = (2*parentIndex)+1;
        int right = (2*parentIndex)+2;
        int smallest = parentIndex;
        
        if(left<hSize && minHeap[left].getCount()<minHeap[parentIndex].getCount())
            smallest = left;
        if(right<hSize && minHeap[right].getCount()<minHeap[smallest].getCount())
            smallest = right;
        if(smallest ==parentIndex)
        	return;
        
        CountWords tmp = minHeap[parentIndex];
        minHeap[parentIndex] = minHeap[smallest];
        minHeap[smallest] = tmp;
        minHeapify(minHeap,smallest,hSize);

    }
	
	public static void minHeapifyReaders(Readers []minHeap, int parentIndex, int hSize){
        int left = (2*parentIndex)+1;
        int right = (2*parentIndex)+2;
        int smallest = parentIndex;
        
        if(left<hSize && minHeap[left].getWord().compareTo(minHeap[parentIndex].getWord())<0)
            smallest = left;
        if(right<hSize && minHeap[right].getWord().compareTo(minHeap[smallest].getWord())<0)
            smallest = right;
        if(smallest == parentIndex)
        	return;
        Readers tmp = minHeap[parentIndex];
        minHeap[parentIndex] = minHeap[smallest];
        minHeap[smallest] = tmp;
        minHeapifyReaders(minHeap,0, hSize);
	}
	
	private static void creatUnionOfFiles(CountWords[] cw2, PrintWriter writer) {
		for(int i=0; i<cw2.length; ++i){
			if(cw2[i].getCount()>0)
				writer.println(cw2[i].getWord()+" - "+cw2[i].getCount());
		}
		writer.close(); 
	}
}

