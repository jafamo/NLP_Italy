package utils;

import java.util.ArrayList;

import models.NLPLine;


public class NLPFileMapper {
	
	public ArrayList<NLPLine> parseRawFileToNLPFile (ArrayList<String> rawFile)
	{
		ArrayList<NLPLine> nlpLines = new ArrayList<NLPLine>();
		for (String line : rawFile) {
			
			String[] tokens = line.split(" ");
			NLPLine nlpLine = new NLPLine();
			nlpLine.setToken(tokens[0]);
			nlpLine.setPitch(tokens[1]);
			nlpLine.setIntensity(tokens[2]);
			nlpLine.setSpeaker(tokens[3]);
			nlpLine.setDialogueAct(tokens[4]);
			nlpLine.setPosTag(tokens[5]);
			nlpLines.add(nlpLine);
		}
		
		return nlpLines;
	}
	
	public ArrayList<String> parseNLPFileToRawFile(ArrayList<NLPLine> nlpFile)
	{
		ArrayList <String> rawFile = new ArrayList<String>();
		
		for(NLPLine line:nlpFile){
			String rawLine = line.toString();
			rawFile.add(rawLine);
		}
		
		return rawFile;
	}
}
