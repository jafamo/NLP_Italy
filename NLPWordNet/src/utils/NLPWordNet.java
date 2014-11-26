package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.dictionary.Dictionary;

public class NLPWordNet {
	
	private Dictionary wordnet;
	
	public Boolean wordNetConnect(){

		try {
			
			// Inciamos una conexi—n con wordnet usando nuestro archivo de propiedades 
			// <<file_properties.xml>> , en donde tenemos el PATH a la base de datos
			JWNL.initialize(new FileInputStream("assets/file_properties.xml"));
			
			// Inicializamos nuestro objeto <Dictionary>, el cual usaremos para conectarnos con WordNet
			this.wordnet = Dictionary.getInstance();
			
			return true;
			
		} catch (FileNotFoundException | JWNLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Set<String> getWordDomains(String labelPOS, String word){
		
		Set<String> wordDomains = new HashSet<String>();
		/*
		// Mapeamos el POS tag que recibimos por par‡metro, para que sea un label
		// compatible con WordNet
		POS wordNetLabel = this.mapPOSTag(labelPOS);
		
		// En caso de tener un label compatible, buscamos los dominios asociados con
		// la palabra recibida por parametro
		if(wordNetLabel != null){
			
			// Obtenemos los synsets asociados con la palabra
			Set<String> wordSynsets = this.getWordSynset(wordNetLabel,word);
			
			// Buscamos los dominios asociados con cada uno de los synsets de la palabra
			
			return wordSynsets;
		}
		*/
		return wordDomains;
	}
	
	public Set<String> getWordSynset(String labelPOS, String word){
		
		Set<String> wordSynsets = new HashSet<String>();
		
		// Mapeamos el POS tag que recibimos por par‡metro, para que sea un label
		// compatible con WordNet
		POS wordNetPOS = this.mapPOSTag(labelPOS);
				
		// En caso de tener un label compatible, buscamos los dominios asociados con
		// la palabra recibida por parametro
		if( wordNetPOS != null){
			
			try {
				
				// Usamos nuestro objeto <Dictionary> para encontrar los offsets de los synsets de una palabra
				IndexWord indexWord = this.wordnet.getIndexWord(wordNetPOS, word );
				
				// Si la palabra est‡ presente en nuestro el diccionario
				if(indexWord != null){
					long[] synsetOffsets =  indexWord.getSynsetOffsets();
					
					// Recorremos nuestro arreglo de offsets para encontrar los synset relacionados con
					// la palabra recibida por parametro
					for(int i = 0; i < synsetOffsets.length; i++){
						
						// Obtenemos el synset relacionado con un offset especifico
						Synset synset = wordnet.getSynsetAt(wordNetPOS, synsetOffsets[i]);
						
						// Recorremos cada una de las palabras contenidas en el synset[i] 
						for (int j = 0; j < synset.getWordsSize(); j++){
							Word synsetWord = synset.getWord(j);
							
							//Guardamos en nuestro Set, el lemma asociado con la palabra [j] en el synset
							wordSynsets.add(synsetWord.getLemma());
						}
					}	
				}
				
			} catch (JWNLException e) {
				System.out.println("No Dictionary has been loaded yet.");
				e.printStackTrace();
			}
			
		}
		
		
		return wordSynsets;
		
	}
	
	public POS mapPOSTag(String labelPOS){
		
		// Hacemos un switch sobre la primera letra del POS tag que recibimos por parametro.
		// Si la primera letra del tag no es ni: J, V , N — R, retornamos un valor nulo
		switch (labelPOS.charAt(0)) {
			case 'J':
				return POS.ADJECTIVE;
			case 'V':
				return POS.VERB;
			case 'N':
				return POS.NOUN;
			case 'R':
				return POS.ADVERB;
			default:
				return null;
		} 
		
	}
			
}
