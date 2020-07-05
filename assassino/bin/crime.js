
function getSuspeitos(){
    const suspeitos = []

    suspeitos.push("Charles B. Abbage");
    suspeitos.push("Donald Duck Knuth");
    suspeitos.push("Ada L. Ovelace");
    suspeitos.push("Alan T. Uring");
    suspeitos.push("Ivar J. Acobson");
    suspeitos.push("Ras Mus Ler Dorf");

    return suspeitos
}

function getLocais(){
    const locais = []

    locais.push("Redmond");
    locais.push("Palo Alto");
    locais.push("San Francisco");
    locais.push("Tokio");
    locais.push("Restaurante no Fim do Universo");
    locais.push("São Paulo");
    locais.push("Cupertino");
    locais.push("Helsinki");
    locais.push("Maida Vale");
    locais.push("Toronto");

    return locais
}

function getArmas(){
    const armas = []

    armas.push("Peixeira");
    armas.push("DynaTAC 8000X");
    armas.push("Trezoitão");
    armas.push("Trebuchet");
    armas.push("Maça");
    armas.push("Gládio");
    
    return armas
}

module.exports = {getSuspeitos, getLocais, getArmas};



