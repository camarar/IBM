#!/usr/bin/env node
'use strict';

const app = require('commander');
const inquirer = require('inquirer');
const miojo = require('./miojo');

const receiver = () => {
    inquirer.prompt([
        {
            type : 'input',
            name : 'tempoMiojo',
            message : 'Informe o tempo de preparo do Miojo: '
        },  
         {
            type : 'input',
            name : 'ampulheta1',
            message : 'Informe o tempo da primeira ampulheta: '
          },
          {
            type : 'input',
            name : 'ampulheta2',
            message : 'Informe o tempo da segunda ampulheta: '
          }
    ]).then(answer => {
        if (answer.tempoMiojo == answer.ampulheta1 || answer.tempoMiojo == answer.ampulheta2) {
            console.log(`O tempo total para o preparo é :  ${answer.tempoMiojo}  minutos`)
        }else if(answer.ampulheta1 == answer.ampulheta2) {
            console.log("O tempo total para o preparo do Miojo não será possível calcular pois as ampulhetas são do mesmo tempo!")
        }else{
            let result = miojo.tempoPreparo(answer.tempoMiojo, answer.ampulheta1, answer.ampulheta2)
            if (result == 0) {
                console.log("O tempo total para o preparo do Miojo não será possível calcular o tempo exato com as ampulhetas disponíveis!")
            }else {
                console.log(`"O tempo total para o preparo é :  ${result}  minutos`)
            }
        }
    });

};



main()

    async function main() {

    try {
        app
            .version('1.0')
            .action(receiver);

        app.parse(process.argv);
        
    } catch (error) {
        console.error('Alguns erros foram encontrados.', error)
    }


}



