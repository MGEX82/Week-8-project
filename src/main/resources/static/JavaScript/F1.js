'use strict';
//Inputs
let inputId = document.querySelector("#inputId");
let inputSeason = document.querySelector("#inputSeason");
let inputWinner = document.querySelector("#inputWinner");
let inputNation = document.querySelector("#inputNation");
let inputTeam = document.querySelector("#inputTeam");

// Selectors

let resultsDiv = document.querySelector("#results");
let IdentryDiv = document.querySelector("#Identry");
let SeasonentryDiv = document.querySelector("#seasonentry");
let ChampionentryDiv = document.querySelector("#championentry");
let NationentryDiv = document.querySelector("#nationentry");
let teamentryDiv = document.querySelector("#teamentry");
let getAllBtn = document.querySelector("#getAll");
let getByIdBtn = document.querySelector("#getById");
let getBySeasonBtn = document.querySelector("#getBySeason");
let getByWinnerBtn = document.querySelector("#getByWinner");
let getByYearBtn = document.querySelector("#getByYear");
let getByNationBtn = document.querySelector("#getByNation");
let getByTeamBtn = document.querySelector("#getByTeam");
let postBtn = document.querySelector("#post");
let putBtn = document.querySelector("#put");
let deleteBtn = document.querySelector("#delete");



// GET - READ
let getAllRequest = () => {
    axios.get("http://localhost:8080/champion/getAll")
        .then((response) => {
            console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
let getByIdRequest = () => {
    axios.get("http://localhost:8080/champion/getById/$`{inputId.value}`")
        .then((response) => {
            console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
let getBySeasonRequest = () => {
    axios.get("http://localhost:8080/champion/getBySeason/$`{inputSeason.value}`")
        .then((response) => {
             console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
let getByWinnerRequest = () => {
    axios.get("http://localhost:8080/champion/getByWinner/$`{inputWinner.value}`")
        .then((response) => {
             console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
let getByNationRequest = () => {
    axios.get("http://localhost:8080/champion/getByNation/$`{inputNation.value}`")
        .then((response) => {
            console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
let getByTeamRequest = () => {
    axios.get("http://localhost:8080/champion/getByTeam/$`{inputTeam.value}`")
        .then((response) => {
            console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}


// POST - CREATE
let postRequest = () => {

    let obj = {
        "season": inputSeason.value,
        "winner": inputWinner.value,
        "nation": inputNation.value,
        "team": inputTeam.value
    }

    axios.post("http://localhost:8080/champion/create", obj)
        .then((response) => {
            console.log(response);
            displayResult(response.data.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
// PUT/PATCH - UPDATE
let putRequest = () => {

    let obj = {
        "season": inputSeason.value,
        "winner": inputWinner.value,
        "nation": inputNation.value,
        "team": inputTeam.value
    }
axios.put("http://localhost:8080/champion/update/`${inputId.value}`", obj)
        .then((response) => {
            console.log(response);
            displayResult(response.data.data);
        })
        .catch((err) => {
            console.error(err);
        });

    }
// DELETE - DELETE
let deleteRequest = () => {

    let obj = {
        "season": inputSeason.value,
        "winner": inputWinner.value,
        "nation": inputNation.value,
        "team": inputTeam.value
    }
    axios.delete("http://localhost:8080/champion/delete/`${inputId.value}`", obj)
            .then((response) => {
                console.log(response);
                displayResult(response.data.data);
            })
            .catch((err) => {
                console.error(err);
            });
    
        }

let displayResult = (data) => {
    for (let entry of data) {
        const entryDiv = document.createElement("div");
        entryDiv.setAttribute("class", "entryDiv");
        const text = document.createTextNode(`ID: ${entry.id} | Year: ${entry.season} | Name: ${entry.winner} | Nation: ${entry.nation}| Team: ${entry.team}`);

        // const img = document.createElement("img");
        // img.setAttribute("src", entry.avatar);
        // img.setAttribute("class", "avatars");

        entryDiv.appendChild(text);
        resultsDiv.appendChild(entryDiv);
        // resultsDiv.appendChild(img);
    }
}

// Event Listeners
getAllBtn.addEventListener("click", getAllRequest);
getByIdBtn.addEventListener("click", getByIdRequest);
getBySeasonBtn.addEventListener("click", getBySeasonRequest);
getByWinnerBtn.addEventListener("click", getByWinnerRequest);
getByNationBtn.addEventListener("click", getByNationRequest);
getByTeamBtn.addEventListener("click", getByTeamRequest);
postBtn.addEventListener("click", postRequest);
putBtn.addEventListener("click", putRequest);
deleteBtn.addEventListener("click", deleteRequest);
