package utils;

import java.util.ArrayList;
import models.NLPLine;

public class NLPFileAnalyzer {
	
	public void findDomains(ArrayList <NLPLine> file){
		
	}
	
	public void findSynsets( ArrayList <NLPLine> file){
		
		// Abrimos una conexion con WordNet, usando nuestra clase NLPWordNet 
		NLPWordNet wordNet = new NLPWordNet();
		
		// Si la conexi—n es exitosa, recuperamos los synsets asociados a cada token
		// en nuestro archivo
		if(wordNet.wordNetConnect()){
			
			for (NLPLine line : file) {
				
				line.setSynsets(wordNet.getWordSynset(line.getPosTag(), line.getToken()));
			}
		}
		
	}
}
