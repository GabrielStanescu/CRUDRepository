# CRUDRepository
Stanescu Gabriel
Grupa A

Tema Unit Tests

Am avut dificultati in crearea a 2 Bean-uri pentru User Repository, mai exact 
la extinderea/implementarea superclaselor. Am gasit o solutie prin care clasele 
"frunze" sa fie abstracte, doar ca nu erau recunoscute de profile. Am inteles
conceptul in sine, dar nu am reusit sa il implementez in aceasta tema. Prin urmare,
UnitTestele ruleaza pe serverul de database, deja populat.

Am lasat un fisier pentru popularea tabelelor.

Unele teste vor pica deoarece la rularea tuturor, se va crea cate un user nou,
iar un test verifica totalitatea initialelor, care depind, evident, de nr de useri.

Coverage-ul este relativ mic din cauza interfetelor care nu au niciun rol si din
cauza ca nu am implementat cateva teste care sunt de tipul Post Request. Nu am gasit
o modalitate prin care sa trimit un body de forma form-data fara sa primesc erori.