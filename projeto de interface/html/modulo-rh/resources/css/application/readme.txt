� a pasta principal dos estilos da aplica��o. Podendo possuir na sua raiz pastas espec�ficas para diferentes layouts (e.g. 'hotsite, 'adminpanel', 'landing').

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