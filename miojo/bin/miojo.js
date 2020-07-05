

    function  tempoPreparo(t, a, b) {
        var LIMITE_TEMPO = 5000;
    
        var x = 0;
        var y = 0;
        var contA = 0;
        var contB = 0;
        var tempoTotal;
    
        do {            
            if (x == 0) {
                x = a; 
                contA ++;
            }	
            if (y == 0) {
                y = b; 
                contB ++;
            }
            
            if(x > y) {
                x = x - y; 
                y = 0;
            }
            else {
                y = y - x; 
                x = 0;
            }
            
            if(x == t) {
                break;
            }
            
            if (y == t) {
                break;
            }
    
            
            if ( (a * contA >= LIMITE_TEMPO) || (b * contB >= LIMITE_TEMPO)) {
                console.log("Infelizmente atingimos o limite de tempo possível para calcular o tempo exato de preparo do Miojo.");
                break;				
            }
        } while (true);
    
        if ( (a * contA >= LIMITE_TEMPO) || (b * contB >= LIMITE_TEMPO)) {
            tempoTotal = 0;	
        }else {
            tempoTotal = Math.max(a * contA, b * contB);
        }
    
        return tempoTotal;
    
    }
    
module.exports = {tempoPreparo};
