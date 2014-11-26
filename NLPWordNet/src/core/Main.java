package core;

import java.util.ArrayList;
import models.NLPLine;
import utils.NLPFileAnalyzer;
import utils.NLPFileMapper;
import utils.NLPFileReader;
import utils.NLPFileWritter;


public class Main {
	
	public static void main(String [] args){
		
		// Abrimos el archivo "input.txt" y lo alamcenamos como un ArrayList <String>
		System.out.println("Open File");
		NLPFileReader fileReader = new NLPFileReader();
		ArrayList<String> rawFile = fileReader.readFile("assets/input.txt");
		
		// Mapeamos el contenido de nuesto ArrayList <String> y lo convertimos en un
		// ArrayList <NLPLine>
		System.out.println("Processing Contents");
		NLPFileMapper fileMapper = new NLPFileMapper();
		ArrayList<NLPLine> nlpFile = fileMapper.parseRawFileToNLPFile(rawFile);
		
		// Buscamos los sysnsets asociados con cada token presente en nuestro archivo
		NLPFileAnalyzer domainFinder = new NLPFileAnalyzer();
		domainFinder.findSynsets(nlpFile);
		
		// Escribimos en el archivo "output.txt" los resultados del analisis 
		System.out.println("Writing Results");
		NLPFileWritter fileWritter = new NLPFileWritter();
		ArrayList<String> editedRawFile = fileMapper.parseNLPFileToRawFile(nlpFile);
		String headers = String.format("%-16s","Token")+
						 String.format("%-16s","Pitch")+
						 String.format("%-16s","Intensity")+
						 String.format("%-16s","Speaker")+
						 String.format("%-16s","DialogueAct")+
						 String.format("%-16s","POS")+
						 String.format("%-16s","Synset");
		fileWritter.writeFile("assets/output.txt",editedRawFile, headers);
	}
}
