# language: no
Egenskap: Plasser ordre
 
Scenario: Trykk gjennomfør bestilling 
  Gitt at en bruker velger liten startpakke
    Når brukeren trykker på "gjennomfør bestilling"
    Så skal brukeren få en ordrebekreftelse
    Og ordrestatus skal opprettes

