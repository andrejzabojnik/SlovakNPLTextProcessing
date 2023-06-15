# SlovakNPLTextProcessing

Náš projekt spočíval v tvorbe NLP (natural-language-processing) aplikácie pre slovenský jazyk, ktorá je schopná spracovávať text a vykonávať s ním rôzne procesy. Ako programovací jazyk sme si zvolili javu, pretože má veľké množstvo knižníc a mali sme v nom najviac skusenosti. Aplikácia bola navrhnutá na princípe backendu za použitia java knižnice Jcommander, ktorá umožňuje komunikovať s našou aplikáciou bez použitia grafického rozhrania. Je ju možné teda spustiť v príkazovom riadku ako jar súbor s rôznymi parametrami. Obsahuje niekoľko funkcií, ako napríklad:
Tokenizácia – rozdelenie textu na slová spúšta sa cez parameter -token.
Segmentácia – rozdelenie textu na vety spúšta sa cez parameter -extsents 
Lematizácia – zistenie základného tvaru slova parameter -lemma 
 Morfologická analýza – zistenie základných informácii o slove ako napríklad slovný druh, rod, číslo, pád, čas a podobne parameter -analyze 
Pri návrhu funkcií tokenizácie a segmentácie sme museli ručne naprogramovať algoritmy, ktoré by dokázali rozdeliť text na slová a vety podľa pravidiel slovenského jazyka. Okrem toho sme museli vytvoriť zoznam slovenských skratiek a titulov, ako napríklad Bc., Mgr., Ing., atď., aby sme vedeli rozpoznať, kedy sa jedná o koniec vety a kedy nie.
Posledne dve funkcie boli spravené pomocou nástroja Morphodita ktorý je nástroj pre automatickú analýzu morfologických a syntaktických vlastností textu. Je to open-source nástroj vyvinutý na Univerzite Karlovej v Prahe a je k dispozícii ako knižnica pre rôzne programovacie jazyky vrátane javy.
Naša aplikácia dokáže načítať vstupný text zo súboru, ktorý zadáme pomocou parametra -input. Potom máme na výber niekoľko možností, ako zobraziť alebo uložiť výstupný text po spracovaní.
-newFile: Tento parameter vytvorí nový súbor a zapíše do neho výstupný text
-change Tento parameter prepíše pôvodný súbor text.txt a nahradí jeho obsah výstupným textom.
-print: Tento parameter vypíše výstupný text na príkazový riadok
Okrem toho sme pridali aj nepovinný parameter -lowercase, ktorý prevedie všetky veľké písmená výstupného textu na malé písmená. Tento parameter môžeme kombinovať s akoukoľvek z predchádzajúcich možností.
