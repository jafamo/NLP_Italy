package models;

import java.util.Set;

public class NLPLine {
	private String token;
	private String pitch;
	private String intensity;
	private String speaker;
	private String dialogueAct;
	private String posTag;
	private String domain;
	private Set<String> synsets;
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	public String getIntensity() {
		return intensity;
	}
	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	public String getPitch() {
		return pitch;
	}
	public void setPitch(String pitch) {
		this.pitch = pitch;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public String getDialogueAct() {
		return dialogueAct;
	}
	public void setDialogueAct(String dialogueAct) {
		this.dialogueAct = dialogueAct;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getPosTag() {
		return posTag;
	}
	public void setPosTag(String posTag) {
		this.posTag = posTag;
	}
	
	public String toString(){
		
		String stringifiedLine = "";
		stringifiedLine += String.format("%-16s", this.token);
		stringifiedLine += String.format("%-16s", this.pitch);
		stringifiedLine += String.format("%-16s", this.intensity);
		stringifiedLine += String.format("%-16s", this.speaker);
		stringifiedLine += String.format("%-16s", this.dialogueAct);
		stringifiedLine += String.format("%-16s", this.posTag);
		// stringifiedLine += this.domain+ "\t";
		stringifiedLine += this.synsets.toString();
		return stringifiedLine;
	}

	public Set<String> getSynsets() {
		return synsets;
	}

	public void setSynsets(Set<String> synsets) {
		this.synsets = synsets;
	}
	
}
