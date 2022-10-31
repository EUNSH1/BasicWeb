const buttons = document.querySelectorAll(".buttons");
console.log("start");

$("#home").click(function(){
    console.log("r")
});


$("#btn").click(function(){
    console.log("r")
});


for(let i =0; i<buttons.length; i++){
    console.log("for");

    $($('.buttons')[i]).click(function(){
        console.log(buttons[i].value);
    });
    
}

