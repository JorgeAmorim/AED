package series.serie1.ex3;

public class CountWords {
	
	private int count; 
	private String word;

	public CountWords(){
		word=""; 
		count=0; 
	}
	public CountWords(int count, String word){
		this.count=count; 
		this.word=word; 
	}
	
	public void setCW(String aux, int cnt){
		this.count=cnt; 
		this.word=aux;
	}
	
	public int getCount(){ return this.count;}
	
	public String getWord(){ return this.word;}
}
