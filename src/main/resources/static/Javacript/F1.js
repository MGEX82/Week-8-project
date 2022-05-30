'use strict';

// Selectors
// Inputs
let inputYear = document.querySelector("#inputOne");
let inputName = document.querySelector("#inputTwo");
let inputNation = document.querySelector("#inputThree");
let inputTeam = document.querySelector("#inputFour");

// Buttons
let submitBtn = document.querySelector("#submitBtn");


// Divs
let mainDiv = document.querySelector("#mainDiv");

// Functionality
let year = () => {
    let valueYear = parseInt(inputYear.value);
    

    let valueDiv = document.createElement("div");
    

    valueDiv.appendChild(myValue);
    mainDiv.appendChild(valueDiv);
}
let name = () => {
    let valueName = parseString(inputName.value);
    

    let valueDiv = document.createElement("div");
    

    valueDiv.appendChild(myValue);
    mainDiv.appendChild(valueDiv);
}
let nation = () => {
    let valueNation = parseString(inputNation.value);
    

    let valueDiv = document.createElement("div");
    

    valueDiv.appendChild(myValue);
    mainDiv.appendChild(valueDiv);
}
let team = () => {
    let valueTeam = parseString(inputTeam.value);
    

    let valueDiv = document.createElement("div");
    

    valueDiv.appendChild(myValue);
    mainDiv.appendChild(valueDiv);
}


    



let clearResults = () => {
    mainDiv.innerHTML = "";
}

// Event Listeners
addBtn.addEventListener("click", add);
subtractBtn.addEventListener("click", subtract);
multiplyBtn.addEventListener("click", multiply);
divideBtn.addEventListener("click", divide);
clearBtn.addEventListener("click", clearResults);
squareBtn.addEventListener("click", square);
rootBtn.addEventListener("click", root);