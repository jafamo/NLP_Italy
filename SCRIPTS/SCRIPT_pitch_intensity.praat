clearinfo
sound = selected ("Sound")
textgrid = selected ("TextGrid")

select sound
To Pitch... 0.0 75 500
Rename... pitch

select sound
To Intensity... 75 0.001
Rename... intensity

select textgrid
n1 = Get number of intervals... 1
n2 = Get number of intervals... 2
n3 = Get number of intervals... 3
j=1
k=1

printline Token Pitch Intensity Speaker DialogueAct
for i to n1
     tekst$ = Get label of interval... 1 i
     if tekst$ == "#"
	j = j+1
	k = k+1
    elsif tekst$ <> ""
	t1 = Get starting point... 1 i
	t2 = Get end point... 1 i
	totalPitch = 0
	totalIntensity=0
	intLength = (t2-t1)/0.01
	validPitchPoints = 0
	validIntensityPoints = 0

	for s to intLength
		time = t1 + s * 0.01
		temp = 0
		temp2 = 0 
		select Pitch pitch
		temp = Get value at time... 'time' Hertz Linear
		if temp <> undefined
		   validPitchPoints = validPitchPoints +1
             	   totalPitch = totalPitch + temp 
		endif
		
		select Intensity intensity
		temp2 =  Get value at time... 'time'  Cubic
		if temp2 <> undefined
	           validIntensityPoints = validIntensityPoints +1
             	   totalIntensity = totalIntensity + temp2 
		endif
	endfor

	averagePitch = round(totalPitch / validPitchPoints)
	averageIntensity = round(totalIntensity / validIntensityPoints)

	select textgrid
	endPointDialogueAct = Get end point... 2 j
	if endPointDialogueAct < t2
		j = j+1
	endif

	endPointSpeaker = Get end point... 3 k
	if endPointSpeaker < t2
		k = k+1
	endif

        dialogueAct$ = Get label of interval... 2 j
        speaker$ = Get label of interval... 3 k
      	printline 'tekst$'  'averagePitch' 'averageIntensity' 'speaker$' 'dialogueAct$'
       	select textgrid
    endif
endfor