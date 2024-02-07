function rps(){
    const randomNumber = Math.random();

        let computerMove = '';

        if(randomNumber >= 0 && randomNumber < 1/3){
            computerMove = 'rock';
        }else if(randomNumber >= 1/3 && randomNumber < 2/3){
            computerMove = 'paper';
        }else if(randomNumber >= 2/3 && randomNumber < 1){
            computerMove = 'scissors';
        }
    
        console.log(computerMove);
        let myMove ='';
        let result ='';
        if(myMove === 'rock'){
            if(computerMove === 'rock'){
                result = 'Tie'; 
            }else if(computerMove === 'paper'){
                result = 'lose'; 
            }else if(computerMove === 'scissors'){
                result = 'win';
            }
        }else if(myMove === 'paper'){
            if(computerMove === 'rock'){
                result = 'win'; 
            }else if(computerMove === 'paper'){
                result = 'Tie '; 
            }else if(computerMove === 'scissors'){
                result = 'lose'; 
            }
        }else if(myMove === 'scissors'){
            if(computerMove === 'rock'){
                result = 'lose'; 
            }else if(computerMove === 'paper'){
                result = 'win'; 
            }else if(computerMove === 'scissors'){
                result = 'Tie'; 
            }
        }
        
        alert(`คุณเลือก ${myMove} คอมพิวเตอร์ ${computerMove},${result}`);

    }