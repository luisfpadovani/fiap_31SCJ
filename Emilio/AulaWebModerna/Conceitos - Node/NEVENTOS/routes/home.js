module.exports = function (app) {
    var valida = require('./../middlewares/valida');
    var home = app.controllers.home;  
    app.get('/', home.index);
    app.post('/login', home.login);
    app.get('/logout', home.logout); 
};