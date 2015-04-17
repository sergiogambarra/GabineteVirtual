É a pasta principal dos estilos da aplicação. Podendo possuir na sua raiz pastas específicas para diferentes layouts (e.g. 'hotsite, 'adminpanel', 'landing').

- appplication
|- adminpanel
 |- [...]
|- hotsite
 |- [...]
|- landing
 |- [...]


#Exemplo

/*---------------------
/*  Application styles
/*---------------------
@import "application/layout"
@import "application/typography"

@import "application/objects/button"
..........
@import "application/modules/article"
..........