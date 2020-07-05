
const crime = require('./crime');

const suspeitos = crime.getSuspeitos();
const locais = crime.getLocais();
const armas = crime.getArmas();


function cenaCrime(){
    let cena = []
    
    let suspeito = suspeitos[getRandom(suspeitos)]
    let local = locais[getRandom(locais)]
    let arma = armas[getRandom(armas)]

    cena.push(suspeito)
    cena.push(local)
    cena.push(arma)

    return cena
}

function criarTeoria(){
    let teoria = []
    
    let suspeito = suspeitos[getRandom(suspeitos)]
    let local = locais[getRandom(locais)]
    let arma = armas[getRandom(armas)]

    teoria.push(suspeito)
    teoria.push(local)
    teoria.push(arma)

    return teoria
}

function elaborarTeoria(teoria, chute){

    switch (chute) {
        case 1:
            suspeitos.splice(suspeitos.indexOf(teoria[0]), 1)
            teoria[0] = suspeitos[getRandom(suspeitos)]
            break;
        case 2:			
            locais.splice(locais.indexOf(teoria[1]), 1)
            teoria[1] = locais[getRandom(locais)]
            break;
        case 3:
            armas.splice(armas.indexOf(teoria[2]), 1)
            teoria[2] = armas[getRandom(armas)]
            break;
        default:
            break;
        }

    return teoria
}


function averiguarTestemunha(teoria, crime){
    let codigoTestemunha = []

    var CRIME_SOLUCIONADO = 0;
    var SUSPEITO_ERRADO = 1;
    var LOCAL_ERRADO = 2;
    var ARMA_ERRADA = 3;

    if (teoria[0] != crime[0]) {
        codigoTestemunha.push(SUSPEITO_ERRADO)
    }

    if (teoria[1] != crime[1]) {
        codigoTestemunha.push(LOCAL_ERRADO);
    }
    
    if (teoria[2] != crime[2]) {
        codigoTestemunha.push(ARMA_ERRADA);
    }

    if (codigoTestemunha.length == 0) {
        codigoTestemunha.push(CRIME_SOLUCIONADO);
    }

    return codigoTestemunha[getRandom(codigoTestemunha)];
}

function getRandom(array) {
    return Math.floor(Math.random() * array.length);
}


main()

async function main() {

    let contTeoria = 0

    let cena = cenaCrime()
    let teoria = criarTeoria()

    console.log(`Cena: ${cena}`)
    console.log("-----------------------------------------------------")
    console.log(`Teoria ${contTeoria + 1}: ${teoria[0]} - ${teoria[1]} - ${teoria[2]}`)

    //let result = averiguarTestemunha(teoria, cena)
    //console.log(`result: ${result}`)

    let solucionado = false;

    do {
        contTeoria ++
        let retorno = averiguarTestemunha(teoria, cena)
        if (retorno == 0) {
            solucionado = true;
        }else {
            teoria = elaborarTeoria(teoria, retorno);
            console.log(`Teoria ${contTeoria + 1}: ${teoria[0]} - ${teoria[1]} - ${teoria[2]}`)
        }
        
    } while (solucionado == false);

    console.log("-----------------------------------------------------")
    console.log(`O caso foi solucionado em ${contTeoria} teorias.`)



}