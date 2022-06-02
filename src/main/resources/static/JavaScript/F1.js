'use strict';



// Selectors

let resultsDiv = document.querySelector("#results");
let getAllBtn = document.querySelector("#getAll");
let getByIdBtn = document.querySelector("#getByID");
let getBySeasonBtn = document.querySelector("#getBySeason");
let getByWinner = document.querySelector("#getByWinner");
let getByYearBtn = document.querySelector("#getByYear");
let getByNationBtn = document.querySelector("#getByNation");
let getByTeamBtn = document.querySelector("#getByTeam");
let postBtn = document.querySelector("#post");
let putBtn = document.querySelector("#update");
let deleteBtn = document.querySelector("#delete");



// GET - READ
let getAllRequest = () => {
    axios.get("http://localhost:8080/champion/getAll")
        .then((response) => {
            // console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
let getByIdRequest = () => {
    axios.get("http://localhost:8080/champion/getById")
        .then((response) => {
            // console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
let getBySeasonRequest = () => {
    axios.get("http://localhost:8080/champion/getBySeason")
        .then((response) => {
            // console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
let getByWinnerRequest = () => {
    axios.get("http://localhost:8080/champion/getByWinner")
        .then((response) => {
            // console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
let getByNationRequest = () => {
    axios.get("http://localhost:8080/champion/getByNation")
        .then((response) => {
            // console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
let getByTeamRequest = () => {
    axios.get("http://localhost:8080/champion/getByTeam")
        .then((response) => {
            // console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}


// POST - CREATE
let postRequest = () => {

    let obj = {
        "season":"1950",
        "winner":"Nino Farina",
        "nation":"Italy",
        "team":"Alfa Romeo"
    }

    axios.post("http://localhost:8080/champion/create", obj)
        .then((response) => {
            console.log(response);
            // displayResult(response.data.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
// PUT/PATCH - UPDATE
let putRequest = () => {
axios.put("http://localhost:8080/champion/update", obj)
        .then((response) => {
            console.log(response);
            // displayResult(response.data.data);
        })
        .catch((err) => {
            console.error(err);
        });

    }
// DELETE - DELETE
let deleteRequest = () => {
    axios.delete("http://localhost:8080/champion/delete", obj)
            .then((response) => {
                console.log(response);
                // displayResult(response.data.data);
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
getByIDBtn.addEventListener("click", getByIdRequest);
getBySeasonBtn.addEventListener("click", getBySeasonRequest);
getByWinnerBtn.addEventListener("click", getByWinnerRequest);
getByNationBtn.addEventListener("click", getByNationRequest);
getByTeamBtn.addEventListener("click", getByTeamRequest);
postBtn.addEventListener("click", postRequest);
updateBtn.addEventListener("click", putRequest);
deleteBtn.addEventListener("click", deleteRequest);
