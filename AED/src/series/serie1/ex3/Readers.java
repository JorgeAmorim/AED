package series.serie1.ex3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Readers {

	public BufferedReader buffer; 
	private String word;
	public int pos;
	
	public Readers(){
		this.buffer=null; 
		this.word=""; 
	}
	
	public Readers(String path, int pos) {
		this.buffer=newBufferedReader(path); 
		word=""; 
		this.pos= pos;
	}
	
	public String getWord(){ return this.word;}

	public String getLine() throws IOException{return buffer.readLine();}
	
	public void setWord(String aux){ this.word=aux;}
	
	public BufferedReader newBufferedReader (String pathnameIn){
		BufferedReader inputStream = null;
		try{
			inputStream = new BufferedReader(new FileReader (pathnameIn));
		}
		catch(FileNotFoundException exception){
				System.out.println(" File was not found! ");
		}
		return inputStream; 
	}
}
