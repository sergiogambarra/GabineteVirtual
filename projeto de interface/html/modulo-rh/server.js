// #: server.js
// #: carregando pré-requisitos
// #: definindo o server
var express = require('express'),
    path    = require('path'),
    app     = express();
    
// #: configurando a view engine para o tipo ejs
app.set('view engine', 'ejs');

// #: definindo o root para arquivos estáticos
app.use(express.static(__dirname + '/resources'));


// #: determinando a index page 
app.get('/', function(req, res) {
    res.render('pages/index');
});

// #: definindo rotas:
// #: login
app.get('/login', function(req, res) {
    res.render('pages/login');
});

// #: iniciando o server
// #: definindo a porta

//app.listen(process.env.PORT || 3000, process.env.IP || "0.0.0.0");
app.listen(8090);
console.log('8090 is the magic listen port');
